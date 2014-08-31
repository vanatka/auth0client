package com.helloworldlab.auth0client.core.containers;

import com.helloworldlab.auth0client.core.utils.GSONable;

/**
 * @author Ivan Aläxkin (ivan.alyakskin@gmail.com)
 */
public class EmailPasswordHolder extends GSONable {
  protected final String mEmail, mPassword;
  public String getPassword() {
    return mPassword;
  }

  public String getEmail() {
    return mEmail;
  }
  public EmailPasswordHolder(final String email, final String password) {
    mEmail = email;
    mPassword = password;
  }
}
