const Messages = {
    Https: {
        Success: (responseData) => {
            alert(responseData.description);
        },
        Fail: (responseData) => {
            const errors = responseData.errors;
            let errorMessage = "{ \n";
            for (let i = 0, len = errors.length; i < len; i++) {
                errorMessage += "[ 컬럼명 : " + errors[i].filed
                    + ", 이유 : " + errors[i].reason + "] \n";
            }
            errorMessage += "}";
            alert(responseData.description
                + "\n"
                + errorMessage);
        }
    }
};
//# sourceMappingURL=message.js.map