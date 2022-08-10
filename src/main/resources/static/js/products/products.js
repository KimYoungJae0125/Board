const Products = {
    Move: {
        List: () => {
            location.href = "/products";
        }
    },
    LayerPopUp: {
        Open: (layerFlag) => {
            const layerPopUpContainer = document.createElement("div");
            layerPopUpContainer.className = "layerPopUp";
            const layerPopUp = [];
            layerPopUp.push("<div>");
            ProductFragments.Elements.Create.Writer(layerPopUp, layerFlag);
            ProductFragments.Elements.Create.Name(layerPopUp, layerFlag);
            ProductFragments.Elements.Create.Price(layerPopUp, layerFlag);
            ProductFragments.Elements.Create.Content(layerPopUp, layerFlag);
            ProductFragments.Elements.Create.Button(layerPopUp, layerFlag);
            layerPopUp.push("</div>");
            document.body.append(layerPopUpContainer);
            layerPopUpContainer.innerHTML = layerPopUp.join('');
        },
        Close: (e) => {
            e.parentNode.parentNode.parentNode.remove();
        }
    },
    Data: {
        Insert: async () => {
            const product = {};
            const productNameElement = document.getElementById("productName");
            //narrowing : type 검사 등을 통해 조건을 좁혀 특정 행동을 할 수 있게 해주는 것
            if (productNameElement instanceof HTMLInputElement) {
                product["productName"] = String(productNameElement.value);
            }
            if (!checkProdName(product["productName"])) {
                return false;
            }
            const productPriceElement = document.getElementById("productPrice");
            if (productPriceElement instanceof HTMLInputElement) {
                product["productPrice"] = Number(productPriceElement.value);
            }
            if (!checkProdPrice(product["productPrice"])) {
                return false;
            }
            const productContentElement = document.getElementById("productContent");
            if (productContentElement instanceof HTMLInputElement) {
                product["productContent"] = String(productContentElement.value);
            }
            //TODO 하드코딩이 아닌 토큰 또는 세션에서 불러오는 값으로 변경 예정
            product["productWriter"] = { userId: 1 };
            const responseData = await Https.Post("/products").Json(product);
            productResponse(responseData, "Post");
        },
        Delete: async (prodId) => {
            const responseData = await Https.Delete("/products/" + prodId);
            productResponse(responseData, "Delete");
        },
        View: async (productId) => {
            const responseData = await Https.Get("/products/" + productId);
            productResponse(responseData, "Get");
        }
    }
};
const productResponse = (responseData, httpMethod) => {
    switch (responseData.statusCode) {
        case 200:
            productsHttp[httpMethod].Success(responseData);
        case 400:
            productsHttp[httpMethod].Fail(responseData);
    }
};
const productsHttp = {
    Get: {
        Success: (responseData) => {
            Messages.Https.Success(responseData);
            Products.LayerPopUp.Open(false);
            const productWriter = document.getElementById("productWriter");
            if (productWriter instanceof HTMLElement) {
                productWriter.innerHTML = responseData.data.writer.name;
            }
            const productName = document.getElementById("productName");
            if (productName instanceof HTMLElement) {
                productName.innerHTML = responseData.data.name;
            }
            const productPrice = document.getElementById("productPrice");
            if (productPrice instanceof HTMLElement) {
                productPrice.innerHTML = responseData.data.price;
            }
            const productContent = document.getElementById("productContent");
            if (productContent instanceof HTMLElement) {
                productContent.innerHTML = responseData.data.content;
            }
        },
        Fail: (responseData) => {
            Messages.Https.Fail(responseData);
        }
    },
    Post: {
        Success: (responseData) => {
            Messages.Https.Success(responseData);
            Products.Move.List();
        },
        Fail: (responseData) => {
            Messages.Https.Fail(responseData);
        }
    },
    Delete: {
        Success: (responseData) => {
            Messages.Https.Success(responseData);
            Products.Move.List();
        },
        Fail: (responseData) => {
            Messages.Https.Fail(responseData);
        }
    }
};
//# sourceMappingURL=products.js.map