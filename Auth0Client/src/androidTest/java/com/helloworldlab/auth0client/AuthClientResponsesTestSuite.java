package com.helloworldlab.auth0client;

import android.test.AndroidTestCase;
import android.util.Log;

import com.helloworldlab.auth0client.core.Auth0Client;
import com.helloworldlab.auth0client.core.containers.Auth0ResultHolder;
import com.helloworldlab.auth0client.core.containers.EmailPasswordHolder;

import junit.framework.Assert;


/**
 * @author Ivan Aläxkin (ivan.alyakskin@gmail.com)
 */
public class AuthClientResponsesTestSuite extends AndroidTestCase {
  private static final String TAG = "[AuthClientResponsesTestSuite]";

  @Override
  protected void setUp() throws Exception {
    super.setUp();
  }

  public void testSuccess() {
    Auth0Client auth0Client = new Auth0Client("https://androidauth0client.auth0.com", "Hmhh2ZigTPHw9kdtu9ZIB2YN4rf4Fm33");
    Auth0ResultHolder resultHolder = auth0Client.loginSyncWithEmailPassword(new EmailPasswordHolder("ivan@helloworldlab.com", "qwerty"));
    Log.d(TAG, " resultHolder.getResult() " + resultHolder.getResult() );
    Assert.assertEquals(resultHolder.getResult(), Auth0ResultHolder.RESULT.SUCCESS);
  }

  public void testWrongCredentials() {
    Auth0Client auth0Client = new Auth0Client("https://androidauth0client.auth0.com", "Hmhh2ZigTPHw9kdtu9ZIB2YN4rf4Fm33");
    Auth0ResultHolder resultHolder = auth0Client.loginSyncWithEmailPassword(new EmailPasswordHolder("stas@helloworldlab.com", "qwerty"));
    Log.d(TAG, " resultHolder.getResult() " + resultHolder.getResult() );
    Assert.assertEquals(resultHolder.getResult(), Auth0ResultHolder.RESULT.FAILED_WRONG_CREDENTIALS);
  }

  public void testNetworkError() {
    Auth0Client auth0Client = new Auth0Client("https://ProfessorStepashkinMadeMyDay.auth0.com", "Hmhh2ZigTPHw9kdtu9ZIB2YN4rf4Fm33");
    Auth0ResultHolder resultHolder = auth0Client.loginSyncWithEmailPassword(new EmailPasswordHolder("stas@helloworldlab.com", "qwerty"));
    Log.d(TAG, " resultHolder.getResult() " + resultHolder.getResult() );
    Assert.assertEquals(resultHolder.getResult(), Auth0ResultHolder.RESULT.FAILED_WRONG_CREDENTIALS);
  }


  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }
}
