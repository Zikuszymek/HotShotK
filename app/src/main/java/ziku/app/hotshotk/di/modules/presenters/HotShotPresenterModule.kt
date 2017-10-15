package ziku.app.hotshotk.di.modules.presenters

import dagger.Binds
import dagger.Module
import dagger.Provides
import ziku.app.hotshotk.activities.hotshotmain.HotShotContractor
import ziku.app.hotshotk.activities.hotshotmain.HotShotDataManager
import ziku.app.hotshotk.activities.hotshotmain.HotShotPresenter
import ziku.app.hotshotk.animations.MainActivityAnimations
import ziku.app.hotshotk.di.scope.PerActivity

@Module
abstract class HotShotPresenterModule {

    @Binds
    @PerActivity
    abstract fun bindHotShotMainPresenter(hotShotMainPresenter: HotShotPresenter) : HotShotContractor.Presenter

    @Binds
    @PerActivity
    abstract fun bindHotShotDataManager(hotShotDataManager: HotShotDataManager) : HotShotContractor.DataManager
}