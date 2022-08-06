const ProductFragments = {
    Elements: {
        H2: {
            Writer: (htmlArray) => {
                htmlArray.push("<h2>작성자</h2>");
            },
            Name: (htmlArray) => {
                htmlArray.push("<h2>상품명</h2>");
            },
            Price: (htmlArray) => {
                htmlArray.push("<h2>상품 가격</h2>");
            },
            Content: (htmlArray) => {
                htmlArray.push("<h2>상품 설명</h2>");
            }
        },
        Span: {
            Writer: (htmlArray) => {
                htmlArray.push("<span id='productWriter'></span>");
            },
            Name: (htmlArray) => {
                htmlArray.push("<span id='productName'></span>");
            },
            Price: (htmlArray) => {
                htmlArray.push("<span id='productPrice'></span>");
            },
            Content: (htmlArray) => {
                htmlArray.push("<span id='productContent'></span>");
            }
        },
        Input: {
            Name: (htmlArray) => {
                htmlArray.push("<input id='productName' placeHolder='상품명을 입력해주세요.'>");
            },
            Price: (htmlArray) => {
                htmlArray.push("<input id='productPrice' placeHolder='상품가격을 입력해주세요.'>");
            },
            Content: (htmlArray) => {
                htmlArray.push("<input id='productContent' placeHolder='상품설명을 입력해주세요.'>");
            }
        },
        Button: {
            Insert: (htmlArray) => {
                htmlArray.push("<button onclick='Products.Data.Insert()'>등록</button>");
            },
            Cancel: (htmlArray) => {
                htmlArray.push("<button onclick='Products.LayerPopUp.Close(this)'>취소</button>");
            },
            Delete: (htmlArray) => {
                //TODO 삭제 기능 추가 예정
                htmlArray.push("<button onclick='Products.LayerPopUp.Close(this)'>삭제</button>");
            }
        },
        Create: {
            Writer: (htmlArray, viewFlag) => {
                if (!viewFlag) {
                    ProductFragments.Elements.H2.Writer(htmlArray);
                    ProductFragments.Elements.Span.Writer(htmlArray);
                }
            },
            Name: (htmlArray, viewFlag) => {
                ProductFragments.Elements.H2.Name(htmlArray);
                if (viewFlag) {
                    ProductFragments.Elements.Input.Name(htmlArray);
                }
                else {
                    ProductFragments.Elements.Span.Name(htmlArray);
                }
            },
            Price: (htmlArray, viewFlag) => {
                ProductFragments.Elements.H2.Price(htmlArray);
                if (viewFlag) {
                    ProductFragments.Elements.Input.Price(htmlArray);
                }
                else {
                    ProductFragments.Elements.Span.Price(htmlArray);
                }
            },
            Content: (htmlArray, viewFlag) => {
                ProductFragments.Elements.H2.Content(htmlArray);
                if (viewFlag) {
                    ProductFragments.Elements.Input.Content(htmlArray);
                }
                else {
                    ProductFragments.Elements.Span.Content(htmlArray);
                }
            },
            Button: (htmlArray, viewFlag) => {
                htmlArray.push("<div>");
                if (viewFlag) {
                    ProductFragments.Elements.Button.Insert(htmlArray);
                    ProductFragments.Elements.Button.Cancel(htmlArray);
                }
                else {
                    ProductFragments.Elements.Button.Delete(htmlArray);
                }
                htmlArray.push("</div>");
            }
        }
    }
};
//# sourceMappingURL=fragments.js.map