package com.vegaasen.htpasswd.util;

import com.vegaasen.htpasswd.abs.AbstractUtil;
import com.vegaasen.htpasswd.model.HTPasswdVariant;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.vegaasen.htpasswd.util.hash.Crypt.cryptUsingStandardDES;
import static com.vegaasen.htpasswd.util.hash.Crypt.generateSalt;

/**
 * Simple Htpasswd generator
 * <p/>
 * Can use both SHA-1 and MD-5 solutions. Please address that the SHA-1 solution is more apprecated than the MD-5 one.
 *
 * @author vegaasen
 * @since 1.0-SNAPSHOT
 */
public class HTPasswdGenerator extends AbstractUtil {

    private static final Logger LOGGER = Logger.getLogger(HTPasswdGenerator.class);
    private static final String V_APACHE_REALM_NAME = "apache.realm.name";
    private static final String RESULT_IDENTIFIER_SHA = "{SHA}";
    private static final String RESULT_IDENTIFIER_MD5 = "$apr1$";
    private static final String IDENTIFIER_MD5 = "MD5";
    private static final String MD_5_SEPERATOR = ":";
    private static final String DEFAULT_REALM_WIN_NAME = "Velkommen til WIN FTP. Vennligst oppgi ditt brukernavn/passord.";

    public static String generateEncryptedPassword(final String usr, final String pwd, final HTPasswdVariant type)
            throws NullPointerException {
        if (verifyNotNull(pwd, type)) {
            if (StringUtils.isNotEmpty(pwd)) {
                switch (type) {
                    case ALG_APSHA:
                        LOGGER.debug("Using SHA-1 with BASE-64");
                        return generateSha1Representation(pwd);
                    case ALG_CRYPT:
                        LOGGER.debug("Using CRYPT");
                        return generateCryptRepresentation(pwd);
                    case ALG_APMD5:
                        LOGGER.debug("Using MD5 + SALT");
                        return generateMD5Representation(pwd, usr);
                    default:
                        LOGGER.error("Please select hashing algorithm before continuing.");
                }
            }
        }
        LOGGER.error("Halted. Missing vital parameters.");
        throw new NullPointerException(E_OBJECT_WAS_NULL);
    }

    private static String generateSha1Representation(final String pwd) {
        if (StringUtils.isNotEmpty(pwd)) {
            LOGGER.debug("Hashing complete. Returning result <SHA1>");
            return RESULT_IDENTIFIER_SHA + new String(Base64.encodeBase64(
                    getMessageDigest("SHA1").digest(
                            pwd.getBytes()
                    )
            ));
        }
        LOGGER.debug("Unable to generate password using SHA-1. Missing parameter");
        return "";
    }

    private static String generateMD5Representation(final String pwd, final String usr) {
        try {
            String realm = String.valueOf(PropertiesUtil.loadProperties().get(V_APACHE_REALM_NAME)!=null ?
                    PropertiesUtil.loadProperties().get(V_APACHE_REALM_NAME) :
                    DEFAULT_REALM_WIN_NAME);
            String assembledString = usr + MD_5_SEPERATOR + realm + MD_5_SEPERATOR + pwd;
            byte digestedBytes[] = getMessageDigest(IDENTIFIER_MD5).digest((assembledString).getBytes());
            BigInteger bigInteger = new BigInteger(1, digestedBytes);
            String result = bigInteger.toString(16);
            while (result.length() < 32) {
                result = "0" + result;
            }
            LOGGER.debug("Hashing complete. Returning result <MD5>: " + RESULT_IDENTIFIER_MD5 + result);
            return RESULT_IDENTIFIER_MD5 + result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String generateCryptRepresentation(final String pwd) {
        LOGGER.debug("Hashing complete. Returning result <Crypt>");
        return cryptUsingStandardDES(generateSalt(), pwd);
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
