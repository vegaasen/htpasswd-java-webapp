<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html>
<html>
<head>
    <spring:url value="/resources/css/fonts.css" var="css_fonts"/>
    <spring:url value="/resources/css/site.css" var="css_site"/>
    <spring:url value="/resources/js/jquery/jq-min.js?version=1.7.1" javaScriptEscape="false" var="js_jquery"/>
    <spring:url value="/resources/js/jquery/jq.zclip.js?version=1.7.1" javaScriptEscape="false" var="js_jquery_jzclip"/>
    <spring:url value="/resources/js/startup/startup.js?version=1.0-SNAPSHOT" javaScriptEscape="false" var="js_startup"/>
    <spring:url value="/resources/images/favicon.ico" var="favicon" />
    <link href="${css_fonts}" media="screen, projection" rel="stylesheet" type="text/css" />
    <link href="${css_site}" media="screen, projection" rel="stylesheet" type="text/css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Language" content="en" />
    <link rel="SHORTCUT ICON" href="${favicon}" />
    <c:set var="userLocale">
        <c:out value="${pageContext.response.locale}" default="en" />
    </c:set>
    <title><decorator:title default="Fallback Title - Change please!!"/></title>
    <decorator:head/>
</head>
    <body>
        <div id="container">
            <div id="header">
                <h1><fmt:message key="header.title"/></h1>
            </div>
            <div id="main">
                <decorator:body/>
            </div>
            <div id="footer">
            </div>
        </div>
        <script src="${js_jquery}" type="text/javascript"></script>
        <script src="${js_jquery_jzclip}" type="text/javascript"></script>
        <script src="${js_startup}" type="text/javascript"></script>
    </body>
</html>