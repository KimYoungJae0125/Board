const productWrite = async () => {
    const product = {};
    const productNameElement = document.getElementById("productName");
    //narrowing : type 검사 등을 통해 조건을 좁혀 특정 행동을 할 수 있게 해주는 것
    if (productNameElement instanceof HTMLInputElement) {
        product["prodName"] = String(productNameElement.value);
    }
    if (!checkProdName(product["prodName"])) {
        return false;
    }
    const productPriceElement = document.getElementById("productPrice");
    let productPrice;
    if (productPriceElement instanceof HTMLInputElement) {
        product["prodPrice"] = Number(productPriceElement.value);
    }
    if (!checkProdPrice(product["prodPrice"])) {
        return false;
    }
    const responseData = await Https.Post("/products").Json(product);
    switch (responseData.statusCode) {
        case 200:
            Messages.Https.Success(responseData);
            goProductsList();
            break;
        case 400:
            Messages.Https.Fail(responseData);
            break;
    }
};
const deleteProduct = async (prodId) => {
    const responseData = await Https.Delete("/products/" + prodId);
    switch (responseData.statusCode) {
        case 200:
            Messages.Https.Success(responseData);
            goProductsList();
            break;
        case 400:
            Messages.Https.Fail(responseData);
            break;
    }
};
const goProductsList = () => {
    location.href = "/products";
};
const goProductsWrite = () => {
    location.href = "/products/write";
};
//# sourceMappingURL=products.js.map