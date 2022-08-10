//type과 interface 의 용도는 비슷하다.

type httpMethod = {
        Get :Function;
        Post :Function;
        Put :Function;
        Patch :Function;
        Delete :Function;
    }

interface response {
    transactionTime :Date;
    statusCode :number;
    responseMessage :string;
    description :string;
    data :any;
    errors :Array<any>;
}

const Https :httpMethod = {
      Get : (requestUrl :string) :Promise<response> => {
          const option = {method : "GET"}

          return fetch(requestUrl, option).then(response => response.json());
      }
    , Post(requestUrl :string) :Function {
        const option = {method : "POST"}

        this.Json = (requestData :object) :Promise<response> => {
            option["headers"] = {"Content-Type" : "application/json"}
            option["body"] = JSON.stringify(requestData);

            return fetch(requestUrl, option).then(response => response.json());
        }

        return this;    //화살표 함수의 this는 window(현재 변수 상위 스코프) 객체를 가리킨다. 현재 객체를 this 키워드로 반환하고 싶으면 화살표 함수가 아닌 일반 함수를 사용한다.
      }
    , Put : () :void => {
      }
    , Patch : () :void => {
      }
    , Delete : (requestUrl :string) :Promise<response> => {
        const option = {method : "DELETE"}

        return fetch(requestUrl, option).then(response => response.json());
      }
}