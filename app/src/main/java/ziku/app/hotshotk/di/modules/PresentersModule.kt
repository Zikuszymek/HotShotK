package ziku.app.hotshotk.di.modules

import dagger.Binds
import dagger.Module
import ziku.app.hotshotk.activities.hotshotmain.HotShotMainPresenter
import ziku.app.hotshotk.activities.hotshotmain.HotShotPresenterImp
import ziku.app.hotshotk.di.scope.PerActivity

@Module(includes = arrayOf(DataManagerModule::class))
abstract class PresentersModule {

    @Binds
    @PerActivity
    abstract fun bindHotShotMainPresenter(hotShotMainPresenter: HotShotPresenterImp) : HotShotMainPresenter
}