package com.helloworldlab.auth0client.core;


import com.helloworldlab.auth0client.core.utils.Auth0ClientDefaultLogger;
import com.helloworldlab.auth0client.core.utils.GSONable;
import com.helloworldlab.auth0client.core.utils.IAuth0Logger;

/**
 * @author Ivan Aläxkin (ivan.alyakskin@gmail.com)
 *
 * This is base class for Auth0Client classes, except AsyncTasks & etc
 * Main ideas:
 * - share logging functionality everywhere;
 * - have ability to redirect log messages to users logging subsystem;
 * This is wrapper for default logger, there is only 1 logger per process
 * For details look to {@link com.helloworldlab.auth0client.core.utils.Auth0ClientDefaultLogger}
 */
public class Auth0Base extends GSONable implements IAuth0Logger {

  @Override
  public void v(String tag, String msg) {
    Auth0ClientDefaultLogger.ME.v(tag, msg);
  }

  @Override
  public void v(String tag, String msg, Throwable th) {
    Auth0ClientDefaultLogger.ME.v(tag, msg, th);
  }

  @Override
  public void d(String tag, String msg) {
    Auth0ClientDefaultLogger.ME.d(tag, msg);
  }

  @Override
  public void d(String tag, String msg, Throwable th) {
    Auth0ClientDefaultLogger.ME.d(tag, msg, th);
  }

  @Override
  public void i(String tag, String msg) {
    Auth0ClientDefaultLogger.ME.i(tag, msg);
  }

  @Override
  public void i(String tag, String msg, Throwable th) {
    Auth0ClientDefaultLogger.ME.i(tag, msg, th);
  }

  @Override
  public void w(String tag, String msg) {
    Auth0ClientDefaultLogger.ME.w(tag, msg);
  }

  @Override
  public void w(String tag, String msg, Throwable th) {
    Auth0ClientDefaultLogger.ME.w(tag, msg, th);
  }

  @Override
  public void e(String tag, String msg) {
    Auth0ClientDefaultLogger.ME.e(tag, msg);
  }

  @Override
  public void e(String tag, String msg, Throwable th) {
    Auth0ClientDefaultLogger.ME.e(tag, msg, th);
  }

  @Override
  public void setLogger(IAuth0Logger logger) {
    Auth0ClientDefaultLogger.ME.setLogger(logger);
  }

  @Override
  public void turnOnOff(boolean onOff) {
    Auth0ClientDefaultLogger.ME.turnOnOff(onOff);
  }
}
