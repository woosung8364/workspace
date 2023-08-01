class Validator {
  /**
   * 
   * @param {string} 문자열값 
   * @returns ~~~
   */
  static hasText(value){
    if(value == undefined || value.length === 0){
      return false;
    }
    return true;
  }
}

export { Validator }