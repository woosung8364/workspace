<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>다중 파일 업로드</title>
</head>
<body>
<h2>Spring MVC 파일 업로드</h2>
<form method="post" action="/upload2" enctype="multipart/form-data">
단일파일 : <input type="file" name="uploadfile"><br>
<!-- multiple: 이 속성은 여러 개의 파일을 선택할 수 있도록 해주는 속성입니다. 
사용자는 파일 선택 대화 상자에서 여러 파일을 동시에 선택할 수 있습니다.
-->
다중파일 : <input type="file" name="uploadfiles" multiple><br>
<input type="text" name="uploader" placeholder="업로더"><br>
<input type="text" name="description" placeholder="파일설명"><br>
<button type="submit">업로드</button>
</form>
</body>
</html>