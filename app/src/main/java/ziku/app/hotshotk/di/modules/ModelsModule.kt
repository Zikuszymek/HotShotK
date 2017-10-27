package ziku.app.hotshotk.di.modules

import dagger.Binds
import dagger.Module
import ziku.app.hotshotk.di.scope.PerActivity
import ziku.app.hotshotk.providers.*
import javax.inject.Singleton

@Module
abstract class ModelsModule {

    @Binds
    @Singleton
    abstract fun bindSharedPreferencesManager(sharedPreferencesManager: SharedPreferencesManager): SharedPreferencesManager

    @Binds
    @Singleton
    abstract fun bindHotShotSynchronization(hotshotHotShotSynchronization: HotShotSynchronization): HotShotSynchronization

    @Binds
    @Singleton
    abstract fun bindNotificationsManager(notificationsManager: NotificationsManager): NotificationsManager

    @Binds
    @Singleton
    abstract fun bindSystemInfoProvider(systemInfoProvider: SystemInfoProvider): SystemInfoProvider

    @Binds
    @Singleton
    abstract fun bindJobShedulerManager(jobShedulerManager: JobShedulerManager): JobShedulerManager
}