package ziku.app.hotshotk.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import ziku.app.hotshotk.db.entities.Category

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category")
    fun getAll() : List<Category>

    @Insert
    fun insertAll(vararg category : Category)

    @Delete
    fun delete(category : Category)
}