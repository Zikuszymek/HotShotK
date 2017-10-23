package ziku.app.hotshotk.di.modules

import dagger.Binds
import dagger.Module
import ziku.app.hotshotk.di.scope.PerActivity
import ziku.app.hotshotk.providers.HotShotSynchronization
import ziku.app.hotshotk.providers.NotificationsManager
import ziku.app.hotshotk.providers.SharedPreferencesManager
import javax.inject.Singleton

@Module
abstract class ModelsModule {

    @Binds
    @Singleton
    abstract fun bindSharedPreferencesManager(sharedPreferencesManager: SharedPreferencesManager): SharedPreferencesManager

    @Binds
    @PerActivity
    abstract fun bindHotShotSynchronization(hotshotHotShotSynchronization: HotShotSynchronization): HotShotSynchronization

    @Binds
    @Singleton
    abstract fun bindNotificationsManager(notificationsManager: NotificationsManager): NotificationsManager
}