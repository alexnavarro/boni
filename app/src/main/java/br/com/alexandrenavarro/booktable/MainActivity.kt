package br.com.alexandrenavarro.booktable

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.alexandrenavarro.booktable.model.Customer
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var customerViewModelFactory: CustomerViewModelFactory
    lateinit var customerViewModel: CustomerViewModel

    private var customers:MutableList<Customer> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        recycler_view.adapter = CustomerAdapter(customers)

        customerViewModel = ViewModelProviders.of(this, customerViewModelFactory).get(
                CustomerViewModel::class.java)

        customerViewModel.loadCustomers()

        customerViewModel.getCustomer().observe(this,
                Observer<List<Customer>> {
                    it?.let{
                        customers.addAll(it)
                        (recycler_view.adapter as CustomerAdapter).notifyDataSetChanged()
                    }
                })
    }

    override fun onDestroy() {
        customerViewModel.disposeElements()
        super.onDestroy()
    }
}
