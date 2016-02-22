<%--
  Created by IntelliJ IDEA.
  User: hhernandez
  Date: 27/10/15
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="guestBean" scope="request" class="com.codetutr.GuessBean">
  <jsp:setProperty name="guestBean" property="guestName"/>
  </jsp:useBean>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:getProperty name="guestBean" property="guestName"/>
</body>
</html>
