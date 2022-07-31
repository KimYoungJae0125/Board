async function productWrite() {

    const prodName = String(document.getElementById("productName").value);

    if(!checkProdName(prodName)) {
        return false;
    }

    const prodPrice = Number(document.getElementById("productPrice").value);

    if(!checkProdPrice(prodPrice)) {
        return false;
    }

    const product = {
          "prodName" : prodName
        , "prodPrice" : prodPrice
    }
    const responseData = await Transfer.Post("/products").Json(product);

    switch(responseData.statusCode) {
        case 200 :
            Messages.Transfer.Success(responseData);
            goProductsList();
        break;
        case 400 :
            Messages.Transfer.Fail(responseData);
        break;
    }
}

function goProductsList() {
    location.href = "/products";
}

function goProductsWrite() {
    location.href = "/products/write";
}