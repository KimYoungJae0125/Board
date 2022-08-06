interface productsType {
    Elements : elementsType;
}

interface elementsType {
    H2 : allElementsTypes;
    Span : allElementsTypes;
    Input : defaultElementsTypes;
    Button : buttonElementsTypes;
    Create : createElementsTypes;
}

//상품명, 상품가격, 상품내용
interface defaultElementsTypes {
    Name : Function;
    Price : Function;
    Content : Function;
}

//작성자 + defaultElementsTypes(상품명, 상품가격, 상품내용)
interface allElementsTypes extends defaultElementsTypes {
    Writer : Function;
}

//버튼 관련 타입들
interface buttonElementsTypes {
    Insert : Function;
    Cancel : Function;
    Delete : Function;
}

interface createElementsTypes extends allElementsTypes {
    Button : Function;
}




const ProductFragments :productsType = {
    Elements : {
        H2 : {
                Writer : (htmlArray :Array<string>) :void => {
                    htmlArray.push("<h2>작성자</h2>");
                }
              , Name : (htmlArray :Array<string>) :void => {
                    htmlArray.push("<h2>상품명</h2>");
                }
              , Price : (htmlArray :Array<string>) :void => {
                    htmlArray.push("<h2>상품 가격</h2>");
                }
              , Content : (htmlArray :Array<string>) :void => {
                    htmlArray.push("<h2>상품 설명</h2>");
                }
              }
          , Span : {
                Writer : (htmlArray :Array<string>) :void => {
                    htmlArray.push("<span id='productWriter'></span>");
                }
              , Name : (htmlArray :Array<string>) :void => {
                    htmlArray.push("<span id='productName'></span>");
                }
              , Price : (htmlArray :Array<string>) :void => {
                    htmlArray.push("<span id='productPrice'></span>");
                }
              , Content : (htmlArray :Array<string>) :void => {
                    htmlArray.push("<span id='productContent'></span>");
                }
              }
          , Input : {
                 Name : (htmlArray :Array<string>) :void => {
                    htmlArray.push("<input id='productName' placeHolder='상품명을 입력해주세요.'>");
                 }
               , Price : (htmlArray :Array<string>) :void => {
                    htmlArray.push("<input id='productPrice' placeHolder='상품가격을 입력해주세요.'>");
                  }
               , Content : (htmlArray :Array<string>) :void => {
                    htmlArray.push("<input id='productContent' placeHolder='상품설명을 입력해주세요.'>");
                  }
              }
          , Button : {
                 Insert : (htmlArray :Array<string>) :void => {
                    htmlArray.push("<button onclick='Products.Data.Insert()'>등록</button>");
                 }
               , Cancel : (htmlArray :Array<string>) :void => {
                    htmlArray.push("<button onclick='Products.LayerPopUp.Close(this)'>취소</button>");
                  }
               , Delete : (htmlArray :Array<string>) :void => {
                    //TODO 삭제 기능 추가 예정
                    htmlArray.push("<button onclick='Products.LayerPopUp.Close(this)'>삭제</button>");
                  }
              }
          , Create : {
              Writer : (htmlArray :Array<string>, viewFlag :boolean) :void => {
                      if(!viewFlag) {
                          ProductFragments.Elements.H2.Writer(htmlArray);
                          ProductFragments.Elements.Span.Writer(htmlArray);
                      }
                  }
                , Name : (htmlArray :Array<string>, viewFlag :boolean) :void => {
                      ProductFragments.Elements.H2.Name(htmlArray);
                      if(viewFlag) {
                          ProductFragments.Elements.Input.Name(htmlArray);
                      } else {
                          ProductFragments.Elements.Span.Name(htmlArray);
                      }
                  }
                , Price : (htmlArray :Array<string>, viewFlag :boolean) :void => {
                      ProductFragments.Elements.H2.Price(htmlArray);
                      if(viewFlag) {
                          ProductFragments.Elements.Input.Price(htmlArray);
                      } else {
                          ProductFragments.Elements.Span.Price(htmlArray);
                      }
                  }
                , Content : (htmlArray :Array<string>, viewFlag :boolean) :void => {
                      ProductFragments.Elements.H2.Content(htmlArray);
                      if(viewFlag) {
                          ProductFragments.Elements.Input.Content(htmlArray);
                      } else {
                          ProductFragments.Elements.Span.Content(htmlArray);
                      }
                  }
                , Button : (htmlArray :Array<string>, viewFlag :boolean) :void => {
                      htmlArray.push("<div>");
                      if(viewFlag) {
                          ProductFragments.Elements.Button.Insert(htmlArray);
                          ProductFragments.Elements.Button.Cancel(htmlArray);
                      } else {
                          ProductFragments.Elements.Button.Delete(htmlArray);
                      }
                      htmlArray.push("</div>");
                  }
            }

    }
};