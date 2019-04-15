<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2019/4/12
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
<center>
    <fieldset style="width: 300px;">
        <legend>
            添加
        </legend>
        <form action="TeacherServlet?action=add" method="post">
            <table>
                <tr>
                    <td>
                        姓名:
                    </td>
                    <td>
                        <input type="text" name="name"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        年龄:
                    </td>
                    <td>
                        <input type="number" name="age"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        性别:
                    </td>
                    <td>
                        <input type="radio" name="sex" value="男" checked="checked"/>男
                        <input type="radio" name="sex" value="女"/>女
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="添加" />
                    </td>
                    <td>
                        <input type="reset" value="重置" />
                    </td>
                </tr>
            </table>
        </form>
    </fieldset>
</center>
</body>
</html>

