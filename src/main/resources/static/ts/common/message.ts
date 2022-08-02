const Messages = {
    Https : {
        Success : (responseData :any) :void => {
            alert(responseData.description);
        }
      , Fail : (responseData :any) :void => {
           const errors = responseData.errors;
           let errorMessage :string = "{ \n";
           for(let i=0, len = errors.length; i<len; i++) {
               errorMessage += "[ 컬럼명 : " + errors[i].filed
                             + ", 이유 : " + errors[i].reason + "] \n";
           }
           errorMessage += "}";
           alert(responseData.description
               + "\n"
               + errorMessage);
        }
    }
}