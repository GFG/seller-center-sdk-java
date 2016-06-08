package com.sellercenter.api.core.response;

import com.sellercenter.api.exceptions.*;

import java.lang.reflect.Constructor;

@SuppressWarnings("unused")
public enum ErrorType {
    MANDATORY_PARAM(1, InvalidRequestException.class),
    INVALID_VERSION(2, InvalidRequestException.class),
    TIMESTAMP_EXPIRED(3, InvalidRequestException.class),
    INVALID_TIMESTAMP_FORMAT(4, InvalidRequestException.class),
    INVALID_REQUEST_FORMAT(5, InvalidRequestException.class),
    INVALID_ACTION(8, InvalidRequestException.class),
    REQUEST_TOO_BIG(11, InvalidRequestException.class),
    INVALID_FEED_ID(12, InvalidRequestException.class),
    INVALID_FEED_STATUS(13, InvalidRequestException.class),
    INVALID_OFFSET(14, InvalidRequestException.class),
    INVALID_PAGE_SIZE(15, InvalidRequestException.class),
    INVALID_ORDER_ID(16, InvalidRequestException.class),
    INVALID_DATE_FORMAT(17, InvalidRequestException.class),
    INVALID_LIMIT(19, InvalidRequestException.class),
    INVALID_ORDER_ITEM_ID(20, InvalidRequestException.class),
    INVALID_REASON(22, InvalidRequestException.class),
    INVALID_ORDER_ITEM_IDS(23, InvalidRequestException.class),
    INVALID_DELIVERY_TYPE(24, InvalidRequestException.class),
    INVALID_SHIPPING_PROVIDER(25, InvalidRequestException.class),
    INVALID_DOC_TYPE(32, InvalidRequestException.class),
    INCORRECT_TRACKING_ID(31, InvalidRequestException.class),
    INVALID_STATUS_FILTER(36, InvalidRequestException.class),
    ID_INCORRECT(37, InvalidRequestException.class),
    TOO_MANY_ORDERS_REQUESTED(38, InvalidRequestException.class),
    INVALID_CREATION_DATE_VALUE(46, InvalidRequestException.class),
    INVALID_UPDATED_DATE_VALUE(47, InvalidRequestException.class),
    FEED_ID_LIST_MUST_BE_ARRAY_FORMAT(53, InvalidRequestException.class),
    FEED_ID_LIST_MUST_BE_ARRAY_OF_FEED_IDS(54, InvalidRequestException.class),
    ORDERS_ID_LIST_MUST_BE_ARRAY(56, InvalidRequestException.class),
    CORRUPT_SKU_LIST_DATA(70, InvalidRequestException.class),
    INVALID_SORT_DIRECTION(74, InvalidRequestException.class),
    INVALID_SORT_FILTER(75, InvalidRequestException.class),
    FIELD_MANIFEST_CODE_IS_MISSING(89, InvalidRequestException.class),

    OMS_API_ERROR_OCCURRED(21, ApiException.class),
    IMPOSSIBLE_TO_SET_ORDER_TO_STATUS(28, ApiException.class),
    ORDER_ITEMS_MUST_BE_FROM_THE_SAME_ORDER(29, ApiException.class),
    ORDER_ITEM_MUST_BE_PACKED(34, ApiException.class),
    TRACKING_CODE_ALREADY_USED(63, ApiException.class),
    NO_CATEGORIES_LINKED_TO_PROVIDED_ATTRIBUTE_SET(64, ApiException.class),
    ALL_ORDER_ITEMS_MUST_HAVE_STATUS_PENDING_OR_READY_TO_SHIP(73, ApiException.class),
    MANIFEST_FEATURE_IS_NOT_ENABLED(87, ApiException.class),
    MANIFEST_STATUS_CAN_NOT_SET_TO_SHIPPED(90, ApiException.class),
    PLEASE_USE_SENT_TO_WAREHOUSE(91, ApiException.class),

    CURRENTLY_NOT_ALLOWED(93, ResourceNotFoundException.class),
    _NOT_FOUND(35, ResourceNotFoundException.class),
    NO_ORDERS_WERE_FOUND(39, ResourceNotFoundException.class),
    NO_ATTRIBUTE_SETS_LINKED_TO_THAT_CATEGORY(57, ResourceNotFoundException.class),
    NO_SELLER_WAS_FOUND_BY_E_MAIL(62, ResourceNotFoundException.class),
    MANIFEST_WAS_NOT_FOUND(88, ResourceNotFoundException.class),

    UNEXPECTED_INTERNAL_ERROR(6, ApiException.class, "Internal API error : "),
    INTERNAL_APPLICATION_OR_FORMAT_ERROR_DETECTED(1000, ApiException.class, "Internal API error : "),

    SIGNATURE_PROBLEM(7, AuthenticationException.class),
    ACCESS_DENIED(9, AuthenticationException.class),

    THROTTLING(429, RateLimitException.class),

    EMPTY_REQUEST(30, ApiException.class, "Unexpected API Exception : "),
    INSECURE_CHANNEL(10, ApiException.class, "Unexpected API Exception : "),

    UNEXPECTED_API_ERROR(-1, ApiException.class, "Unknown error : ");

    private final int errorNumber;
    private final Class<? extends SdkException> exceptionClass;
    private final String errorMessagePrefix;

    ErrorType(int errorNumber, Class<? extends SdkException> exceptionClass) {
        this(errorNumber, exceptionClass, "");
    }

    ErrorType(int errorNumber, Class<? extends SdkException> exceptionClass, String errorMessagePrefix) {
        this.errorNumber = errorNumber;
        this.exceptionClass = exceptionClass;
        this.errorMessagePrefix = errorMessagePrefix;
    }

    public SdkException getException(String errorMessage) throws ReflectiveOperationException {
        Constructor<? extends SdkException> constructor = exceptionClass.getConstructor(String.class);
        if (errorMessagePrefix != null) {
            errorMessage = errorMessagePrefix + errorMessage;
        }
        return constructor.newInstance(errorMessage);
    }

    public static ErrorType getByErrorNumber(int errorNumber) {
        for (ErrorType errorType : values()) {
            if (errorType.errorNumber == errorNumber) {
                return errorType;
            }
        }
        return UNEXPECTED_API_ERROR;
    }
}