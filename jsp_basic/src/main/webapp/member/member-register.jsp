<%@ page contentType="text/html; charset=utf-8" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입</title>
</head>

<body>
    <form action="<%=application.getContextPath() %>/member/member-register-action2.jsp" method="post">
        <table width="940" " border=" 1">
            <caption>회원가입</caption>
            <tr>
                <th> 이름</th>
                <td><input type="text" name="name" ></td>
            </tr>
            <tr>
                <th>주민등록번호</th>
                <td><input type="text" name="ssn1"> -
                    <input type="password" name="ssn2">
                </td>
            </tr>
            <tr>
                <th>아이디</th>
                <td>
                    <input type="text" name="id">
                </td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="password" name="passwd"> 영문/숫자포함 8자 이상</td>
            </tr>
            <tr>
                <th>비밀번호 확인</th>
                <td><input type="password" name="re-upassword"></td>
            </tr>
            <tr>
                <th>비밀번호 힌트/답변</th>
                <td><select name='pwhint' size='1'>
                        <option value=''>선택하세요</option>
                        <option value='10'>졸업한 초등학교 이름은?</option>
                        <option value='11'>제일 친한 친구의 핸드폰 번호는?</option>
                        <option value='12'>아버지 성함은?</option>
                        <option value='13'>어머니 성함은?</option>
                        <option value='14'>어릴 적 내 별명은?</option>
                        <option value='15'>가장 아끼는 물건은?</option>
                        <option value='16'>좋아하는 동물은?</option>
                        <option value='17'>좋아하는 색깔은?</option>
                        <option value='18'>좋아하는 음식은?</option>
                    </select>
            </tr>
            <tr>
                <th>답변</th>
                <td><input type='text' name='pwhint-value'></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td>
                    <input type='text' name="mail">@
                    <input type='text' name="email_dns">
                    <select name="emailaddress">
                        <option value="">직접입력</option>
                        <option value="daum.net">daum.net</option>
                        <option value="empal.com">empal.com</option>
                        <option value="gmail.com">gmail.com</option>
                        <option value="hanmail.net">hanmail.net</option>
                        <option value="msn.com">msn.com</option>
                        <option value="naver.com">naver.com</option>
                        <option value="nate.com">nate.com</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>주소</th>
                <td>
                    <input type="text" name="zip-code" placeholder="우편번호"><br>
                    <input type="text" name="addr_basic" placeholder="주소">
                    <input type="text" name="addr_detail" placeholder="상세주소">
                </td>
            </tr>
            <tr>
                <th>전화번호</th>
                <td><input type="number" name="tel1"> -
                    <input type="number" name="tel2"> -
                    <input type="number" name="tel3">
                </td>
            </tr>
           
            <tr>
                <th>직업</th>
                <td>
                    <select name='job' size='1'>
                        <option value=''>선택하세요</option>
                        <option value='1'>학생</option>
                        <option value='2'>컴퓨터/인터넷</option>
                        <option value='3'>언론</option>
                        <option value='4'>공무원</option>
                        <option value='5'>군인</option>
                        <option value='6'>서비스업</option>
                        <option value='7'>교육</option>
                        <option value='8'>금융/증권/보험업</option>
                        <option value='9'>유통업</option>
                        <option value='10'>예술</option>
                        <option value='11'>의료</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>메일/SNS 정보 수신</th>
                <td>
                    <input type="radio" name="chk_sns" value="0" checked> 수신
                    <input type="radio" name="chk_sns" value="1"> 수신거부
                </td>
            </tr>
            <tr>
                <th> 관심분야 </th>
                <td>
                    <input type='checkbox' name='interest' value="s"> 생두
                    <input type='checkbox' name='interest'> 원두
                    <input type='checkbox' name='interest'> 로스팅
                    <input type='checkbox' name='interest'> 핸드드립
                    <input type='checkbox' name='interest'> 에스프레소
                    <input type='checkbox' name='interest'> 창업
                </td>
            </tr>
            <tr>
                <th>가입경로</th>
                <td>
                    <select name='location' size='1'>
                        <option value=''>선택하세요</option>
                        <option value='naver'>네이버검색</option>
                        <option value='daum'>다음검색</option>
                        <option value='search'>기타검색엔진</option>
                        <option value='cafe'>카페or동호회를 통해</option>
                        <option value='friend'>지인의소개</option>
                        <option value='etc'>기타</option>
                    </select>
                </td>
            </tr>

            <tr>
                <th>정보공개여부</th>
                <td>
                    <select name='chk_open' size='1'>
                        <option value=''>선택하세요</option>
                        <option value='0'>모두공개</option>
                        <option value='1'>비공개</option>
                        <option value='2'>1단계공개</option>
                        <option value='3'>2단계공개</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="회원가입">
                    <input type="reset" value="취소">
                </td>
            </tr>
        </table>

    </form>
</body>

</html>