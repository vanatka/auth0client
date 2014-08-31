package com.helloworldlab.auth0client.core.containers;

import android.text.TextUtils;

import com.helloworldlab.auth0client.core.utils.GSONable;


/**
 * @author Ivan Aläxkin (ivan.alyakskin@gmail.com)
 */
public class Auth0LoginResult extends GSONable {
  public String refresh_token, id_token, access_token, token_type, error, error_description;

  public boolean isSuccessful() {
    return TextUtils.isEmpty(error) ;
  }

  public String getErrorMessage() {
    return error_description;
  }

  public static Auth0LoginResult simulateWrongCredentials( final String msg) {
    Auth0LoginResult result = new Auth0LoginResult();
    result.error = "invalid_user_password";
    result.error_description = msg;
    return result;
  }
}
