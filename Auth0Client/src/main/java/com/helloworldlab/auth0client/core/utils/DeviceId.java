package com.helloworldlab.auth0client.core.utils;

import android.os.Build;

/**
 * @author Ivan Aläxkin (ivan.alyakskin@gmail.com)
 */
public class DeviceId {
  /**
   * @return pseudo unique id
   */
  public static String getDeviceId( ) {
    StringBuilder sb = new StringBuilder();
    return  sb.append( "35" )
              .append(Build.BOARD.length() % 10)
              .append(Build.BRAND.length() % 10)
              .append(Build.CPU_ABI.length() % 10)
              .append(Build.DEVICE.length() % 10)
              .append(Build.DISPLAY.length() % 10)
              .append(Build.HOST.length() % 10)
              .append(Build.ID.length() % 10)
              .append(Build.MANUFACTURER.length() % 10)
              .append(Build.MODEL.length() % 10)
              .append(Build.PRODUCT.length() % 10)
              .append(Build.TAGS.length() % 10)
              .append(Build.TYPE.length() % 10)
              .append(Build.USER.length() % 10)
    .toString( );
  }
}
