package ziku.app.hotshotk.di.modules.presenters

import dagger.Binds
import dagger.Module
import ziku.app.hotshotk.activities.settings.SettingsContractor
import ziku.app.hotshotk.activities.settings.SettingsDataManager
import ziku.app.hotshotk.activities.settings.SettingsPresenter
import ziku.app.hotshotk.di.scope.PerActivity

@Module
abstract class SettingsPresenterModule {

    @Binds
    @PerActivity
    abstract fun bindSettingsPresenter(settingsPresenter: SettingsPresenter) : SettingsContractor.Presenter

    @Binds
    @PerActivity
    abstract fun bindSettingsDataManager(settingsDataManager: SettingsDataManager) : SettingsContractor.DataManager
}