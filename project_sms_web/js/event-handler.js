/**
 * 이벤트 처리를 객체화
 */

import { StudentRepository } from "./student-repository.js";
import { Validator } from "./validator.js";
import { studentRepository } from "./app.js";
import { Student } from "./Student.js";

class EventHandler {
  constructor() { }

  // 이벤트 소스에 이벤트 핸들러 등록
  eventRegist() {
    // 학생 성적 추가 구획 form 속성 default 처리
    document.inputForm.addEventListener('submit', event => {
      event.preventDefault();
    })

    // 학생정보 입력후 등록버튼을 누르면 입력받은 정보대로 한행이 추가되는 이벤트
    document.inputForm.addBtn.addEventListener('click', event => {
      this.addStudent(event);
    });

    // 검색칸 form 속성 default 처리
    document.search_fast.addEventListener('submit', event => {
      event.preventDefault();
    })

    // 검색 - 셀렉트 (전체)로 바꿨을때 전체리스트가 다시 출력되게 하는 이벤트
    document.querySelector('#ssearch').addEventListener('change', event => {
      let allValue = document.querySelector('#ssearch').value;
      if (allValue === 'all') {
        alert('전체리스트를 불러옵니다');
        this.findAllStudent(event);
      }
    })

    // 학번 이름 국어 영어 수학에 적혀져있는 벨류값이 클릭시 공백으로 초기화되는 이벤트
    document.inputForm.addEventListener('click' , event =>{
      this.resetValue(event);
    })


    // 검색기능 - 학번검색 이름검색
    document.querySelector('#search_bt').addEventListener('click', event => {
      this.selectSearch(event);
      // console.log('click~!');
    })



    // 정렬기능 - 학번 이름순 정렬
    document.querySelector('#sort_select').addEventListener('change', event => {
      this.selectSolt();
    })

    // 표에서 학번을 클릭했을때 내림차순 정렬
    document.querySelector('#td_ssn').addEventListener('click', event => {
      this.clickSoltSsn();
    })

    // 표에서 이름을 클릭했을때 내림차순 정렬
    document.querySelector('#td_name').addEventListener('click', event => {
      this.clickSoltName();
    })

    // 표에서 국어점수를 클릭했을때 오름차순 정렬
    document.querySelector('#td_korean').addEventListener('click', event => {
      this.clickSoltKorean();
    })

    // 표에서 영어점수를 클릭했을때 오름차순 정렬
    document.querySelector('#td_english').addEventListener('click', event => {
      this.clickSoltEnlgish();
    })

    // 표에서 수학점수를 클릭했을때 오름차순 정렬
    document.querySelector('#td_math').addEventListener('click', event => {
      this.clicksoltMath();
    })

    // 표에서 총점수를 클릭했을때 오름차순 정렬
    document.querySelector('#td_score').addEventListener('click', event => {
      this.clickSoltGetSum();
    })
 
    // 표에서 평균점수를 클릭했을때 오름차순 정렬
    document.querySelector('#td_avg').addEventListener('click', event => {
      this.clickSoltGetAverage();
    })

    // 표에서 랭크를 클릭했을때 내림차순 정렬
    document.querySelector('#td_rank').addEventListener('click', event => {
      this.clickSoltGetRank();
    })



    // 삭제기능 - 학번을 입력하면 해당 학번을 삭제한후의 배열 리턴
    document.inputForm.delete.addEventListener('click', event => {
      alert('입력하신 학번을 가진 학생을 삭제하였습니다');
      this.deleteSsnByStudent();
    })




  }

  // input tag 클릭시 value를 초기화 시키는 함수
  resetValue(event){
    const ssn = document.getElementById('input_ssn');
    ssn.value="";
    ssn.value=  document.inputForm.ssn.value;

    const name = document.getElementById('input_name');
    name.value = "";
    name.value = document.inputForm.name.value;
    
    const korean = document.getElementById('input_korean');
    korean.value = "";
    korean.value = document.inputForm.korean.value;
    
    const english = document.getElementById('input_english');
    english.value = "";
    english.value = document.inputForm.english.value;

    const math = document.getElementById('input_math');
    math.value = "";
    math.value = document.inputForm.math.value;

  }


