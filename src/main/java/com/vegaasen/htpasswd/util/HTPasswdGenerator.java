package com.vegaasen.htpasswd.util;

import com.vegaasen.htpasswd.abs.AbstractUtil;
import com.vegaasen.htpasswd.model.HTPasswdVariant;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Simple Htpasswd generator
 *
 * Can use both SHA-1 and MD-5 solutions. Please address that the SHA-1 solution is more apprecated than the MD-5 one.
 *
 * @author vegaasen
 * @since 1.0-SNAPSHOT
 */
public class HTPasswdGenerator extends AbstractUtil {

    private static final Logger LOGGER = Logger.getLogger(HTPasswdGenerator.class);

    public static final String IDENTIFIER_SHA = "{SHA}";
    public static final String IDENTIFIER_MD5 = "MD5";
    public static final String MD_5_SEPERATOR = ":";

    public static String generateEncryptedPassword(final String usr, final String pwd, final HTPasswdVariant type)
            throws NullPointerException {
        if(verifyNotNull(pwd, type)) {
            if(StringUtils.isNotEmpty(pwd)) {
                switch (type) {
                    case USE_SHA1_WITH_BASE64:
                        LOGGER.debug("Using SHA-1 with BASE-64");
                        return generateSha1Representation(pwd);
                    case USE_CRYPT:
                        LOGGER.debug("Using CRYPT");
                    case USE_MD5_WITH_SALT:
                        LOGGER.debug("Using MD5 + SALT");
                        return generateMD5Representation(pwd, usr);
                    default:
                        LOGGER.error("Please select hashing algorithm before continuing.");
                }
            }
        }
        throw new NullPointerException(E_OBJECT_WAS_NULL);
    }

    private static String generateSha1Representation(final String pwd) {
        if(StringUtils.isNotEmpty(pwd)) {
            String result = IDENTIFIER_SHA + new String(Base64.encodeBase64(
                    getMessageDigest("SHA1").digest(
                            pwd.getBytes()
                    )
            ));
        }
        return "";
    }

    private static String generateMD5Representation(final String pwd, final String usr) {
        try{
            byte digestedBytes[] = getMessageDigest(IDENTIFIER_MD5).digest(
                    (
                            usr +
                            MD_5_SEPERATOR +
                            PropertiesUtil.loadProperties().get("apache.realm.name") +
                            MD_5_SEPERATOR +
                            pwd
                    )
                    .getBytes());
            BigInteger bigInteger = new BigInteger(1, digestedBytes);
            String result = bigInteger.toString(16);
            while (result.length() < 32) {
                result = "0" + result;
            }
            return result;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static MessageDigest getMessageDigest(final String type) {
        try {
            return MessageDigest.getInstance(type);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        throw new NullPointerException(E_OBJECT_WAS_NULL);
    }
}
