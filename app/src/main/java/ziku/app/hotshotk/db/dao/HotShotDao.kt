package ziku.app.hotshotk.db.dao

import android.arch.persistence.room.*
import ziku.app.hotshotk.db.entities.HotShot

@Dao
interface HotShotDao{

    @Query("SELECT * FROM hotshot")
    fun getAll() : List<HotShot>

    @Query("SELECT * FROM hotshot WHERE id_hot_shot = :id LIMIT 1")
    fun getObjectById(id : Int) : HotShot?

    @Insert
    fun insertAll(vararg hotShot: HotShot)

    @Delete
    fun delete(hotShot: HotShot)

    @Update
    fun update(vararg hotShot: HotShot)

}