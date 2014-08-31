package com.helloworldlab.auth0client.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.helloworldlab.auth0client.core.utils.GSONable;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Ivan Aläxkin (ivan.alyakskin@gmail.com)
 */
public class Auth0User extends GSONable {

  @Expose
  private String email;
  @Expose
  private String clientID;
  @Expose
  private String picture;

  @SerializedName("user_id")
  @Expose
  private String userId;
  @Expose
  private String name;
  @Expose
  private String nickname;
  @Expose
  private List<Identity> identities = new ArrayList<Identity>();
  @SerializedName("created_at")
  @Expose
  private String createdAt;
  @SerializedName("email_verified")
  @Expose
  private Boolean emailVerified;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getClientID() {
    return clientID;
  }

  public void setClientID(String clientID) {
    this.clientID = clientID;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public List<Identity> getIdentities() {
    return identities;
  }

  public void setIdentities(List<Identity> identities) {
    this.identities = identities;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Boolean getEmailVerified() {
    return emailVerified;
  }

  public void setEmailVerified(Boolean emailVerified) {
    this.emailVerified = emailVerified;
  }

  public static class Identity {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @Expose
    private String provider;
    @Expose
    private String connection;
    @Expose
    private Boolean isSocial;

    public String getUserId() {
      return userId;
    }

    public void setUserId(String userId) {
      this.userId = userId;
    }

    public String getProvider() {
      return provider;
    }

    public void setProvider(String provider) {
      this.provider = provider;
    }

    public String getConnection() {
      return connection;
    }

    public void setConnection(String connection) {
      this.connection = connection;
    }

    public Boolean getIsSocial() {
      return isSocial;
    }

    public void setIsSocial(Boolean isSocial) {
      this.isSocial = isSocial;
    }
  }
}
