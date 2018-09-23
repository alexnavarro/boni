package br.com.alexandrenavarro.booktable

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.alexandrenavarro.booktable.data.source.BookTableRepository
import br.com.alexandrenavarro.booktable.model.Customer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import java.util.concurrent.TimeUnit.MILLISECONDS

/**
 * Created by alexandrenavarro on 9/23/18.
 */
class CustomerViewModel @Inject constructor(
        private val bookTableRepository: BookTableRepository) : ViewModel(){

    private var customerResult: MutableLiveData<List<Customer>> = MutableLiveData()

    lateinit var disposableObserver: DisposableObserver<List<Customer>>


    fun getCustomer(): LiveData<List<Customer>> {
        return customerResult
    }

    fun loadCustomers() {

        disposableObserver = object : DisposableObserver<List<Customer>>() {
            override fun onComplete() {

            }

            override fun onNext(cryptocurrencies: List<Customer>) {
                customerResult.postValue(cryptocurrencies)
            }

            override fun onError(e: Throwable) {
//                cryptocurrenciesError.postValue(e.message)
            }
        }

        bookTableRepository.getCustomersFromApi()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .debounce(400, MILLISECONDS)
                .subscribe(disposableObserver)
    }

    fun disposeElements(){
        if(null != disposableObserver && !disposableObserver.isDisposed) disposableObserver.dispose()
    }

}