package ziku.app.hotshotk.db.dao

import android.arch.persistence.room.*
import ziku.app.hotshotk.db.entities.WebPage

@Dao
interface WebPageDao : BaseDAO<WebPage>{

    @Query("SELECT * FROM webpage")
    override fun getAll() : List<WebPage>

    @Query("SELECT * FROM webpage WHERE id_web_page = :id LIMIT 1")
    override fun getObjectById(id : Int) : WebPage?

    @Insert
    override fun insertOne(baseEntity: WebPage)

    @Insert
    override fun insertAll(vararg webPage: WebPage)

    @Delete
    override fun delete(webpage: WebPage)

    @Update
    override fun updateAll(vararg webpage: WebPage)

    @Update
    override fun updateOne(webpage: WebPage)
}