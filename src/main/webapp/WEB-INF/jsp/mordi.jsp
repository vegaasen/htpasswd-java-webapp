<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>HTPassword Generation Service</title>
    </head>
    <body>
        <div class="content">
            <div class="info">
                <div class="info-title">
                    <fmt:message key="mordi.info.title"/>
                </div>
            </div>
            <div class="form-wrapper">
                <form action="mordi" onsubmit="" method="post" autocomplete="off" enctype="application/x-www-form-urlencoded">
                    <div class="input-frame-wrapper">
                        <div class="input-fields">
                            <div class="input-frame">
                                <label for="usr" class="input-label label">Username: </label>
                                <input type="text" class="input-field field"
                                       placeholder="t&lt;signature&gt;" required="required"
                                       pattern="^t([0-9+].*)$" maxlength="7" autofocus="true"
                                       id="usr" name="usr" value="" />
                            </div>
                            <div class="input-frame">
                                <label for="pwd" class="input-label label">Password: </label>
                                <input type="password" class="input-field field"
                                       placeholder="&lt;some password&gt;"
                                       required="required" value="" id="pwd" name="pwd" />
                            </div>
                        </div>
                        <div class="input-choosers">
                            <div class="input-frame">
                                <div class="information">
                                    <fmt:message key="mordi.generation.title"/>
                                </div>
                                <div class="radio-group">
                                    <div class="radio-button">
                                        <label for="ALG_APSHA">SHA-1</label>
                                        <input class="radio" checked="checked" type="radio" value="ALG_APSHA" id="ALG_APSHA" name="digestType"/>
                                        <a href="#" class="what-link">?</a>
                                        <span class="what-is-this">
                                            SHA-1 produces a 160-bit digest from a message with a maximum length of (264 − 1) bits.
                                        </span>
                                    </div>
                                    <div class="radio-button">
                                        <label for="ALG_APMD5">MD-5</label>
                                        <input class="radio" type="radio" id="ALG_APMD5" value="ALG_APMD5" name="digestType"/>
                                        <a href="#" class="what-link">?</a>
                                        <span class="what-is-this">
                                            The 128-bit (16-byte) MD5 hashes (also termed message digests) are typically represented as a sequence of 32 hexadecimal digits.
                                        </span>
                                    </div>
                                    <div class="radio-button">
                                        <label for="ALG_CRYPT">Crypt</label>
                                        <input class="radio" disabled="disabled" type="radio" id="ALG_CRYPT" value="ALG_CRYPT" name="digestType"/>
                                        <a href="#" class="what-link">?</a>
                                        <span class="what-is-this">
                                            crypt(3) is the library function which is used to compute a password hash.
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="input-buttons">
                            <div class="button-row">
                                <input type="submit" class="button-submit" value="Generate htpasswd" />
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>