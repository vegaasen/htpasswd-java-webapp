<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title><fmt:message key="generator.title"/></title>
    </head>
    <c:set var="usernamePattern"><fmt:message key="pattern.default.regexp"/></c:set>
    <body>
        <div class="content">
            <div class="info">
                <div class="info-title">
                    <fmt:message key="generator.form.info.title"/>
                </div>
            </div>
            <div class="form-wrapper">
                <form action="#" onsubmit="" method="post" autocomplete="off" enctype="application/x-www-form-urlencoded">
                    <div class="input-frame-wrapper">
                        <div class="input-fields">
                            <div class="input-frame">
                                <label for="usr" class="input-label label"><fmt:message key="generator.form.username"/></label>
                                <input type="text" class="input-field field"
                                       placeholder="t&lt;signature&gt;" required="required"
                                       pattern="${usernamePattern}" maxlength="7" autofocus="true"
                                       id="usr" name="usr" value="${v_usr}" />
                            </div>
                            <div class="input-frame">
                                <label for="pwd" class="input-label label"><fmt:message key="generator.form.password"/></label>
                                <input type="password" class="input-field field"
                                       placeholder="&lt;some password&gt;"
                                       required="required" value="${v_pwd}" id="pwd" name="pwd" />
                            </div>
                        </div>
                        <div class="input-selectors">
                            <div class="input-frame">
                                <div class="information">
                                    <fmt:message key="generator.form.generation.title"/>
                                </div>
                                <div class="radio-group">
                                    <div class="radio-button">
                                        <input required="required" class="radio" type="radio" value="ALG_APSHA" id="ALG_APSHA" name="digestType"/>
                                        <label for="ALG_APSHA">SHA-1</label>
                                        <a href="#" class="what-link">?</a>
                                        <span class="what-is-this">
                                            <fmt:message key="generator.algorithm.sha1"/>
                                        </span>
                                    </div>
                                    <div class="radio-button">
                                        <input required="required" class="radio" type="radio" id="ALG_APMD5" value="ALG_APMD5" name="digestType"/>
                                        <label for="ALG_APMD5">MD-5</label>
                                        <a href="#" class="what-link">?</a>
                                        <span class="what-is-this">
                                            <fmt:message key="generator.algorithm.md5"/>
                                        </span>
                                    </div>
                                    <div class="radio-button">
                                        <input required="required" class="radio" type="radio" id="ALG_CRYPT" value="ALG_CRYPT" name="digestType"/>
                                        <label for="ALG_CRYPT">Crypt</label>
                                        <a href="#" class="what-link">?</a>
                                        <span class="what-is-this">
                                            <fmt:message key="generator.algorithm.crypt"/>
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
                <c:if test="${not(empty(v_genpwd))}">
                    <div class="result-wrapper">
                        <div class="result">
                            <div class="title">
                                <fmt:message key="generator.form.result.title"/>
                            </div>
                            <code class="r">
                                ${v_usr}:${v_genpwd}
                            </code>
                        </div>
                        <form action="/app/htpasswd_${v_usr}.text" method="post" enctype="application/x-www-form-urlencoded">
                            <div class="input-buttons">
                                <div class="hidden-fields">
                                    <input type="hidden" name="usr" id="gen_usr" value="${v_usr}" class="hidden"/>
                                    <input type="hidden" name="pwd" id="gen_pwd" value="${v_genpwd}" class="hidden"/>
                                    <input type="hidden" name="digestType" id="gen_digestType" value="${v_digestType}" class="hidden"/>
                                </div>
                                <div class="button-row">
                                    <input type="submit" class="button-submit" value="Download .htpasswd-file" />
                                </div>
                            </div>
                        </form>
                    </div>
                </c:if>
            </div>
        </div>
    </body>
</html>