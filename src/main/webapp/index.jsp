<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center"><%= "Добро Пожаловать!" %></h1>
<br/>
<p style="text-align: center">Чтобы начать наше путешествие нажми на кнопку под картинкой</p>
<p style="text-align: center"><img src='img/startPage.png' alt="Pr" width="500" height="500"></p>
<br/>
<form action="register.jsp" style="text-align: center">
  <input type="submit" value="Начать приключение" class="btn btn-success">
</form>
</body>
</html>