<%--
  Created by IntelliJ IDEA.
  User: igooorrrrr
  Date: 26.09.2023
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h3 style="text-align: center">Самое время придумать имя нашему программисту!</h3>
<br/>
<form style="text-align: center" action="${pageContext.request.contextPath}/userAndQuestServlet" method="get">
    <label for="name">Введите имя</label>
    <input type="text" name="name" id="name">
    <input type="submit" value="Создать" class="btn btn-success">
</form>
</body>
</html>
