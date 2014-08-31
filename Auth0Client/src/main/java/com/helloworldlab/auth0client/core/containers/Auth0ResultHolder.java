package com.helloworldlab.auth0client.core.containers;

import com.helloworldlab.auth0client.core.Auth0Base;
import com.helloworldlab.auth0client.core.Auth0User;


/**
 * @author Ivan Aläxkin (ivan.alyakskin@gmail.com)
 */
public class Auth0ResultHolder extends Auth0Base {
  protected final RESULT mResult;
  protected final Auth0LoginResult mLoginResult;
  protected final Auth0User mAuth0User;

  public Auth0ResultHolder() {
    mResult = RESULT.HUDSON_THERE_ARE_TROUBLES;
    mLoginResult = null;
    mAuth0User = null;
  }

  public Auth0ResultHolder( final boolean networkOk,
                            final Auth0LoginResult loginResult,
                            final Auth0User auth0Client ) {
    mLoginResult = loginResult;

    if( networkOk ) {
      if ( mLoginResult.isSuccessful( ) ) {
        mResult = RESULT.SUCCESS;
      } else {
        mResult = RESULT.FAILED_WRONG_CREDENTIALS;
      }
    } else {
      mResult = RESULT.FAILED_NETWORK_ERROR;
    }

    mAuth0User = auth0Client;
  }



  public Auth0User getUser() {
    return mAuth0User;
  }

  public RESULT getResult() {
    return mResult;
  }

  public String getErrorMsg( ) {
    return RESULT.FAILED_WRONG_CREDENTIALS.equals( mResult ) ? mLoginResult.error_description : " " + mResult;
  }

  public static enum RESULT {
    FAILED_NETWORK_ERROR,
    FAILED_WRONG_CREDENTIALS,
    SUCCESS,
    HUDSON_THERE_ARE_TROUBLES
  }

  public static Auth0ResultHolder deserialize( String me ) {
    return deserialize(me, Auth0ResultHolder.class);
  }
}
