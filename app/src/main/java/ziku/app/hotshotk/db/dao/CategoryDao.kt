package ziku.app.hotshotk.db.dao

import android.arch.persistence.room.*
import ziku.app.hotshotk.db.entities.ProductCategory

@Dao
interface CategoryDao : BaseDAO<ProductCategory>{

    @Query("SELECT * FROM productcategory")
    override fun getAll() : List<ProductCategory>

    @Query("SELECT * FROM productcategory WHERE idweb_page_category = :id LIMIT 1")
    override fun getObjectById(id : Int) : ProductCategory?

    @Insert
    override fun insertOne(baseEntity: ProductCategory)

    @Insert()
    override fun insertAll(vararg productCategory: ProductCategory)

    @Delete
    override fun delete(productCategory: ProductCategory)

    @Update
    override fun updateAll(vararg productCategory: ProductCategory)

    @Update
    override fun updateOne(productCategory: ProductCategory)

}