package com.bukalapak.hirv.coffee

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bukalapak.hirv.R
import kotlinx.android.synthetic.main.item_coffee.view.*

/**
 * Created by janice on 3/9/18.
 */

class CoffeeAdapter(private val coffeeModel: ArrayList<CoffeeModel>?) : RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CoffeeViewHolder {
        return CoffeeViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_coffee, parent, false))
    }

    override fun getItemCount(): Int {
        return coffeeModel?.size ?: 0
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder?, position: Int) {
        holder?.bind(coffeeModel?.get(position) ?: CoffeeModel())
    }

    class CoffeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(coffeeModel: CoffeeModel) {
            itemView.tvCoffee.text = coffeeModel.coffeeName
            itemView.ivCoffee.setImageResource(coffeeModel.coffeeImageResource)
        }
    }
}
