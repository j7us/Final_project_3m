
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h1 style="text-align: center; margin-top: 40px" >Вопрос</h1>
<br/>
<p style="text-align: center">
    <img src="<c:out value="img/img${param.img}.jpeg"/>" width="500" height="500" alt="Kartinka">
</p>
<h3 style="text-align: center"><c:out value="${param.question}" /></h3>
<p style="margin-top: 20px; text-align: center">
   <c:forEach var="ans" items="${requestScope.answers}" varStatus="Counter">
       <button  class="btn btn-success" id="${Counter.count}">${ans}</button>
   </c:forEach>
</p>
<script>
    $(document).ready(function (){
        $('button').on("click", function (){
            window.location.href='/questLogicServlet?questNumber=' + (this.id-1);
        })
    })
</script>
</body>
</html>
