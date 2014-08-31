package com.helloworldlab.auth0client.android;

import android.os.AsyncTask;

import com.helloworldlab.auth0client.core.Auth0Client;
import com.helloworldlab.auth0client.core.containers.Auth0ResultHolder;
import com.helloworldlab.auth0client.core.containers.EmailPasswordHolder;

/**
 * @author Ivan Aläxkin (ivan.alyakskin@gmail.com)
 */
public abstract class Auth0DADLoginTask extends AsyncTask<EmailPasswordHolder,Void, Auth0ResultHolder> {
  protected final Auth0Client mAuth0Client;

  public Auth0DADLoginTask( Auth0Client auth0Client ) {
    mAuth0Client = auth0Client;
  }

  @Override
  protected Auth0ResultHolder doInBackground(EmailPasswordHolder... emailPasswordHolders) {
    EmailPasswordHolder emailPasswordHolder = emailPasswordHolders[0];
    return mAuth0Client.loginSyncWithEmailPassword( emailPasswordHolder );
  }

  @Override
  protected void onPostExecute( final Auth0ResultHolder auth0ResultHolder) {
    super.onPostExecute(auth0ResultHolder);
    if ( auth0ResultHolder.getResult().equals(Auth0ResultHolder.RESULT.SUCCESS) ) {
      onSuccessfulLogin(auth0ResultHolder);
    } else {
      onFailedLogin( auth0ResultHolder, auth0ResultHolder.getResult() );
    }
  }

  public abstract void onSuccessfulLogin( final Auth0ResultHolder resultHolder);

  public abstract void onFailedLogin( final Auth0ResultHolder resultHolder, final Auth0ResultHolder.RESULT error );
}
