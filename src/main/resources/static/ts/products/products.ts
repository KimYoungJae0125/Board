interface productDataTypes {
    productName? :string;
    productPrice? :number;
    productContent? :string;
    productWriter? :string;
}

const Products = {
     Move : {
         List : () :void => {
            location.href = "/products";
         }
     }
   , LayerPopUp : {
        Open : (layerFlag :boolean) :void => {
                   const layerPopUpContainer :HTMLElement = document.createElement("div");
                   layerPopUpContainer.className = "layerPopUp";

                   const layerPopUp :Array<string> = [];
                   layerPopUp.push("<div>");
                   ProductFragments.Elements.Create.Writer(layerPopUp, layerFlag);
                   ProductFragments.Elements.Create.Name(layerPopUp, layerFlag);
                   ProductFragments.Elements.Create.Price(layerPopUp, layerFlag);
                   ProductFragments.Elements.Create.Content(layerPopUp, layerFlag);
                   ProductFragments.Elements.Create.Button(layerPopUp, layerFlag);
                   layerPopUp.push("</div>");

                   document.body.append(layerPopUpContainer);
                   layerPopUpContainer.innerHTML = layerPopUp.join('');
        }
      , Close : (e) :void => {
            e.parentNode.parentNode.parentNode.remove();
        }
    }
  , Data : {
        Insert : async () :Promise<any> => {
          const product :productDataTypes = {};

          const productNameElement :HTMLElement = document.getElementById("productName");
          //narrowing : type 검사 등을 통해 조건을 좁혀 특정 행동을 할 수 있게 해주는 것
          if(productNameElement instanceof HTMLInputElement ) {
              product["productName"] = String(productNameElement.value);
          }

          if(!checkProdName(product["productName"])) {
              return false;
          }

          const productPriceElement :HTMLElement = document.getElementById("productPrice");
          if(productPriceElement instanceof HTMLInputElement) {
              product["productPrice"] = Number(productPriceElement.value);
          }

          if(!checkProdPrice(product["productPrice"])) {
              return false;
          }
          const productContentElement :HTMLElement = document.getElementById("productContent");
          if(productContentElement instanceof HTMLInputElement) {
              product["productContent"] = String(productContentElement.value);
          }

          product["productWriter"] = "admin";

          const responseData = await Https.Post("/products").Json(product);

          switch(responseData.statusCode) {
              case 200 :
                  Messages.Https.Success(responseData);
                  Products.Move.List();
              break;
              case 400 :
                  Messages.Https.Fail(responseData);
              break;
          }
        }
      , Delete : async (prodId :number) :Promise<any> => {
          const responseData = await Https.Delete("/products/" + prodId);

          switch(responseData.statusCode) {
              case 200 :
                  Messages.Https.Success(responseData);
                  Products.Move.List();
              break;
              case 400 :
                  Messages.Https.Fail(responseData);
              break;
          }
        }
      , View : async (productId) => {
           const responseData = await Https.Get("/products/"+productId);

           switch(responseData.statusCode) {
               case 200 :
                   Messages.Https.Success(responseData);
                   Products.LayerPopUp.Open(false);
                   const productWriter = document.getElementById("productWriter");
                   if(productWriter instanceof HTMLElement) {
                       productWriter.innerHTML = responseData.data.writer;
                   }
                   const productName = document.getElementById("productName");
                   if(productName instanceof HTMLElement) {
                       productName.innerHTML = responseData.data.name;
                   }
                   const productPrice = document.getElementById("productPrice");
                   if(productPrice instanceof HTMLElement) {
                       productPrice.innerHTML = responseData.data.price;
                   }
                   const productContent = document.getElementById("productContent");
                   if(productContent instanceof HTMLElement) {
                       productContent.innerHTML = responseData.data.content;
                   }
               break;
               case 400 :
                   Messages.Https.Fail(responseData);
               break;
           }
       }
    }
}