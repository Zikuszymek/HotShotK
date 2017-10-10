package ziku.app.hotshotk.di.modules

import dagger.Binds
import dagger.Module
import ziku.app.hotshotk.activities.hotshotmain.HotShotDataManager
import ziku.app.hotshotk.activities.hotshotmain.HotShotDataManagerImp
import ziku.app.hotshotk.di.scope.PerActivity

@Module
abstract class DataManagerModule {

    @Binds
    @PerActivity
    abstract fun bindHotShotDataManager(hotShotDataManager: HotShotDataManagerImp) : HotShotDataManager

}