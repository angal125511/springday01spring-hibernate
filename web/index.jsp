<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/4/12
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    response.sendRedirect(request.getContextPath()+"/TeacherServlet?action=queryPage");
  %>

  </body>
</html>
