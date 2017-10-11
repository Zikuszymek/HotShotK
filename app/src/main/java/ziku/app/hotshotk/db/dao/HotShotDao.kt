package ziku.app.hotshotk.db.dao

import android.arch.persistence.room.*
import ziku.app.hotshotk.db.entities.HotShot

@Dao
interface HotShotDao : BaseDAO<HotShot>{

    @Query("SELECT * FROM hotshot")
    override fun getAll() : List<HotShot>

    @Query("SELECT * FROM hotshot WHERE id_hot_shot = :id LIMIT 1")
    override fun getObjectById(id : Int) : HotShot?

    @Query("SELECT * FROM hotshot " +
            "INNER JOIN webpage ON webpage.id_web_page = hotshot.web_page" +
            " WHERE webpage.web_page_category = :categoryId")
    fun getObjectByCategory(categoryId : Int) : List<HotShot>

    @Insert
    override fun insertAll(vararg hotShot: HotShot)

    @Insert
    override fun insertOne(baseEntity: HotShot)

    @Delete
    override fun delete(hotShot: HotShot)

    @Update
    override fun updateAll(vararg hotShot: HotShot)

    @Update
    override fun updateOne(hotShot: HotShot)

}