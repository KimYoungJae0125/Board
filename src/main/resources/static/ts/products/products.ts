type product = {
    prodName? :string;
    prodPrice? :number;
}

const productWrite = async () :Promise<any> =>  {

    const product :product = {};

    const productNameElement :HTMLElement = document.getElementById("productName");
    //narrowing : type 검사 등을 통해 조건을 좁혀 특정 행동을 할 수 있게 해주는 것
    if(productNameElement instanceof HTMLInputElement ) {
        product["prodName"] = String(productNameElement.value);
    }

    if(!checkProdName(product["prodName"])) {
        return false;
    }

    const productPriceElement :HTMLElement = document.getElementById("productPrice");
    let productPrice :number;
    if(productPriceElement instanceof HTMLInputElement) {
        product["prodPrice"] = Number(productPriceElement.value);
    }

    if(!checkProdPrice(product["prodPrice"])) {
        return false;
    }

    const responseData = await Https.Post("/products").Json(product);

    switch(responseData.statusCode) {
        case 200 :
            Messages.Https.Success(responseData);
            goProductsList();
        break;
        case 400 :
            Messages.Https.Fail(responseData);
        break;
    }
}

const deleteProduct = async (prodId :number) :Promise<any> => {
    const responseData = await Https.Delete("/products/" + prodId);

    switch(responseData.statusCode) {
        case 200 :
            Messages.Https.Success(responseData);
            goProductsList();
        break;
        case 400 :
            Messages.Https.Fail(responseData);
        break;
    }
}

const goProductsList = () :void => {
    location.href = "/products";
}

const goProductsWrite = () :void => {
    location.href = "/products/write";
}