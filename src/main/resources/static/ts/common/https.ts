type httpMethod = {
        Get :Function;
        Post :Function;
        Put :Function;
        Patch :Function;
        Delete :Function;
    }
const Https :httpMethod = {
      Get : () :void => {

      }
    , Post : function(requestUrl :string) :Function {
        const option = {method : "POST"}

        this.Json = (requestData :object) :Promise<any> => {
            option["headers"] = {"Content-Type" : "application/json"}
            option["body"] = JSON.stringify(requestData);

            return fetch(requestUrl, option).then(response => response.json());
        }

        return this;    //화살표 함수의 this는 window 객체를 가리킨다. 현재 객체를 this 키워드로 반환하고 싶으면 화살표 함수가 아닌 일반 함수를 사용한다.
      }
    , Put : () :void => {
      }
    , Patch : () :void => {
      }
    , Delete : (requestUrl :string) :Promise<any> => {
        const option = {method : "DELETE"}

        return fetch(requestUrl, option).then(response => response.json());
      }
}