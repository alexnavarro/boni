package br.com.alexandrenavarro.booktable.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.alexandrenavarro.booktable.model.Customer
import br.com.alexandrenavarro.booktable.model.Table

/**
 * Created by alexandrenavarro on 9/22/18.
 */

@Database(entities = [Customer::class, Table::class], version = 1)
abstract class Database : RoomDatabase(){

    abstract fun customerDao(): CustomerDao

    abstract fun tableDao(): TableDao
}