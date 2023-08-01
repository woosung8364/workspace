// 여러 학생 목록 관리 객체
// 학생 추가 , 학생검색 , 학생 전체목록 조회

import { Student } from "./Student.js";
import { studentRepository } from "./app.js";

class StudentRepository {


  constructor() {
    // this = {};
    this.students = [];

  }


  addStudent(student) {
    this.students.push(student);
  }

  getStudents () {
    return this.students;
  }


  // 학번으로 학생 검색
  findBySsn(ssn) {
    let findSt = this.students.find(student => student.ssn === ssn);
    return findSt;

  }


  // 이름으로 학생 검색
  findByName(name) {
    let findNa = this.students.find(student => student.name === name);
    return findNa;
  }

  // 국어점수로 학생검색
  findByKorean(korean){
    let findNa = this.students.find(student => student.korean === korean);
    return findNa;
  }

  // 국어점수로 학생검색
  findByEnglish(english){
    let findNa = this.students.find(student => student.english === english);
    return findNa;
  }


  // 국어점수로 학생검색
  findByMath(math){
    let findNa = this.students.find(student => student.math === math);
    return findNa;
  }


  // 학번으로 학생 삭제

  removeBySsn(ssn) {
    this.students.forEach((student, index) => {
      if (student.ssn === ssn) {
        this.students.splice(index, 1);
        return this.students;
      } else{
        return false;
      }
    });
    
  }

 
  


  // 평균범위로 검색
  findByRange(start, end) {
    let list = [];
    this.students.forEach(student => {
      if (student.getAverage() >= start && student.getAverage() <= end) {
        list.push(student);
      }
    });
  }

  findAllBySolt(fn) {
    const allList = studentRepository.getStudents();
    return allList.sort(fn);
  }

  // return this;

}



export { StudentRepository };



