function productWrite() {

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

    Transfer.jsonRequest("/products", "post", product);
}

function goProductsList() {
    location.href = "/products";
}

function goProductsWrite() {
    location.href = "/products/write";
}