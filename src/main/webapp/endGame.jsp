<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<c:if test="${param.gameRes==1}">
    <h1 style="text-align: center">Поздравляю, вы выиграли</h1>
    <br/>
    <p style="text-align: center"><img src="img/win.jpeg" alt="WIN" width="500" height="500"></p>
</c:if>
<c:if test="${param.gameRes==2}">
    <h1 style="text-align: center">Сожалею, попробуй еще раз</h1>
    <br/>
    <p style="text-align: center"><img src="img/loss.jpg" alt="WIN" width="300" height="300"></p>
</c:if>

<table class="table table-bordered" style="width: 300px; margin: auto"  >
    <tr>
        <th>Имя</th>
        <th style="width: 150px">Попытки</th>
    </tr>
    <tr>
        <td><c:out value="${sessionScope.user.name}" /></td>
        <td><c:out value="${sessionScope.count}" /></td>
    </tr>
</table>
<br/>
<form action="register.jsp" style="text-align: center">
    <input type="submit" value="Попробовать еще раз" class="btn btn-success">
</form>
</body>
</html>