  // 학생 등록함수
  addStudent(event) {
    const ssn = parseInt(document.inputForm.ssn.value);
    const name = document.inputForm.name.value;
    const korean = parseInt(document.inputForm.korean.value);
    const english = parseInt(document.inputForm.english.value);
    const math = parseInt(document.inputForm.math.value);
    // console.log(ssn, name, korean);


    if (!Validator.hasNumber(ssn)) {
      console.log(ssn);
      alert('학번에는 문자나 공백이 들어갈 수 없습니다.');
      return;
    } else if (!Validator.hasText(name)) {
      console.log(name);
      alert('이름에는 숫자나 공백이 포함될 수 없습니다.');
      return;
    } else if (!Validator.hasNumber(korean)) {
      alert('국어 점수에는 문자나 공백이 들어갈 수 없습니다.');
      return;
    } else if (!Validator.hasNumber(english)) {
      alert('영어점수에는 문자나 공백이 들어갈 수 없습니다.');
      return;
    } else if (!Validator.hasNumber(math)) {
      alert('수학점수에는 문자나 공백이 들어갈 수 없습니다.');
      return;
    }

    const student = new Student(ssn, name, korean, english, math);
    studentRepository.addStudent(student);
    alert('등록완료');
    this.findAllStudent(event);

  }


  // 학생목록
  findAllStudent(event) {
    let allList = studentRepository.getStudents();
    console.dir(allList);

    let html = '';
    let rankArray = this.calcRank();
    let count = 0;
    for (const student of allList) {
      let ssn = student.ssn;
      let name = student.name;
      let korean = student.korean;
      let english = student.english;
      let math = student.math;
      let sum = student.getSum();
      let average = student.getAverage();
      let rank = rankArray[count];
      html += "<tr><td>" + ssn + "</td><td>" + name + "</td><td>" + korean + "</td><td>" + english + "</td><td>" + math + "</td><td>" + sum + "</td><td>" + average + "</td><td>" + rank;
      count++;
    }


    document.querySelector('#rows').innerHTML = html;
  }


  /**
   * 정렬기능 구현 함수
   */

  // 클릭시 학번을 내림차순으로 정렬하는 함수
  clickSoltSsn() {
    let allList = studentRepository.getStudents();
    let sort = studentRepository.findAllBySolt((a,b) => a.rank - b.rank);
    sort = studentRepository.findAllBySolt((a, b) => a.ssn - b.ssn);
    let html = '';
    let stRank = this.calcRank();

    for (let i = 0; i < allList.length; i++) {
      let student = sort[i]
      let ssn = student.ssn;
      let name = student.name;
      let korean = student.korean;
      let english = student.english;
      let math = student.math;
      let sum = student.getSum();
      let average = student.getAverage();
      let rank = stRank[i];
      html += "<tr><td>" + ssn + "</td><td>" + name + "</td><td>" + korean + "</td><td>" + english + "</td><td>" + math + "</td><td>" + sum + "</td><td>" + average + "</td><td>" + rank;
    }

    document.querySelector('#rows').innerHTML = html;


  }

  // 클릭시 이름을 내림차순으로 정렬하는 함수
  clickSoltName() {
    let allList = studentRepository.getStudents();
    let sort = studentRepository.findAllBySolt((a,b) => a.ssn - b.ssn);
    sort = studentRepository.findAllBySolt((a, b) => a.name.localeCompare(b.name));
    let html = '';
    let stRank = this.calcRank();

    for (let i = 0; i < allList.length; i++) {
      let student = sort[i];
      let ssn = student.ssn;
      let name = student.name;
      let korean = student.korean;
      let english = student.english;
      let math = student.math;
      let sum = student.getSum();
      let average = student.getAverage();
      let rank = stRank[i];
      html += "<tr><td>" + ssn + "</td><td>" + name + "</td><td>" + korean + "</td><td>" + english + "</td><td>" + math + "</td><td>" + sum + "</td><td>" + average + "</td><td>" + rank;
    }


    document.querySelector('#rows').innerHTML = html;


  }

  // 클릭시 국어점수를 오름차순으로 정렬하는 함수
  clickSoltKorean() {
    let allList = studentRepository.getStudents();
    let sort = studentRepository.findAllBySolt((a,b) => a.ssn - b.ssn);
    sort = studentRepository.findAllBySolt((a,b) => b.korean- a.korean);
    let html = '';
    let stRank = this.calcRank();

    for (let i = 0; i < allList.length; i++) {
      let student = sort[i];
      let ssn = student.ssn;
      let name = student.name;
      let korean = student.korean;
      let english = student.english;
      let math = student.math;
      let sum = student.getSum();
      let average = student.getAverage();
      let rank = stRank[i];
      html += "<tr><td>" + ssn + "</td><td>" + name + "</td><td>" + korean + "</td><td>" + english + "</td><td>" + math + "</td><td>" + sum + "</td><td>" + average + "</td><td>" + rank;
    }
    document.querySelector('#rows').innerHTML = html;
  }

