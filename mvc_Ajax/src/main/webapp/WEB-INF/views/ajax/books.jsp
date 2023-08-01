<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>책 리스트</title>
  <script defer src="/js/books.js"></script>
</head>

<body>
  <button>책목록</button>
  <h2>서버로부터 수신한 책 목록</h2>
  <table border="1">
    <thead>
      <tr>
        <th>제목</th>
        <th>저자</th>
        <th>출판사</th>
        <th>가격</th>
        <th>장르</th>
      </tr>
    </thead>
    <tbody id="books">
      <tr>

      </tr>

    </tbody>
  </table>
</body>

</html>