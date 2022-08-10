const Messages = {
    Https: {
        Success: ({ transactionTime, statusCode, responseMessage, description, data, errors }) => {
            alert(description);
        },
        Fail: ({ transactionTime, statusCode, responseMessage, description, data, errors }) => {
            let errorMessage = "{ \n";
            for (let i = 0, len = errors.length; i < len; i++) {
                errorMessage += "[ 컬럼명 : " + errors[i].filed
                    + ", 이유 : " + errors[i].reason + "] \n";
            }
            errorMessage += "}";
            alert(description
                + "\n"
                + errorMessage);
        }
    }
};
//# sourceMappingURL=message.js.map