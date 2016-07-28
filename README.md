# SC-SDK

## Download

Our releases are available on Maven Central repository. You will find the jar files, the javadoc and all the dependencies.

### Maven
Simply add the following dependency to your *pom.xml*:

```
<dependency>
    <groupId>com.rocket-labs</groupId>
    <artifactId>sellercenterapi</artifactId>
    <version>0.2.0</version>
</dependency>
```

### Gradle
Add the following to your *build.gradle*:
```
compile 'com.rocket-labs:sellercenterapi:0.2.0'
```

## Get started

1. You can retrieve every information required on Seller Center in Product > API Reference > API Explorer.

2. Then you can set those variables at runtime as shown in the samples.
You will need to copy the followings:
    - UserID
    - API Key
    - API url

```
SellerCenter.apiKey = "1fbe9c3b05a04d791bb09ee5baa08e39f6145f5b";
SellerCenter.userId = "user.name@sellercenter.com";
SellerCenter.url = "https://api.sellercenter.net/";
```

3. Try out the samples ! You will find them in [**src/samples**](https://github.com/rocket-internet-berlin/SellerCenterSDK-Java/tree/introduce_skd/src/samples) folder.

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