  // 클릭시 영어점수를 오름차순으로 정렬하는 함수
  clickSoltEnlgish() {
    let allList = studentRepository.getStudents();
    let sort = studentRepository.findAllBySolt((a,b) => a.ssn - b.ssn);
    sort = studentRepository.findAllBySolt((a,b) => b.english- a.english);
    let html = '';
    let stRank = this.calcRank();

    for (let i = 0; i < allList.length; i++) {
      let student = sort[i];
      let ssn = student.ssn;
      let name = student.name;
      let korean = student.korean;
      let english = student.english;
      let math = student.math;
      let sum = student.getSum();
      let average = student.getAverage();
      let rank = stRank[i];
      html += "<tr><td>" + ssn + "</td><td>" + name + "</td><td>" + korean + "</td><td>" + english + "</td><td>" + math + "</td><td>" + sum + "</td><td>" + average + "</td><td>" + rank;
    }

    document.querySelector('#rows').innerHTML = html;


  }

  // 클릭시 수학점수를 오름차순으로 정렬하는 함수
  clicksoltMath() {
    let allList = studentRepository.getStudents();
    let sort = studentRepository.findAllBySolt((a,b) => a.ssn - b.ssn);
    sort = studentRepository.findAllBySolt((a,b) => b.math - a.math);
    let html = '';
    let stRank = this.calcRank();

    for (let i = 0; i < allList.length; i++) {
      let student = sort[i];
      let ssn = student.ssn;
      let name = student.name;
      let korean = student.korean;
      let english = student.english;
      let math = student.math;
      let sum = student.getSum();
      let average = student.getAverage();
      let rank = stRank[i];
      html += "<tr><td>" + ssn + "</td><td>" + name + "</td><td>" + korean + "</td><td>" + english + "</td><td>" + math + "</td><td>" + sum + "</td><td>" + average + "</td><td>" + rank;
    }

    document.querySelector('#rows').innerHTML = html;


  }

  // 클릭시 총점수를 오름차순으로 정렬하는 함수
  clickSoltGetSum() {
    let allList = studentRepository.getStudents();
    let sort = studentRepository.findAllBySolt((a,b) => a.ssn - b.ssn);
    sort = studentRepository.findAllBySolt((a,b) => b.getSum() - a.getSum());
  
    let html = '';
    let stRank = this.calcRank();

    for (let i = 0; i < allList.length; i++) {
      let student = sort[i];
      let ssn = student.ssn;
      let name = student.name;
      let korean = student.korean;
      let english = student.english;
      let math = student.math;
      let sum = student.getSum();
      let average = student.getAverage();
      let rank = stRank[i];
      html += "<tr><td>" + ssn + "</td><td>" + name + "</td><td>" + korean + "</td><td>" + english + "</td><td>" + math + "</td><td>" + sum + "</td><td>" + average + "</td><td>" + rank;
    }

    document.querySelector('#rows').innerHTML = html;


  }

  // 클릭시 평균점수를 오름차순으로 정렬하는 함수
  clickSoltGetAverage() {
    let allList = studentRepository.getStudents();
    let sortAVG = studentRepository.findAllBySolt((a,b) => a.ssn - b.ssn);
    sortAVG = studentRepository.findAllBySolt((a,b) => b.getAverage()- a.getAverage());
    let stRank = this.calcRank();
    let html = '';

    for (let i = 0; i < allList.length; i++) {
      let student = sortAVG[i];
      let ssn = student.ssn;
      let name = student.name;
      let korean = student.korean;
      let english = student.english;
      let math = student.math;
      let sum = student.getSum();
      let average = student.getAverage();
      let rank = stRank[i];
      html += "<tr><td>" + ssn + "</td><td>" + name + "</td><td>" + korean + "</td><td>" + english + "</td><td>" + math + "</td><td>" + sum + "</td><td>" + average + "</td><td>" + rank;
    }

    document.querySelector('#rows').innerHTML = html;


  }

