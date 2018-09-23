package br.com.alexandrenavarro.booktable

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.alexandrenavarro.booktable.model.Customer
import kotlinx.android.synthetic.main.customer_item.view.*

/**
 * Created by alexandrenavarro on 9/23/18.
 */
class CustomerAdapter(private val customerDataSet: List<Customer>): RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.customer_item, parent, false)
        return CustomerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return customerDataSet.size
    }

    override fun onBindViewHolder(customerViewHolder: CustomerViewHolder, position: Int) {
        customerViewHolder.texName.text = "${customerDataSet[position].firstName} ${customerDataSet[position].lastName}"
    }

    class CustomerViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val texName: TextView = view.name
    }
}