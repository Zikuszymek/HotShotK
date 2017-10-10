package ziku.app.hotshotk.db.dao

import ziku.app.hotshotk.db.entities.BaseEntity

interface BaseDAO {
    fun getAll() : List<BaseEntity>
    fun getObjectById(id : Int) : BaseEntity?
    fun insertAll(vararg baseEntity: BaseEntity)
    fun delete(baseEntity: BaseEntity)
    fun update(vararg baseEntity: BaseEntity)
}