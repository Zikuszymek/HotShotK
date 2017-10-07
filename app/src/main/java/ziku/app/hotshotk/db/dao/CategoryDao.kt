package ziku.app.hotshotk.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import ziku.app.hotshotk.db.entities.ProductCategory

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category")
    fun getAll() : List<ProductCategory>

    @Insert
    fun insertAll(vararg productCategory: ProductCategory)

    @Delete
    fun delete(productCategory: ProductCategory)
}