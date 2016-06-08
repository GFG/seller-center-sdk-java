# SC-SDK

## Download

Our releases are available on [Maven Central repository](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22sellercenterapi%22). You will find the jar files, the javadoc and all the dependencies.

### Maven
Simply add the following dependency to your *pom.xml*:

```
<dependency>
    <groupId>com.rocket-labs</groupId>
    <artifactId>sellercenterapi</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle
Add the following to your *build.gradle*:
```
compile 'com.rocket-labs:sellercenterapi:1.0.0'
```

## Get started

1. You can retrieve every information required on Seller Center in **Settings > Integration management > API Explorer**.

2. Then you can set those variables at runtime as shown in the samples.
You will need to copy the followings:
    - UserID
    - API Key
    - API url

```
SellerCenter.apiKey = "Put your api key here !";
SellerCenter.userId = "user.name@sellercenter.com";
SellerCenter.url = "https://api-url-of-the-desired-sellercenter/";
```

3. Try out the samples ! You will find them in [**src/samples**](https://github.com/rocket-internet-berlin/SellerCenterSDK-Java/tree/master/src/samples/java/com/rocketlabs/sellercenterapi/samples/endpoints) folder.

## How does it works ?

First you have to retrieve resources from Seller Center by calling methods of the static class SellerCenter.

```
OrderList orders = SellerCenter.getOrders(new GetOrdersOptions());
```

Then you can use methods of the resources to get more resources:
```
OrderItemList items = orders.getAllItems
```
... or to interact with Seller Center:
```
items.setStatusToReadyToShip();
```


## Take a look at the documentation

Visit our [**documentation**](https://sellercenter.readme.io/).
You will find for each calls more details about the parameters you need to provide.

You can also find all endpoints in the API explorer (**Settings > Integration management > API Explorer**)
