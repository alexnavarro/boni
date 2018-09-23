package br.com.alexandrenavarro.booktable.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.squareup.moshi.Json
import java.io.Serializable

/**
 * Created by alexandrenavarro on 9/22/18.
 */

@Entity(tableName = "customer")
data class Customer(

    @Json(name = "id")
    @PrimaryKey
    val id: Int,

    @Json(name = "customerFirstName")
    val firstName: String? = null,

    @Json(name = "customerLastName")
    val lastName: String? = null

    ) : Serializable