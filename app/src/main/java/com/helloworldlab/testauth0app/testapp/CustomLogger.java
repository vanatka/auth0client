package com.helloworldlab.testauth0app.testapp;

import android.util.Log;

import com.helloworldlab.auth0client.core.utils.IAuth0Logger;


/**
 * @author Ivan Aläxkin (ivan.alyakskin@gmail.com)
 */
public class CustomLogger implements IAuth0Logger {

  @Override
  public void v(String tag, String msg) {
    Log.e(">>>", "this is custom logger " + msg);
  }

  @Override
  public void v(String tag, String msg, Throwable th) {
    Log.e(">>>", "this is custom logger " + msg);
  }

  @Override
  public void d(String tag, String msg) {
    Log.e(">>>", "this is custom logger " + msg);
  }

  @Override
  public void d(String tag, String msg, Throwable th) {
    Log.e(">>>", "this is custom logger " + msg);
  }

  @Override
  public void i(String tag, String msg) {
    Log.e(">>>", "this is custom logger " + msg);
  }

  @Override
  public void i(String tag, String msg, Throwable th) {
    Log.e(">>>", "this is custom logger " + msg);
  }

  @Override
  public void w(String tag, String msg) {
    Log.e(">>>", "this is custom logger " + msg);
  }

  @Override
  public void w(String tag, String msg, Throwable th) {
    Log.e(">>>", "this is custom logger " + msg);
  }

  @Override
  public void e(String tag, String msg) {
    Log.e(">>>", "this is custom logger " + msg);
  }

  @Override
  public void e(String tag, String msg, Throwable th) {
    Log.e(">>>", "this is custom logger " + msg);
  }

  @Override
  public void setLogger(IAuth0Logger logger) { }

  @Override
  public void turnOnOff(boolean onOff) { }
}
