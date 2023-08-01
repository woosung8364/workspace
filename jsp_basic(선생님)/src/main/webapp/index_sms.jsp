<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>성적 관리 App</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
    integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <script type="module" defer src="./js/app.js"></script>
</head>

<body>
  <!-- =============== Header ============== -->
  <header class="display-5 text-center p-5 fw-bold">EZEN 초등학교 성적 관리</header>
  <!-- =============== Container ============== -->
  <div class="container text-center">

    <!-- =============== input row ============== -->
    <form action="#" name="inputForm">
      <div class="row">
        <div class="col-2">
          <label class="visually-hidden" for="autoSizingInputGroup">학번</label>
          <div class="input-group">
            <div class="input-group-text"><i class="fa-regular fa-id-card text-primary"></i></i></div>
            <input type="number" class="form-control" placeholder="학번" name="ssn">
          </div>
        </div>

        <div class="col-2">
          <label class="visually-hidden" for="autoSizingInputGroup">이름</label>
          <div class="input-group">
            <div class="input-group-text"><i class="fa-solid fa-user text-primary"></i></div>
            <input type="text" class="form-control" placeholder="이름">
          </div>
        </div>

        <div class="col-2">
          <label class="visually-hidden" for="autoSizingInputGroup">국어</label>
          <div class="input-group">
            <div class="input-group-text"><i class="fa-brands fa-korvue text-primary"></i></div>
            <input type="number" class="form-control" placeholder="국어점수">
          </div>
        </div>

        <div class="col-2">
          <label class="visually-hidden" for="autoSizingInputGroup">영어</label>
          <div class="input-group">
            <div class="input-group-text"><i class="fa-solid fa-e text-primary"></i></div>
            <input type="number" class="form-control" placeholder="영어점수">
          </div>
        </div>

        <div class="col-2">
          <label class="visually-hidden" for="autoSizingInputGroup">수학</label>
          <div class="input-group">
            <div class="input-group-text"><i class="fa-solid fa-m text-primary"></i></div>
            <input type="number" class="form-control" placeholder="수학점수">
          </div>
        </div>

        <div class="col-auto">
          <button type="button" class="btn btn-primary" id="addBtn"> 등 록 </button>
        </div>
        <div class="col-auto">
          <button type="button" class="btn btn-danger"> 삭 제 </button>
        </div>
      </div>
    </form>

    <hr>
    <!-- =============== search row ============== -->
    <div class="row mt-4 mb-2">
      <div class="col-6">
        <div class="row">
          <div class="col-2">
            <select class="form-select">
              <option selected>전체</option>
              <option value="ssn">학번</option>
              <option value="name">이름</option>
            </select>
          </div>
          <div class="col-3">
            <input type="text" class="form-control" placeholder="검색어">
          </div>
          <div class="col-2 text-start">
            <button type="button" class="btn btn-warning"> 검 색 </button>
          </div>
        </div>
      </div>

      <div class="col-6 ">
        <div class="row justify-content-end">
          <div class="col-2 text-end">
            <label for="sortSelect" class="col-form-label">정렬</label>
          </div>
          <div class="col-3">
            <select class="form-select" id="sortSelect">
              <option selected>기본</option>
              <option value="ssn">성적순</option>
              <option value="name">이름순</option>
            </select>
          </div>
        </div>
      </div>
    </div>

    <!-- =============== table row ============== -->
    <div class="row">
      <div class="col-12">
        <table class="table table-striped table-hover">
          <thead>
            <tr class="table-dark">
              <th>학번</th>
              <th>이름</th>
              <th>국어</th>
              <th>영어</th>
              <th>수학</th>
              <th>총점</th>
              <th>평균</th>
              <th>순위</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th>1</th>
              <td>김기정</td>
              <td>95</td>
              <td>90</td>
              <td>100</td>
              <td>285</td>
              <td>95.0</td>
              <td>1</td>
            </tr>
            <tr>
              <th>2</th>
              <td>이기정</td>
              <td>95</td>
              <td>90</td>
              <td>100</td>
              <td>285</td>
              <td>95.0</td>
              <td>2</td>
            </tr>
            <tr>
              <th>3</th>
              <td>박기정</td>
              <td>95</td>
              <td>90</td>
              <td>100</td>
              <td>285</td>
              <td>95.0</td>
              <td>3</td>
            </tr>
            <tr>
              <th>4</th>
              <td>최기정</td>
              <td>95</td>
              <td>90</td>
              <td>100</td>
              <td>285</td>
              <td>95.0</td>
              <td>4</td>
            </tr>
            <tr>
              <th>5</th>
              <td>송기정</td>
              <td>95</td>
              <td>90</td>
              <td>100</td>
              <td>285</td>
              <td>95.0</td>
              <td>5</td>
            </tr>
            <tr>
              <th>6</th>
              <td>김기정</td>
              <td>95</td>
              <td>90</td>
              <td>100</td>
              <td>285</td>
              <td>95.0</td>
              <td>6</td>
            </tr>
          </tbody>
        </table>
      </div>

    </div>

  </div>








  </div>
  <div class="row bg-secondary"></div>
  </div>


  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
    crossorigin="anonymous"></script>
</body>

</html>