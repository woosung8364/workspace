class Validator {
  /**
   * 문자열 입력 여부
   * @param {string} 입력 문자열 
   * @returns 문자열 입력 여부
   */
  static hasText(value) {
    if (value === undefined || value.length === 0) {
      return false;
    } 
    return true;
  }
  
  /**
   * 아이디 사용 가능 여부
   * @param {string} 입력 아이디 
   * @returns 아이디 사용 가능 여부
   */
  static isId(value) {
	const exp = /^[a-zA-Z][0-9a-zA-Z]{5,11}$/g;
	return exp.test(value);
}

  /**
   * 숫자 입력 여부
   * @param {string} 입력 문자열 
   * @returns 숫자 여부
   */
  static isNumber(value) {
    let RegExp = /^[0-9]*$/;
    if (!RegExp.test(value)) {
      return false;
    } 
    return true;
  }

  /**
   * 이름 입력 여부
   * @param {string} 입력 문자열 
   * @returns 이름 입력 여부
   */
  static isName(value) {
    let RegExp =  /^[가-힣]+$/;
    if (!RegExp.test(value)) {
      return false;
    } else if (value.length < 2 || value.length > 10) {
      return false;
    }
    return true;
  }

  /**
   * 숫자 입력 여부
   * @param {number} value 
   * @returns 숫자 입력 여부
   */
  static isScore(value) {
    let RegExp = /^[0-9]*$/;
    if (!RegExp.test(value)) {
      return false;
    } else if (value < 0 || value > 100) {
      return false;
    }
    return true;
  }
}
