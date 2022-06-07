<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>View Columns</title>
        <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Column</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${columnnames}" var="columns">
                    <tr>
                        <td>${columns}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>