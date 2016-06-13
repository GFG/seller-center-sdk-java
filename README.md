# SC-SDK

## Download

### Maven
Simply add the following dependency to your pom.xml :

*coming soon...*

### Jar file
*coming soon...*

## Get started

1. You can retrieve every information required on Seller Center in Product > API Reference > API Explorer.

2. Then you can set those variables at runtime as shown in the samples.
You will need to copy the followings :
    - UserID
    - API Key
    - API url

```
SellerCenter.apiKey = "11bbf504d7bb6a5e9c30baa9f0908e3b9ee5f514";
SellerCenter.userId = "remy.rey@rocket-internet.com";
SellerCenter.url = "https://rocket:rock4me@sellercenter-api-lazada-th.sellercenter.net/";
```

3. Try out the samples ! You will find them in [**src/samples**](https://github.com/rocket-internet-berlin/SellerCenterSDK-Java/tree/introduce_skd/src/samples) folder.

## How does it works ?

First you have to retrieve resources from Seller Center by calling methods of the static class SellerCenter.

```
OrderList orders = SellerCenter.getOrders(new GetOrdersOptions());
```

Then you can use methods of the resources to get more resources :
```
OrderItemList items = orders.getAllItems
```
... or to interact with Seller Center :
```
items.setStatusToReadyToShip();
```


## Take a look at the documentation

Visit our [**documentation**](https://sellercenter.readme.io/).
You will find for each calls more details about the parameters you need to provide.

## Developer Setup

### Intellij IDEA with Maven

1. Open the project folder
2. Import the project from the pom.xml
3. Set **src/main/java**, **src/samples** as source folders and **src/test/java** as test folder
4. Build and run !