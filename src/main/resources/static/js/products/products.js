function productWrite() {

    const product = {
          "prodName" : String(document.getElementById("productName").value)
        , "prodPrice" : Number(document.getElementById("productPrice").value)
    }

    Transfer.jsonRequest("/products", "post", product);
}

function goProductsList() {
    location.href = "/products";
}

function goProductsWrite() {
    location.href = "/products/write";
}