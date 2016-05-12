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

public class HashHmacSignatureProvider implements SignatureProvider {

    private static final String CHAR_UTF_8 = "UTF-8";
    private static final String HMAC_HASH_ALGORITHM = "HmacSHA256";

    private String secretKey;

    /**
     * Constructor
     * @param secretKey the API key
     */
    public HashHmacSignatureProvider(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * {@inheritDoc}
     */
    public String sign(Map<String, String> params) throws SdkException {
        NavigableMap<String, String> sortedParams = new TreeMap<String, String>(params);
        String concat = "";
        try {
            for(String key : sortedParams.navigableKeySet()) {
                concat += URLEncoder.encode(key, CHAR_UTF_8)
                        + "="
                        + URLEncoder.encode(sortedParams.get(key), CHAR_UTF_8)
                        + "&";
            }
            concat = concat.substring(0, concat.length()-1);
            concat = concat.replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new SdkException("Error while encoding parameters : " + e.getMessage());
        }

        return hmacDigest(concat, secretKey, HMAC_HASH_ALGORITHM);
    }

    /**
     * Compute a hashmac of a given message.
     *
     * @param msg msg to sign
     * @param keyString string representing the key
     * @param algorithm hash algorithm to be used
     * @return string representing the hashmac of the message
     * @throws SdkException
     */
    private static String hmacDigest(String msg, String keyString, String algorithm) throws SdkException {
        String digest;
        try {
            SecretKeySpec key = new SecretKeySpec((keyString).getBytes(), algorithm);
            Mac mac = Mac.getInstance(algorithm);
            mac.init(key);
            final byte[] rawHmac = mac.doFinal(msg.getBytes());
            digest = String.format("%x", new BigInteger(1, rawHmac));
        } catch (InvalidKeyException e) {
            throw new SdkException("Error while signing request : " + e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            throw new SdkException("Error while signing request : " + e.getMessage());
        }
        return digest;
    }
}
