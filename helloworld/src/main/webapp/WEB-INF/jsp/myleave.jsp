<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
  
<html>  
    <head>  
    <title>开始请假</title>  
    </head>  
    <body>  
  
    <form action="startFlow" method="post">  
		姓名：<input type="text" name="name" value="" /><br />   
		请假天数：<input type="text" name="leaveCount" value=""><br />   
		请假原因：<input type="text" name="leaveReason" value=""><br />   
        <input type="submit" value="提交">  
    </form>  
</body>  
</html>