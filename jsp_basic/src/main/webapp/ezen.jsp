<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
    integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="css/Ezen.css">
  <link rel="stylesheet" href="css/Media.css">
  <script type="module" defer src="./js/app.js"></script>
</head>

<body>

  <div class="side_bt">
    <a href="#top">
      <i class="fa-duotone fa-up">

    </a></i>
  </div>


  <!-- Title (Header) -->
  <div class="header" id="top">
    <img class="header_img" src="img/logo.png" alt="">
    <h1 class="title">EZEN 초등학교 성적 관리</h1>
  </div>

  <!--  학번 이름 국어 영어 수학 등록 삭제 -->
  <form action="#" name="inputForm">
    <div class="text_box">
      <div class="text_box2">
      <div class="input1 input">
        학번&nbsp; <input type="text" name="ssn" value="학번을 입력하세요" class="ssn1 input_text" id="input_ssn">
        <button type="button" class="ssn_search search ssn">
        </button>
      </div>

      <!-- 이름 -->
      <div class="input2 input">
        이름&nbsp; <input type="text" name="name" value="이름을 입력하세요" class="ssn1 input_text" id="input_name">
        <button type="button" class="ssn_search search name">
        </button>
      </div>

      <!-- 국어 -->
      <div class="input3 input">
        국어&nbsp; <input value="국어점수" type="text" name="korean" class="ssn1 input_text" id="input_korean">
        <button type="button"  class="ssn_search search korean">
        </button>
      </div>

      <!-- 영어 -->
      <div class="input4 input">
        영어&nbsp; <input value="영어점수" type="text" name="english" class="ssn1 input_text" id="input_english">
        <button type="button"  class="ssn_search search english">
        </button>
      </div>

      <!-- 수학 -->
      <div class="input5 input">
        수학&nbsp; <input value="수학점수" type="text" name="math" class="ssn1 input_text" id="input_math">
        <button type="button" class="ssn_search search math">
        </button>
      </div>

      <!-- 등록 -->
      <div class="input6 input" id="add_bt">
        <button type="button" name="addBtn" value="등록" class="ssn_submit search">
          등록
        </button> 
      </div>

      <!-- 삭제 -->
      <div class="input7 input" id="delete_bt">
        
        <button type="button" name="delete" value="" class="ssn_submit search delete">
          삭제
        </button>
      </div>

    </div>
    </div>
  </form>

<!-- @@@@검색창 구현@@@@ -->

  <!-- Select , 정렬방식 -->
  <form action="#" name="search_fast">
  <div class="select_box">
    <div class="content_select1">
      <!-- 선택칸 -->
    
      <select class="select1" name="ssearch" id="ssearch">
        <option selected value="all" id="all_bt">전체</option>
        <option value="search-ssn">학점</option>
        <option value="search-name">이름</option>
      </select>
      <!-- 텍스트창 -->
      <input type="text" name="search_select" class="input_text">
      <!-- 검색버튼 -->
      <button class="ssn_search2 search" name="search_bt" id="search_bt"></button>
    </form>
    </div>

    <!-- 정렬 (sort) -->
    <div class="content_select2">
      <h5>정렬방식</h5>
      <form action="" name="searchForm">
      <select class="select2" name="sort_select" id="sort_select">
        <option selected value="default" name="normal">기본</option>
        <option value="ssn" id="sort_score">성적순</option>
        <option value="name" id="sort_name">이름순</option>
      </select>
    </form>
    </div>
  </div>


  <!-- table -->
  <table id="studentTable">

    <!-- 표 제목 -->
    <thead>
      <tr class="table_header">
        <td id="td_ssn">학번</td>
        <td id="td_name">이름</td>
        <td id="td_korean">국어</td>
        <td id="td_english">영어</td>
        <td id="td_math">수학</td>
        <td id="td_score">총점</td>
        <td id="td_avg">평균</td>
        <td id="td_rank">순위</td>
      </tr>
    </thead>


    <!-- 1행 -->
    <tbody id="rows">

    </tbody>

  </table>




</body>

</html>