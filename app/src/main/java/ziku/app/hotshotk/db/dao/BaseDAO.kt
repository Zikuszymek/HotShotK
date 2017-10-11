package ziku.app.hotshotk.db.dao

import ziku.app.hotshotk.db.entities.BaseEntity

interface BaseDAO<T> where T : BaseEntity{
    fun getAll() : List<T>
    fun getObjectById(id : Int) : T?
    fun insertAll(vararg baseEntity: T)
    fun insertOne(baseEntity: T)
    fun delete(baseEntity: T)
    fun updateAll(vararg baseEntity: T)
    fun updateOne(baseEntity: T)
}