package br.com.alexandrenavarro.booktable.data.source.remote

import br.com.alexandrenavarro.booktable.model.Customer
import br.com.alexandrenavarro.booktable.model.Table
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by alexandrenavarro on 9/23/18.
 */
interface BookTableService {

    @GET("customer-list.json")
    fun getCustomers(): Observable<List<Customer>>

    @GET("table-map.json")
    fun getTables(): Observable<List<Table>>
}