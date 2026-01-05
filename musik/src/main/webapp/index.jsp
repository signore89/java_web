<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h3>Изучаем JSP!!!</h3>

<%
    String title = "Hello World";
    int len = title.length();
%>

<p>Длина строки: <%=title%> = <%=len%> символов</p>
<p>Сегодня: <%=new java.util.Date()%></p>
<p>5 > 2 = <%=true %></p>
</body>
</html>