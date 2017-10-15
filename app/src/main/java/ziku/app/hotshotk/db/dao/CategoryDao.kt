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
    override fun insertAll(vararg baseEntity: ProductCategory)

    @Delete
    override fun delete(baseEntity: ProductCategory)

    @Update
    override fun updateAll(vararg baseEntity: ProductCategory)

    @Update
    override fun updateOne(baseEntity: ProductCategory)

}