package com.bukalapak.hirv.product

/**
 * Created by janice on 3/21/18.
 */

class DataModel(var product: Array<ProductModel>)

class ProductModel(
        var id: Long = 0,
        var img: String = "",
        var url: String = "",
        var name: String = "",
        var price: Long = 0
)
