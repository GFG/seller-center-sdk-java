package com.sellercenter.api.core.request;

import com.sellercenter.api.exceptions.SdkException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

final class HashHmacSignatureProvider implements SignatureProvider {

    private static final String CHAR_UTF_8 = "UTF-8";
    private static final String HMAC_HASH_ALGORITHM = "HmacSHA256";

    private final String secretKey;

    /**
     * Constructor
     *
     * @param secretKey the API key
     */
    HashHmacSignatureProvider(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * Sign a request by it's parameters
     *
     * @param params parameters of the request query
     * @return a string representing the signature of the request
     * @throws SdkException
     */
    public String sign(Map<String, String> params) throws SdkException {
        NavigableMap<String, String> sortedParams = new TreeMap<>(params);
        String concat = "";
        try {
            for (String key : sortedParams.navigableKeySet()) {
                concat += URLEncoder.encode(key, CHAR_UTF_8)
                        + "="
                        + URLEncoder.encode(sortedParams.get(key), CHAR_UTF_8)
                        + "&";
            }
            concat = concat.substring(0, concat.length() - 1);
            concat = concat.replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new SdkException("Error while encoding parameters : " + e.getMessage());
        }

        return hmacDigest(concat, secretKey);
    }

    /**
     * Compute a hashmac of a given message with a given key.
     *
     * @param msg       msg to sign
     * @param keyString string representing the key
     * @return string representing the hashmac of the message
     * @throws SdkException
     */
    private static String hmacDigest(String msg, String keyString) throws SdkException {
        String digest;
        try {
            SecretKeySpec key = new SecretKeySpec((keyString).getBytes(), HMAC_HASH_ALGORITHM);
            Mac mac = Mac.getInstance(HMAC_HASH_ALGORITHM);
            mac.init(key);
            final byte[] rawHmac = mac.doFinal(msg.getBytes());
            digest = String.format("%x", new BigInteger(1, rawHmac));
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            throw new SdkException("Error while signing request : " + e.getMessage());
        }
        return digest;
    }
}
