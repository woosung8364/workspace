// 학생객체 생성을 위한 틀(클래스)
class Student {
  constructor(ssn, name, korean, english, math) {
    // this = {};
    this.ssn = ssn;
    this.name = name;
    this.korean = korean;
    this.english = english;
    this.math = math;
  }

  // 정적(static) 속성 및 메소드 추가
  //static schoolName = "Ezen초등학교";

  getSum() {
    return this.korean + this.english + this.math;
  }

  getAverage() {
    return this.getSum() / 3;
  }

  toString() {
    return `${this.ssn} \t ${this.name} \t ${this.korean} \t ${this.english} \t ${this.math} \t ${this.getSum()} \t ${this.getAverage()}`;
  }
}

export {Student};
