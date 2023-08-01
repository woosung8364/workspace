
class Student {

  // 생성자(객체)
  constructor(ssn, name, korean, english, math) {

    // this = {};
  
    this.ssn = ssn;
    this.name = name;
    this.korean = korean;
    this.english = english;
    this.math = math;
    // return this;
  
  }


  // 정적(static) 속성 및 메소드 추가
static schoolName = "Ezen 초등학교";

getName(){
  return this.name;
}

// 객체의 생성자 함수(객체)의 메소드를 Student 의 프로토타입 객체에 할당
getSum(){
  return this.korean + this.english + this.math;
}

getEnglish() {
  return this.english;
}

getAverage() {
  return this.getSum() / 3;
}

// Object 프로토타입 객체의 toString() 오버라이딩

toString() {
  return `${this.ssn} \t ${this.name} \t ${this.korean} \t ${this.english} \t ${this.math} \t ${this.getSum()} \t ${this.getAverage()}`
}



}

// console.log(Student);


export {Student};