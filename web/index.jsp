<%@ page import="com.ru.Main" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Page WebApp</title>
</head>
<body>
<center>
    <h2>Hi! How are you?<br> <br><%=Main.test()%></h2>

    <h2>Dear guest, quantity of your sessions equals : <%=session.getAttribute("userCount")%> <br>
      <br>Thanks for your coming!</h2>
</center>
</body>
</html>
