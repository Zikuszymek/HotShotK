package ziku.app.hotshotk.di.modules.presenters

import dagger.Binds
import dagger.Module
import ziku.app.hotshotk.activities.details.DetailsContractor
import ziku.app.hotshotk.activities.details.DetailsDataManager
import ziku.app.hotshotk.activities.details.DetailsPresenter
import ziku.app.hotshotk.di.scope.PerActivity

@Module
abstract class DetailsPresenterModule {

    @Binds
    @PerActivity
    abstract fun bindDetailsPresenter(detailsPresenter: DetailsPresenter) : DetailsContractor.Presenter

    @Binds
    @PerActivity
    abstract fun bindDetailsDataManager(detailsDataManager: DetailsDataManager) : DetailsContractor.DataManager
}