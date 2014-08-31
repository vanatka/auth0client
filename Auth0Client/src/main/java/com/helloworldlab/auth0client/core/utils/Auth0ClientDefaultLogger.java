package com.helloworldlab.auth0client.core.utils;

import android.util.Log;

/**
 * @author Ivan Aläxkin (ivan.alyakskin@gmail.com)
 *
 * This is logger subsystem in Auth0Client library
 * It's a singleton ( 1 instance per process )
 * Features:
 * - turn on/off logging
 * - forward logging to your subsystem: use {@link Auth0ClientDefaultLogger#setLogger(com.helloworldlab.auth0client.core.utils.IAuth0Logger)} method
 */
public enum Auth0ClientDefaultLogger implements IAuth0Logger {
  ME;

  private IAuth0Logger  mCustomLogger;
  private boolean       mOnOff = true;


  @Override
  public void v(String tag, String msg) {
    if( mOnOff ) {
      if (null != mCustomLogger ) {
        mCustomLogger.v(tag, msg);
      } else {
        Log.v(tag, msg);
      }
    }
  }

  @Override
  public void v(String tag, String msg, Throwable th) {
    if( mOnOff ) {
      if (null != mCustomLogger ) {
        mCustomLogger.v(tag, msg, th);
      } else {
        Log.v(tag, msg, th);
      }
    }
  }

  @Override
  public void d(String tag, String msg) {
    if( mOnOff ) {
      if (null != mCustomLogger ) {
        mCustomLogger.d(tag, msg);
      } else {
        Log.d(tag, msg);
      }
    }
  }

  @Override
  public void d(String tag, String msg, Throwable th) {
    if( mOnOff ) {
      if (null != mCustomLogger ) {
        mCustomLogger.d(tag, msg, th);
      } else {
        Log.d(tag, msg, th);
      }
    }
  }

  @Override
  public void i(String tag, String msg) {
    if( mOnOff ) {
      if (null != mCustomLogger ) {
        mCustomLogger.i(tag, msg);
      } else {
        Log.i(tag, msg);
      }
    }
  }

  @Override
  public void i(String tag, String msg, Throwable th) {
    if( mOnOff ) {
      if (null != mCustomLogger ) {
        mCustomLogger.i(tag, msg, th);
      } else {
        Log.i(tag, msg, th);
      }
    }
  }

  @Override
  public void w(String tag, String msg) {
    if( mOnOff ) {
      if (null != mCustomLogger ) {
        mCustomLogger.w(tag, msg);
      } else {
        Log.w(tag, msg);
      }
    }
  }

  @Override
  public void w(String tag, String msg, Throwable th) {
    if( mOnOff ) {
      if (null != mCustomLogger ) {
        mCustomLogger.w(tag, msg, th);
      } else {
        Log.w(tag, msg, th);
      }
    }
  }

  @Override
  public void e(String tag, String msg) {
    if( mOnOff ) {
      if (null != mCustomLogger ) {
        mCustomLogger.e(tag, msg);
      } else {
        Log.e(tag, msg);
      }
    }
  }

  @Override
  public void e(String tag, String msg, Throwable th) {
    if( mOnOff ) {
      if (null != mCustomLogger ) {
        mCustomLogger.e(tag, msg, th);
      } else {
        Log.e(tag, msg, th);
      }
    }
  }

  @Override
  public void setLogger(IAuth0Logger logger) {
    mCustomLogger = logger;
  }

  @Override
  public void turnOnOff( boolean onOff ) {
    mOnOff = onOff;
  }
}
