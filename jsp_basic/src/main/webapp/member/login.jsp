<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <!-- 아이콘 폰트 사용-->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
    integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="style.css">
</head>

<body>
  <form id="login" action='<c:url value="/login-action.jsp"/>' method="post">
    <fieldset>
      <legend>구글 로그인</legend>
      <button type="button">
        <i class="fa-brands fa-google"></i> Log in with Google
      </button>
    </fieldset>
    <p>or</p>
    <fieldset>
      <legend>로그인</legend>
      <label for="userid">
        <input type="text" id="userid" name="uid" placeholder="Userid">
      </label>
      <label for="password">
        <input type="password" id="password" name="upw" placeholder="Password">
      </label>
      <button type="submit">
        LOGIN
      </button>
    </fieldset>
    <a href="#">Forgot your password?</p>
  </form>
</body>

</html>