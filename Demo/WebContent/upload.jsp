<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传表单</title>
</head>
<body>
	<h3>文件上传：</h3>
	请选择要上传的文件：
	<br />
	<form action="UploadImage" method="post" enctype="multipart/form-data">
		<input type="file" name="file" size="50" /> <br /> <input
			type="submit" value="上传文件" /> <input type="text" name="id" value="1">
		<input type="text" name="sessionId" value="2">
	</form>
</body>
</html>