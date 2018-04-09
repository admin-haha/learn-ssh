<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<% session.invalidate(); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>退出</title>
        <script type="text/javascript">
                parent.parent.location = '/login.jsp';
        </script>
    </head>
    <body>
    </body>
</html>
