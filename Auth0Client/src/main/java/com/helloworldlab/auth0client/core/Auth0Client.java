package com.helloworldlab.auth0client.core;

import com.helloworldlab.auth0client.core.containers.Auth0LoginResult;
import com.helloworldlab.auth0client.core.containers.Auth0ResultHolder;
import com.helloworldlab.auth0client.core.containers.EmailPasswordHolder;
import com.helloworldlab.auth0client.core.utils.DeviceId;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit.RestAdapter;
import retrofit.RetrofitError;


/**
 * @author Ivan Aläxkin (ivan.alyakskin@gmail.com)
 */
public class Auth0Client extends Auth0Base {
  private static final String TAG = "[Auth0Client]";

  private final String mDomain;
  private final String mClientId;

  protected boolean     mWithOfflineMode;
  protected RestAdapter mRestAdapter;

  /**
   *
   * @param domain sub-domain of your project on auth0.com (full)
   * @param clientId client id for domain
   * @param withOfflineMode true if need offline mode
   */
  public Auth0Client( String domain, String clientId, boolean withOfflineMode ) {
    mDomain = domain;
    mClientId = clientId;
    mRestAdapter = new RestAdapter.Builder().setEndpoint( domain ).build();
    mWithOfflineMode = withOfflineMode;
  }

  /**
   *
   * @param domain sub-domain of your project on auth0.com (full)
   * @param clientId client id for domain
   */
  public Auth0Client(String domain, String clientId) {
    this(domain, clientId, false);
  }

  protected boolean isWithOfflineMode( String scope ) {
    return mWithOfflineMode && !scope.contains("offline_access");
  }

  public Auth0ResultHolder loginSyncWithEmailPassword( final EmailPasswordHolder emailPasswordHolder ) {
    return loginSync( emailPasswordHolder.getEmail(), emailPasswordHolder.getPassword() , "openid" );
  }

  protected Auth0ResultHolder loginSync( String userName, String password, String scope ) {
    boolean networkException = false;
    boolean somethingWentReallyWrong = false;
    Auth0ResultHolder resultHolder;
    Auth0LoginResult loginResult = Auth0LoginResult.simulateWrongCredentials("");
    Auth0User auth0User = null;

    try {
      IAuth0Client iAuth0Client = mRestAdapter.create( IAuth0Client.class );
      if ( isWithOfflineMode( scope ) ) {
        loginResult = iAuth0Client.oauthWithOfflineWork(
            getClientId(),
            userName,
            password,
            "Username-Password-Authentication",
            "password",
            ( isWithOfflineMode( scope ) ? scope + " offline_access" : scope ),
            DeviceId.getDeviceId()
        );
      } else {
        loginResult = iAuth0Client.oauth(
            getClientId(),
            userName,
            password,
            "Username-Password-Authentication",
            "password",
            scope
        );
      }

      if( null != loginResult && loginResult.isSuccessful( ) ) {
        auth0User = iAuth0Client.getUserInfo( loginResult.access_token );
      }
    } catch ( RetrofitError retrofitError ) {
      /**
       * Yes, this is paranoid stuff with null pointer check & etc, but I don't want cause NPE
       */
      if (  ( null != retrofitError.getResponse() && HttpURLConnection.HTTP_UNAUTHORIZED  == retrofitError.getResponse( ).getStatus() ) ||
            ( null != retrofitError.getMessage() && retrofitError.getMessage().contains("authentication challenge") )
      ) {
        loginResult = Auth0LoginResult.simulateWrongCredentials( retrofitError.getMessage( ) );
      /**
       * Here we are when there is no connectivity
       */
      } else if ( retrofitError.isNetworkError( ) ) {
        networkException = true;
        e(TAG, " Network problem : " + retrofitError.getMessage(), retrofitError );
      /**
       * Can't imagine what it can be
       */
      } else {
        e( TAG, " Something went really wrong : " + retrofitError.getMessage() , retrofitError );
        somethingWentReallyWrong = true;
      }
    } finally {
      if ( networkException ) {
        w( TAG, " Hudson, there are troubles with network ");
        resultHolder = new Auth0ResultHolder ( false, null, null );
      } else if ( somethingWentReallyWrong ) {
        resultHolder = new Auth0ResultHolder();
      } else {
        if( loginResult.isSuccessful( ) ) {
          i( TAG, "Successful login ");
          resultHolder = new Auth0ResultHolder( true, loginResult, auth0User );
        } else {
          i( TAG, "Error during login, it was not successful " );
          resultHolder = new Auth0ResultHolder( true, loginResult, auth0User );
        }
      }
    }

    return resultHolder;
  }


  protected String getClientId( ) { return mClientId; }

  protected String getDomain( ) { return mDomain; }

  private boolean ping(String url ) {
    /**
     * exception may be thrown on invalid SSL certificates, soo
     */
    url = url.replaceFirst("https", "http");

    try {
      HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
      connection.setConnectTimeout( 3000 );
      connection.setReadTimeout( 3000 );
      connection.setRequestMethod("HEAD");
      int responseCode = connection.getResponseCode();
      return (200 <= responseCode && responseCode <= 399);
    } catch (IOException exception) {
      return false;
    }
  }
}
