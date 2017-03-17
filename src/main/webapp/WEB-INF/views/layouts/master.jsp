<%@ page contentType="text/html; UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hello World</title>

    <link rel="stylesheet" href="<c:url value='/static/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/static/css/style.css'/>">
</head>
<body>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">

            <div class="navbar-header">
                <!-- Collapsed Hamburger -->
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu-navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Name</a>
            </div>

            <div class="collapse navbar-collapse" id="menu-navbar-collapse">
                <tiles:insertAttribute name="menu"/>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="row">

            <div class="col-md-8">
                <tiles:insertAttribute name="body"/>
            </div>

            <div class="col-md-4">
                <tiles:insertAttribute name="widget"/>
            </div>
        </div>
    </div>

    <script src="<c:url value='/static/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/js/bootstrap.min.js'/>"></script>
</body>
</html>