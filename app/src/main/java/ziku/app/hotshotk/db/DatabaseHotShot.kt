package ziku.app.hotshotk.db

import android.arch.persistence.room.Database
import ziku.app.hotshotk.db.dao.CategoryDao
import ziku.app.hotshotk.db.dao.HotShotDao
import ziku.app.hotshotk.db.dao.WebPageDao
import ziku.app.hotshotk.db.entities.Category
import ziku.app.hotshotk.db.entities.HotShot
import ziku.app.hotshotk.db.entities.WebPage

@Database(entities = arrayOf(Category::class, HotShot::class, WebPage::class), version = 1)
abstract class DatabaseHotShot {
    public abstract fun categoryDao() : CategoryDao
    public abstract fun webPageDao() : WebPageDao
    public abstract fun hotShotDao() : HotShotDao
}