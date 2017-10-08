package ziku.app.hotshotk.di.modules

import dagger.Binds
import dagger.Module
import ziku.app.hotshotk.activities.hotshotmain.HotShotDataManager
import ziku.app.hotshotk.activities.hotshotmain.HotShotDataManagerImp
import ziku.app.hotshotk.di.scope.PerActivity
import ziku.app.hotshotk.providers.SharedPreferencesManager
import javax.inject.Singleton

@Module(includes = arrayOf(
        HttpModule::class,
        DataBaseModule::class
        ))
abstract class DataManagerModule {

    @Binds
    @Singleton
    abstract fun bindSharedPreferencesManager(sharedPreferencesManager: SharedPreferencesManager) : SharedPreferencesManager

    @Binds
    @PerActivity
    abstract fun bindHotShotDataManager(hotShotDataManager: HotShotDataManagerImp) : HotShotDataManager
}