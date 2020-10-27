# Assignment-codition build with springboot and mongodb

this is codition assignment

1. for adding product use post method with following url and json

http://localhost:8081/product

{

    "productName": "phone",
    "price": 12000.0,
    "description": "nice phone",
    "productCategory": {
        "categoryName":"blue",
        "subCategory":{
            "subCategory":[
                "any","red", "cotten"
                ]}

    }

}

2. for updating product use put method with following url and json

http://localhost:8081/product/5f97b9c75925f766303c51dd

    {
    "_id" : "5f97b9c75925f766303c51dd",
    "productName": "mobilePhone",
    "price": 12000.0,
    "description": "nice phone",
    "productCategory": {
        "categoryName":"blue",
        "subCategory":{
            "subCategory":[
                "any","red", "cotten"
                ]}

    }

}

3. for getting all product use get method with following url and json

http://localhost:8081/products/

4. for adding category use post method with following url and json

http://localhost:8081/category

{
"categoryName":"red",
"subCategory":{
"subCategory":[
"any","red", "cotten"
]}
}

5. for getting category with subcategories use get method with following url and json
   http://localhost:8081/category
