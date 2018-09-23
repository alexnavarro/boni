package br.com.alexandrenavarro.booktable.data.source

import br.com.alexandrenavarro.booktable.dao.CustomerDao
import br.com.alexandrenavarro.booktable.data.source.remote.BookTableService
import br.com.alexandrenavarro.booktable.model.Customer
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by alexandrenavarro on 9/23/18.
 */
class BookTableRepository @Inject constructor(val bookTableService: BookTableService,
                                              val customerDao: CustomerDao){


    fun getCustomersFromApi(): Observable<List<Customer>> {
        return bookTableService.getCustomers()
                .doOnNext {
//                    for (item in it) {
//                        cryptocurrenciesDao.insertCryptocurrency(item)
//                    }
                }
    }

}
