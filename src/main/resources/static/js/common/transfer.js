const Transfer = {
      Get : function() {

      }
    , Post : function(requestUrl) {
        const option = {method : "POST"}

        this.Json = function(requestData) {
            option["headers"] = {"Content-Type" : "application/json"}
            option["body"] = JSON.stringify(requestData);

            return fetch(requestUrl, option).then(response => response.json());
        }

        return this;
      }
    , Put : function() {
      }
    , Patch : function() {
      }
    , Delete : function() {
      }
}