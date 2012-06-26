htpasswd-java-webapp
====================

## Apache htpasswd generator

### What is it?

This is a simple project that does exactly what the title says. It's a webapp that contains two possibilities concerning httpd-pwd generation:

* REST
* Web (jsp)

This application is ready to be deployed using jetty or any other container (see the pom.xml for more details). It can
also be runned with the oh so popular mvn jetty:run-command.

### Supported hashing algorithms

The application can generate htpasswd-files/ username:password-combinations using the following hashing-algorithms:

* Base64+SHA-1
* MD-5
* Crypt(3)

When using both the provided REST-services and the GUI supplied with the webapp, the default operation is Crypt(3).
I am not sure how well Windows handles Crypt(3)-hashed uname:pwd-mixes - but you'll quickly notice how that works out for you.

## TODO's

* Create a simple REST based service, so that one don't have to actually use the jsp representation
* Create a simple Runnable so that the application can also be used as a simple command-prompt-tool
