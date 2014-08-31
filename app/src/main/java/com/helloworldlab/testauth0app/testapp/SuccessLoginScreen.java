package com.helloworldlab.testauth0app.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.helloworldlab.testauth0app.R;


/**
 * @author Ivan Aläxkin (ivan.alyakskin@gmail.com)
 */
public class SuccessLoginScreen extends Activity {

  public static final String SERIALIZED_RESULT = "result";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    String serialized = getIntent().getExtras().getString(SERIALIZED_RESULT);
    setContentView(R.layout.activity_success_login_screen);
    ((TextView) findViewById(R.id.result)).setText(serialized);
  }
}
