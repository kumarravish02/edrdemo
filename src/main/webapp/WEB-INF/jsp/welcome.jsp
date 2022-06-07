<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Hello world</title>
        <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Message</th>
                </tr>
            </thead>
            <tbody>
            	<tr>
                	<td>${message}</td>
                 </tr>
            </tbody>
        </table>
    </body>
</html>