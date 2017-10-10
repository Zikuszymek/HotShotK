package ziku.app.hotshotk.db.dao

import android.arch.persistence.room.*
import ziku.app.hotshotk.db.entities.ProductCategory

@Dao
interface CategoryDao{

    @Query("SELECT * FROM productcategory")
    fun getAll() : List<ProductCategory>

    @Query("SELECT * FROM productcategory WHERE idweb_page_category = :id LIMIT 1")
    fun getObjectById(id : Int) : ProductCategory?

    @Insert()
    fun insertAll(vararg productCategory: ProductCategory)

    @Delete
    fun delete(productCategory: ProductCategory)

    @Update
    fun update(vararg productCategory: ProductCategory)

}