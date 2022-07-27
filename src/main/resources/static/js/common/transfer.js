const Transfer = {
        ajax: function(requestUrl, httpMethod, contentType, requestData){

            fetch(requestUrl, {
                  method: httpMethod
                , headers: {
                    "Content-Type" : contentType
                  }
                , body : requestData
            })
            .then((response) => response.json())
            .then((data) => console.log(data))
            .catch((error) => console.log("error : "+ error));

        }
      , jsonRequest: function(requestUrl, httpMethod, jsonData) {
            Transfer.ajax(requestUrl, httpMethod, "application/json", JSON.stringify(jsonData));
        }
      , multipartRequest: function(requestUrl, httpMethod, fileData) {
            const formData = new FormData();
            formData.append("file", fileData);
            formData.method="post";
            formData.enctype = "multipart/form-data";

            Transfer.ajax(requestUrl, "POST", "", formData);

        }
}