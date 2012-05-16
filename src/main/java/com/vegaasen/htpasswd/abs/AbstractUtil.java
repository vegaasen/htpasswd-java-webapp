package com.vegaasen.htpasswd.abs;

/**
 * @author vegaasen
 */
public class AbstractUtil {
    protected static final String E_OBJECT_WAS_NULL = "Object was null";
    protected static final String E_FILE_NOT_EXIST = "File does not exist";

    protected static boolean verifyNotNull(final Object... object) {
        boolean objectWasNotNull = true;
        for(Object o : object) {
            if(o==null) {
                objectWasNotNull = false;
                break;
            }
        }
        return objectWasNotNull;
    }

    protected static boolean verifyNull(final Object object) {
        return (object==null);
    }
}
