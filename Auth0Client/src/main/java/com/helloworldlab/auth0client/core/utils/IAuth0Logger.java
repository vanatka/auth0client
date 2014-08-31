package com.helloworldlab.auth0client.core.utils;

/**
 * @author Ivan Aläxkin (ivan.alyakskin@gmail.com)
 */
public interface IAuth0Logger {
  IAuth0Logger mLogger = Auth0ClientDefaultLogger.ME;

  void v( String tag, String msg );
  void v( String tag, String msg, Throwable th);

  void d( String tag, String msg );
  void d( String tag, String msg, Throwable th);

  void i( String tag, String msg );
  void i( String tag, String msg, Throwable th);

  void w( String tag, String msg );
  void w( String tag, String msg, Throwable th);

  void e( String tag, String msg );
  void e( String tag, String msg, Throwable th);

  void setLogger( IAuth0Logger logger );

  void turnOnOff(boolean onOff);
}
