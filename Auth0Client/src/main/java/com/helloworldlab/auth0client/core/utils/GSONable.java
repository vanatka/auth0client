package com.helloworldlab.auth0client.core.utils;

import com.google.gson.Gson;

/**
 * @author Ivan Aläxkin (ivan.alyakskin@gmail.com)
 */
public class GSONable {
  public String serialize() {
    return new Gson().toJson(this);
  }

  public static <T extends GSONable> T deserialize(String string, Class<T> tClass) {
    return new Gson().fromJson(string, tClass);
  }

  public String toString() {
    return serialize();
  }
}