  // 클릭시 랭킹순위를 오름차순으로 정렬하는 함수
  clickSoltGetRank() {
    let allList = studentRepository.getStudents();
    let stRank = this.calcRank();
    let sortRank = studentRepository.findAllBySolt((a,b) => a.ssn - b.ssn);
    sortRank = studentRepository.findAllBySolt((a,b) => b.getAverage()- a.getAverage());
    let html = '';
    let count = 0;

    for (let i = 0; i < allList.length; i++) {
      let student = sortRank[i];
      let ssn = student.ssn;
      let name = student.name;
      let korean = student.korean;
      let english = student.english;
      let math = student.math;
      let sum = student.getSum();
      let average = student.getAverage();
      let rank = stRank[i];
      count++;
      html += "<tr><td>" + ssn + "</td><td>" + name + "</td><td>" + korean + "</td><td>" + english + "</td><td>" + math + "</td><td>" + sum + "</td><td>" + average + "</td><td>" + rank;
    }

    document.querySelector('#rows').innerHTML = html;


  }



  // 셀렉트 정렬방식 - 성적순 , 이름순
  selectSolt() {
    let allList = studentRepository.getStudents();
    let value = document.searchForm.sort_select.value;
    if (value === 'ssn') {
      let scoreCalc = allList.sort((a, b) => b.getAverage() - a.getAverage());
      this.findAllStudent(scoreCalc);
      alert('점수순 정렬을 선택했습니다');
    } else if (value === 'name') {
      let nameCalc = allList.sort((num1, num2) => num1.name.localeCompare(num2.name));
      this.findAllStudent(nameCalc);
      alert('이름순 정렬을 선택했습니다');
    }

  }


  /**
   * 검색기능 구현 함수
   */
  selectSearch() {
    // 셀렉트 - 학번이랑 이름중 뭘 선택했는지 벨류리턴
    const selectedValue = document.search_fast.ssearch.value;


    // 만약 셀렉트를 통하여 '학점'을 선택했다면
    if (selectedValue === 'search-ssn') {
      // 검색하기위해 텍스트창에 입력한 값 리턴
      let inputValue = parseInt(document.search_fast.search_select.value);
      let html = '';
      if (!Validator.hasNumber(inputValue)) {
        alert('학번에는 문자가 포함될 수 없습니다');
        return;
      }
      let allList = studentRepository.findBySsn(inputValue);
      alert('입력하신 학번에 해당하는 학생을 조회하였습니다');
      let student = allList;
      let ssn = student.ssn;
      let name = student.name;
      let korean = student.korean;
      let english = student.english;
      let math = student.math;
      let sum = student.getSum();
      let average = student.getAverage();
      let rank = 1;
      html += "<tr><td>" + ssn + "</td><td>" + name + "</td><td>" + korean + "</td><td>" + english + "</td><td>" + math + "</td><td>" + sum + "</td><td>" + average + "</td><td>" + rank + "</td><td>";
      document.querySelector('#rows').innerHTML = html;


    } else if (selectedValue === 'search-name') {
      // 검색하기위해 텍스트창에 입력한 값 리턴
      let inputValue = document.search_fast.search_select.value;
      console.log(inputValue);
      let html = '';
      if (!Validator.hasText(inputValue)) {
        alert('이름에는 숫자가 포함될 수 없습니다');
        return;
      }
      alert('입력하신 이름에 해당하는 학생을 조회하였습니다');
      let allList = studentRepository.findByName(inputValue);
      let student = allList;
      let ssn = student.ssn;
      let name = student.name;
      let korean = student.korean;
      let english = student.english;
      let math = student.math;
      let sum = korean + english + math;
      let average = sum / 3;
      let rank = this.calcRank();
      html += "<tr><td>" + ssn + "</td><td>" + name + "</td><td>" + korean + "</td><td>" + english + "</td><td>" + math + "</td><td>" + sum + "</td><td>" + average + "</td><td>" + rank + "</td><td>";
      document.querySelector('#rows').innerHTML = html;
    }
  }

  // 학번으로 학생삭제
  deleteSsnByStudent() {
    let deleteInput = parseInt(document.inputForm.ssn.value);
    let deleteArray = studentRepository.removeBySsn(deleteInput);
    this.findAllStudent(deleteArray);
  }

  // 학생 랭크 계산
  calcRank(){
    let allList = studentRepository.getStudents();
    let getSumArray = [];
    let rankArray = [];

    for (const student of allList) {
      getSumArray.push(student.getSum());
    }

    for (let i = 0; i < getSumArray.length; i++) {
      rankArray[i]= 1;
      for (let j = 0; j < getSumArray.length; j++) {
        if (getSumArray[i] < getSumArray[j]) {
          rankArray[i]++;
        }
        
      }
      
    }
    return rankArray;
  }

}


export { EventHandler };