package ziku.app.hotshotk.db.dao

import android.arch.persistence.room.*
import ziku.app.hotshotk.db.entities.ProductCategory
import ziku.app.hotshotk.db.entities.WebPage

@Dao
interface WebPageDao{

    @Query("SELECT * FROM webpage")
    fun getAll() : List<WebPage>

    @Query("SELECT * FROM webpage WHERE id_web_page = :id LIMIT 1")
    fun getObjectById(id : Int) : WebPage?

    @Insert
    fun insertAll(vararg webPage: WebPage)

    @Delete
    fun delete(webpage: WebPage)

    @Update
    fun update(vararg webpage: WebPage)
}