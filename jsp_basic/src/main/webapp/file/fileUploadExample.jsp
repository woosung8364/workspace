<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<h2>파일 업로드 화면</h2>
<form action="/jsp/upload2" method="post" enctype="multipart/form-data"> <br>
업로드 파일 : <input type="file" name="upfile" multiple="multiple"><br>
업로더 이름 : <input type="text" name="uploader "><br>
<input type="submit" value="업로드"><br>
</form>
</body>
</html>