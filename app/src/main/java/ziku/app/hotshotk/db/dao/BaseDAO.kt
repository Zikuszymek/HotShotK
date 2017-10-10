package ziku.app.hotshotk.db.dao

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Update
import ziku.app.hotshotk.db.entities.BaseEntity

interface BaseDAO {
    fun getAll() : List<BaseEntity>
    fun getObjectById(id : Int) : BaseEntity?

    @Insert
    fun insertAll(vararg baseEntity: BaseEntity)

    @Delete
    fun delete(baseEntity: BaseEntity)

    @Update
    fun update(vararg baseEntity: BaseEntity)
}