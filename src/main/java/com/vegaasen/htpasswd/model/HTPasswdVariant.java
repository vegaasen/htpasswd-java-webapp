package com.vegaasen.htpasswd.model;

/**
 * @author vegaasen
 */
public enum HTPasswdVariant {
    USE_SHA1_WITH_BASE64("SHA-1"),
    USE_MD5_WITH_SALT("MD-5"),
    USE_CRYPT("Crypt");

    private String methodType;

    HTPasswdVariant(String methodType) {
        this.methodType = methodType;
    }

    public String getMethodType() {
        return methodType;
    }
}
