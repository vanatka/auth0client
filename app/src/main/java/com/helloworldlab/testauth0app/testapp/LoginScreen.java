package com.helloworldlab.testauth0app.testapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.helloworldlab.auth0client.android.Auth0DADLoginTask;
import com.helloworldlab.auth0client.core.Auth0Client;
import com.helloworldlab.auth0client.core.containers.Auth0ResultHolder;
import com.helloworldlab.auth0client.core.containers.EmailPasswordHolder;
import com.helloworldlab.testauth0app.R;


/**
 * @author Ivan Aläxkin (ivan.alyakskin@gmail.com)
 */
public class LoginScreen extends Activity {

  private UserLoginTask mAuthTask = null;

  private EditText mEmailView;
  private EditText mPasswordView;
  private View mProgressView;
  private View mLoginFormView;

  private CustomLogger mCustomLogger = new CustomLogger();

  private Auth0Client mAuth0Client;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login_screen);

    // Set up the login form.
    mEmailView = (EditText) findViewById(R.id.email);

    mPasswordView = (EditText) findViewById(R.id.password);
    mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
        if (id == R.id.login || id == EditorInfo.IME_NULL) {
          attemptLogin();
          return true;
        }
        return false;
      }
    });

    Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
    mEmailSignInButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        attemptLogin();
      }
    });

    mLoginFormView = findViewById(R.id.login_form);
    mProgressView = findViewById(R.id.login_progress);
  }


  public void attemptLogin() {

    mEmailView.setError(null);
    mPasswordView.setError(null);

    // Store values at the time of the login attempt.
    String email = mEmailView.getText().toString();
    String password = mPasswordView.getText().toString();

    boolean cancel = false;
    View focusView = null;


    // Check for a valid password, if the user entered one.
    if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
      mPasswordView.setError(getString(R.string.error_invalid_password));
      focusView = mPasswordView;
      cancel = true;
    }

    // Check for a valid email address.
    if (TextUtils.isEmpty(email)) {
      mEmailView.setError(getString(R.string.error_field_required));
      focusView = mEmailView;
      cancel = true;
    } else if (!isEmailValid(email)) {
      mEmailView.setError(getString(R.string.error_invalid_email));
      focusView = mEmailView;
      cancel = true;
    }

    if (cancel) {
      focusView.requestFocus();
    } else {
      showProgress(true);
      mAuth0Client = new Auth0Client("https://androidauth0client.auth0.com", "Hmhh2ZigTPHw9kdtu9ZIB2YN4rf4Fm33");

      /**
       * setting custom logger
       */
      mAuth0Client.setLogger(mCustomLogger);

      mAuthTask = new UserLoginTask( mAuth0Client );
      EmailPasswordHolder emailPasswordHolder = new EmailPasswordHolder(mEmailView.getText().toString(), mPasswordView.getText().toString());
      mAuthTask.execute( emailPasswordHolder );
    }
  }

  private boolean isEmailValid(String email) {
    return email.contains("@");
  }

  private boolean isPasswordValid(String password) {
    return !TextUtils.isEmpty(password);
  }

  public void showProgress(final boolean show) {
    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
  }

  public class UserLoginTask extends Auth0DADLoginTask {

    public UserLoginTask(Auth0Client auth0Client) {
      super(auth0Client);
    }

    @Override
    public void onSuccessfulLogin(Auth0ResultHolder resultHolder) {
      showProgress( false );
      Intent intent = new Intent(LoginScreen.this, SuccessLoginScreen.class);
      intent.putExtra(SuccessLoginScreen.SERIALIZED_RESULT, resultHolder.serialize());
      startActivity(intent);
    }

    @Override
    public void onFailedLogin(Auth0ResultHolder resultHolder, Auth0ResultHolder.RESULT error) {
      showProgress( false );
      Toast.makeText(getApplicationContext(), "Error: " + error + " " + resultHolder.getErrorMsg( ), Toast.LENGTH_LONG).show();
    }
  }
}



