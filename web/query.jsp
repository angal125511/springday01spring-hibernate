<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/4/12
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>teacher</title>
</head>
<body>
<table>
    <%-- 表头 --%>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>操作</th>
    </tr>
    <%--数据--%>
    <c:forEach items="${teacherList}" var="angal">
        <tr>
            <td>${angal.id}</td>
            <td>${angal.name}</td>
            <td>${angal.age}</td>
            <td>${angal.sex}</td>
            <td>
                <a title="修改" href="<%=request.getContextPath()%>/TeacherServlet?action=queryOne&id=${angal.id}">
                    修改
                </a>
                <a title="删除" href="<%=request.getContextPath()%>/TeacherServlet?action=delete&id=${angal.id}">
                    删除
                </a>
                <a title="添加" href="/add.jsp">
                    添加
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<%-- 分页页码  --%>
<div>
    <c:forEach var="i" begin="1" end="${pages}" >
        <a href="/TeacherServlet?action=queryPage&pageIndex=${i}">
                ${i}
        </a>
    </c:forEach>
</div>
</body>
</html>
