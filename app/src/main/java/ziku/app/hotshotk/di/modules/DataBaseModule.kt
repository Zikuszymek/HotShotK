package ziku.app.hotshotk.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import ziku.app.hotshotk.db.DatabaseHotShot
import ziku.app.hotshotk.db.dao.CategoryDao
import ziku.app.hotshotk.db.dao.HotShotDao
import ziku.app.hotshotk.db.dao.WebPageDao
import javax.inject.Singleton

@Module(includes = arrayOf(AppModule::class))
class DataBaseModule {

    @Singleton
    @Provides
    fun provideDatabaseHotShot(context: Context) : DatabaseHotShot{
        return Room.databaseBuilder(context, DatabaseHotShot::class.java, "hot_shot_database").build()
    }

    @Singleton
    @Provides
    fun provideCategoryDAO(databaseHotShot: DatabaseHotShot) : CategoryDao = databaseHotShot.categoryDao()

    @Singleton
    @Provides
    fun provideHotShotsDAO(databaseHotShot: DatabaseHotShot) : HotShotDao = databaseHotShot.hotShotDao()

    @Singleton
    @Provides
    fun provideWebPageDAO(databaseHotShot: DatabaseHotShot) : WebPageDao = databaseHotShot.webPageDao()
}