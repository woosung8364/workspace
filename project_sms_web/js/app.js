import { Student } from "./Student.js";
import { StudentRepository } from "./student-repository.js";
import { EventHandler } from "./event-handler.js";
import { Validator } from "./validator.js";

let studentRepository = new StudentRepository();
// 테스트를 위한 더미데이터 입력
// console.log(studentRepository.getStudents());
studentRepository.addStudent(new Student(4,'나',100,100,100,1)); //300
studentRepository.addStudent(new Student(5,'바',70,100,90,3)); // 260
studentRepository.addStudent(new Student(1,'다',35,45,50,5)); //130
studentRepository.addStudent(new Student(3,'라',45,45,50,4)); //140
studentRepository.addStudent(new Student(6,'가',90,90,100,2)); 
studentRepository.addStudent(new Student(2,'마',0,0,50,6)); 

let eventHandler = new EventHandler();
eventHandler.eventRegist();
// eventHandler.addStudent();
// eventHandler.findAllStudent();
// eventHandler.selectSolt();
// eventHandler.calcRank();

console.log(eventHandler.calcRank());

let student = new Student();
// console.log(studentRepository.students.name);
export{studentRepository};