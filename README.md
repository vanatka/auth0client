#Auth0Client for Android ( version 1.0 )


Overview
---

[**Auth0Client**](https://github.com/vanatka/auth0client), is gradle based Android library, to let developers have basic [Auth0](http://auth0.com) [API](https://docs.auth0.com/auth-api#!#get--authorize_db).

Features
---
In version 1.0:

* [Database & Active Directory / LDAP Authentication](https://docs.auth0.com/auth-api#db-and-ad)
* Auth0Client - class with Auth0 API's, right now only login
* Auth0DADLoginTask - AsyncTask for convinient usage in activities, to use it - it's necessary create inhereted class from Auth0DADLoginTask & declare few methods
* IAuth0Logger - in case if you have your own Logging system, it's possible to redirect all log messages to your subsystem, to do it, it's necessary to add `implements IAuth0Logger` to your logging class (example of usage you can find in reference [`app`](http://github.com/vanatka/auth0client/app))

Usage
---
Necessary create project on [Auth0](http://auth0.com) and create application, obtain domain & client id. Then in your Android application create instance of 

Example
---
#####Sample project
You can find reference project in [`app`](http://github.com/vanatka/auth0client/app) subfolder in the repo.


#####Calling Auth0Client directly:

```
Auth0Client auth0Client = new Auth0Client("https://androidauth0client.auth0.com","Hmhh2ZigTPHw9kdtu9ZIB2YN4rf4Fm33");
Auth0ResultHolder resultHolder = auth0Client.loginSyncWithEmailPassword(new EmailPasswordHolder("ivan@helloworldlab.com", "qwerty"));
Auth0ResultHolder.RESULT result = resultHolder.getResult();
switch (result) {
  case SUCCESS:
    Auth0User user = resultHolder.getUser();
    Log.i(">>>", " login was successful, user's nick is " + user.getNickname( ) );
    break;
  case FAILED_NETWORK_ERROR:
    Log.i(">>>", " something wrong with network " + resultHolder.getErrorMsg() );
    break;
  case FAILED_WRONG_CREDENTIALS:
    Log.i(">>>", " wrong credentials " + resultHolder.getErrorMsg() );
    break;
  default:
  case HUDSON_THERE_ARE_TROUBLES:
    break;
}
```


#####Auth0DADLoginTask in activity

```
public class LoginActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Auth0Client auth0Client = new Auth0Client("https://androidauth0client.auth0.com", "Hmhh2ZigTPHw9kdtu9ZIB2YN4rf4Fm33");
    UserLoginTask authTask = new UserLoginTask( auth0Client );
    EmailPasswordHolder emailPasswordHolder = new EmailPasswordHolder("ivan@helloworldlab.com", "qwerty");
    authTask.execute( emailPasswordHolder );
  }

  public class UserLoginTask extends Auth0DADLoginTask {
    public UserLoginTask(Auth0Client auth0Client) {
      super(auth0Client);
    }

    @Override
    public void onSuccessfulLogin(Auth0ResultHolder resultHolder) {
    }

    @Override
    public void onFailedLogin(Auth0ResultHolder resultHolder, Auth0ResultHolder.RESULT error) {
    }
}
```


Compatibility
---
This library is compatible from API 7 (Android 1.5).

Gradle
---
in progress

License
---
```
The MIT License (MIT)

Copyright (c) 2014 Ivan Aläxkin

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```

