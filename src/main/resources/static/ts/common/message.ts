interface response {
    transactionTime :Date;
    statusCode :number;
    responseMessage :string;
    description :string;
    data :any;
    errors :Array<any>;
}


const Messages = {
    Https : {
        Success : ({transactionTime, statusCode, responseMessage, description, data, errors} :response) :void => {
            alert(description);
        }
      , Fail : ({transactionTime, statusCode, responseMessage, description, data, errors} :response) :void => {
           let errorMessage :string = "{ \n";
           for(let i=0, len = errors.length; i<len; i++) {
               errorMessage += "[ 컬럼명 : " + errors[i].filed
                             + ", 이유 : " + errors[i].reason + "] \n";
           }
           errorMessage += "}";
           alert(description
               + "\n"
               + errorMessage);
        }
    }
}