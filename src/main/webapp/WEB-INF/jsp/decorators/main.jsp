<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html>
<html>
<head>
    <link href="css/fonts.css" media="screen, projection" rel="stylesheet" type="text/css" />
    <link href="css/site.css" media="screen, projection" rel="stylesheet" type="text/css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Language" content="en" />
    
    <title>
        <decorator:title default="Fallback Title - Change please!!"/>
    </title>
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
        <!--Scripts-->
        <script src="js/jquery/jq-min.js?version=1.7.1" type="text/javascript"></script>
        <script src="js/jquery/jq.zclip.js?version=1.7.1" type="text/javascript"></script>
        <script src="js/startup/startup.js?version=1.0" type="text/javascript"></script>
    </body>
</html>