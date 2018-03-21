package com.bukalapak.hirv

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import com.bukalapak.hirv.coffee.CoffeeAdapter
import com.bukalapak.hirv.coffee.CoffeeModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCoffee()
    }

    private fun initCoffee() {
        val layoutManager = GridLayoutManager(this, 2)
        rvCoffee.layoutManager = layoutManager
        rvCoffee.itemAnimator = DefaultItemAnimator()

        val adapter = CoffeeAdapter(populateCoffee())
        rvCoffee.adapter = adapter
    }

    private fun populateCoffee(): ArrayList<CoffeeModel> {
        val items: ArrayList<CoffeeModel> = ArrayList()

        val coffeeImages = intArrayOf(
                R.drawable.kopi_kucing,
                R.drawable.kopi_starbucks,
                R.drawable.kopi_dingin,
                R.drawable.kopi_warung
        )
        val coffeeNames = resources.getStringArray(R.array.coffees)

        coffeeImages.mapIndexed { index, i ->
            items.add(CoffeeModel(i, coffeeNames.getOrNull(index) ?: ""))
        }
        return items
    }
}
