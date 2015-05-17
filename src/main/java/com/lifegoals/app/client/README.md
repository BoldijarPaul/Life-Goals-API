## **Client API Documentation**

To consume the api you must:

 1. Get the Client and Entities package to your project.
 2. Resolve any package issues.
 
 
 For most of the requests you need an access token, you get it after logging in.
 You can set the token like this:
 
 ```ClientContext.setToken(token); ``` 
 
 
 ###Trying to login

```LoginResult loginResult = ClientUserManagement.login(info);``` 
    
To check if the login was successful or not check the success value from the LoginResult class.
 
 

**User management**




####To add a new user:
    ClientUserManagement.addUser(user);
    
  This returns the user if it was successfuly added.

