package ziku.app.hotshotk.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import ziku.app.hotshotk.db.dao.CategoryDao
import ziku.app.hotshotk.db.dao.HotShotDao
import ziku.app.hotshotk.db.dao.WebPageDao
import ziku.app.hotshotk.db.entities.ProductCategory
import ziku.app.hotshotk.db.entities.HotShot
import ziku.app.hotshotk.db.entities.WebPage

@Database(entities = arrayOf(ProductCategory::class, HotShot::class, WebPage::class), version = 1)
abstract class DatabaseHotShot : RoomDatabase() {
    abstract fun categoryDao() : CategoryDao
    abstract fun webPageDao() : WebPageDao
    abstract fun hotShotDao() : HotShotDao
}