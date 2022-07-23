const Transfer = {
        ajax: function(requestUrl, httpMethod, contentType, requestData){
            const xhr = new XMLHttpRequest();

            xhr.open(httpMethod, requestUrl);

            if(contentType != null && contentType != ""){
                xhr.setRequestHeader("Content-Type", contentType);
            }

            xhr.onreadystatechange = function () {
                if(xhr.readyState === XMLHttpRequest.DONE) {
                    if(xhr.status === 200 || xhr.status === 201) {
                    }
                }
            }

            xhr.send(requestData);
        }
      , jsonRequest: function(requestUrl, httpMethod, jsonData) {
            Transfer.ajax(requestUrl, httpMethod, "application/json", jsonData);
        }
      , multipartRequest: function(requestUrl, httpMethod, fileData) {
            const formData = new FormData();
            formData.append("file", fileData);
            formData.method="post";
            formData.enctype = "multipart/form-data";

            Transfer.ajax(requestUrl, "POST", "", formData);

        }
}