package com.vegaasen.htpasswd.model;

/**
 * @author vegaasen
 */
public enum HTPasswdVariant {
    ALG_APSHA("ALG_APSHA"),
    ALG_APMD5("ALG_APMD5"),
    ALG_CRYPT("ALG_CRYPT");

    private String digestType;

    HTPasswdVariant(String digestType) {
        this.digestType = digestType;
    }

    public String getDigestType() {
        return digestType;
    }

    public static HTPasswdVariant find(final String digestType) {
    if (digestType != null) {
      for (HTPasswdVariant currHtpasswd : HTPasswdVariant.values()) {
        if (digestType.equalsIgnoreCase(currHtpasswd.getDigestType())) {
          return currHtpasswd;
        }
      }
    }
    return null;
  }
}
