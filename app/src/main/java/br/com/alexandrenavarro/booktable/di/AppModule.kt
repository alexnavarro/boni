package br.com.alexandrenavarro.booktable.di

import android.app.Application
import android.arch.persistence.room.Room
import br.com.alexandrenavarro.booktable.dao.CustomerDao
import br.com.alexandrenavarro.booktable.dao.Database
import br.com.alexandrenavarro.booktable.dao.TableDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by alexandrenavarro on 9/22/18.
 */

@Module
class AppModule (val app: Application){

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideBookTableDatabase(app: Application): Database = Room.databaseBuilder(app,
            Database::class.java, "book_table_db").build()

    @Provides
    @Singleton
    fun provideCustomerDao(database: Database): CustomerDao = database.customerDao()

    @Provides
    @Singleton
    fun provideBookTableDao(database: Database): TableDao = database.tableDao()
}