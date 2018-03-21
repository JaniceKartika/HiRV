package com.bukalapak.hirv

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bukalapak.hirv.product.DataModel
import com.bukalapak.hirv.product.ProductAPIInterface
import com.bukalapak.hirv.product.ProductModel
import kotlinx.android.synthetic.main.activity_product.*
import retrofit2.Call
import retrofit2.Response

/**
 * Created by janice on 3/21/18.
 */

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        btSearchProduct.setOnClickListener {
            callProduct()
        }
    }

    private fun callProduct() {
        loading.visibility = View.VISIBLE

        ProductAPIInterface.create().getData(
                getString(R.string.user_id),
                getString(R.string.key),
                etSearchProduct.text.toString()).enqueue(object : retrofit2.Callback<DataModel> {

            override fun onResponse(call: Call<DataModel>?, response: Response<DataModel>?) {
                loading.visibility = View.INVISIBLE

                val products: Array<ProductModel> = response?.body()?.product ?: arrayOf(ProductModel())
                var result = ""

                products.map {
                    result += it.name + "\n\n"
                }

                tvResult.text = result
            }

            override fun onFailure(call: Call<DataModel>?, t: Throwable?) {
                loading.visibility = View.INVISIBLE
                tvResult.text = getString(R.string.call_failed)
            }
        })
    }
}
