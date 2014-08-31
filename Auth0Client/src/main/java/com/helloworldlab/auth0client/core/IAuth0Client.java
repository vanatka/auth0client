package com.helloworldlab.auth0client.core;

import com.helloworldlab.auth0client.core.containers.Auth0LoginResult;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;


/**
 * @author Ivan Aläxkin (ivan.alyakskin@gmail.com)
 */
public interface IAuth0Client {
  @FormUrlEncoded
  @POST("/oauth/ro/")
  Auth0LoginResult oauthWithOfflineWork(
      @Field("client_id") String client_id,
      @Field("username") String username,
      @Field("password") String password,
      @Field("connection") String connection,
      @Field("grant_type") String grant_type,
      @Field("scope") String scope,
      @Field("device") String device );



  @FormUrlEncoded
  @POST("/oauth/ro/")
  Auth0LoginResult oauth(
      @Field("client_id") String client_id,
      @Field("username") String username,
      @Field("password") String password,
      @Field("connection") String connection,
      @Field("grant_type") String grant_type,
      @Field("scope") String scope);

  @GET("/userinfo")
  Auth0User getUserInfo( @Query("access_token") String access_token );
}
