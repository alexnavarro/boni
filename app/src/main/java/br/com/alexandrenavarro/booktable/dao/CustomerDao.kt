package br.com.alexandrenavarro.booktable.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import br.com.alexandrenavarro.booktable.model.Customer

/**
 * Created by alexandrenavarro on 9/22/18.
 */

@Dao
interface CustomerDao {

    @Query("SELECT * FROM customer")
    fun queryCustomer(): LiveData<List<Customer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCustomer(customer: Customer)
}