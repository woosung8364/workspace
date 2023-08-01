
import { StudentRepository } from "./student-repository.js";
import {Validator} from "./validator.js";
import {studentRepository} from "./app.js";
import { Student } from "./Student.js";

//  이벤트 처리를 객체화
class EventHandler {
  
  constructor(){}

  // 이벤트 소스에 이벤트핸들러 등록
  eventRegist(){
    document.querySelector("#addBtn").addEventListener('click', event => {
      this.addStudent(event);
    });
    
  }

  // 학생 등록
  addStudent(event){
    const ssn = document.inputForm.ssn.value;
    const name ="김기정";
    const korea = 90;
    const english = 100;
    const math = 100;

    if(!Validator.hasText(ssn)){
      alert('학번을 입력하여 주세요.');
    }

    const student = new Student(ssn, name, korea, english, math);
    studentRepository.addStudent(student);
    alert('학생 등록 완료!');  
    const  allList = studentRepository.getStudents();  
    console.dir(allList);
    
  }

  // 학생 목록
  findAllStudent(event){

  }
}

export { EventHandler }