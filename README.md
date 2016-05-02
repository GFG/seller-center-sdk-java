# SC-SDK

## Download

### Maven
Simply add the following dependency to your pom.xml :

*coming soon...*

### Jar file
*coming soon...*

## Get started

1. Change the config parameters in **Config.java** (com.sellercenter.api) you can retrieve every information required on Seller Center in Product > API Reference > API Explorer.
You will need to copy the followings :
    - UserID
    - API Key
    - API url

2. Try out the samples ! You will find them in **src/samples** folder. They use parameters from Config, so they should run once step 1 is achieved.

## Take a look at the documentation

[**Visit our documentation**](https://sellercenter.readme.io/)

You will find for each calls the parameters you need to provide.

Please note that you don't need to compute the **signature**. Also GET request does not require a body in most cases.

## Developer Setup

### Intellij IDEA with Maven

1. Open the project folder
2. Import the project from the pom.xml (right clic + "add as a Maven project")
3. Set **src/main/java**, **src/samples** as source folders and **src/test/java** as test folder
4. Build and run !