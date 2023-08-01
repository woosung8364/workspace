/**
 * 유효성 검증 클래스
 */

class Validator{
  constructor(){}

  static isNumber(value) {
    return /\d/.test(value); 
  }

  static isString(value) {
    return typeof value === 'string';
  }


  // 문자가 맞는지 검증 & 입력 여부를 검증하는 함수
  static hasText(value){
    if(value === undefined || Validator.isNumber(value) || value.length === 0  ){
      return false;
    }
    return true;
  }
  
  // 숫자 여부나 입력 여부를 검증하는 함수
  static hasNumber(value){
    if (isNaN(value) || Validator.isString(value) || value.length === 0  ) {
      return false;
    }
    return true;
  }

}

export{Validator};