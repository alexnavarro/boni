package br.com.alexandrenavarro.booktable.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import br.com.alexandrenavarro.booktable.model.Table

/**
 * Created by alexandrenavarro on 9/22/18.
 */

@Dao
interface TableDao {

    @Query("SELECT * FROM tables")
    fun queryTable(): LiveData<List<Table>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTable(table: Table)
}