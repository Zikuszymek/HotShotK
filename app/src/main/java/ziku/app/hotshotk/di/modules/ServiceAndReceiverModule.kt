package ziku.app.hotshotk.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ziku.app.hotshotk.di.scope.PerReceiver
import ziku.app.hotshotk.di.scope.PerService
import ziku.app.hotshotk.receivers.SynchronizationReceiver
import ziku.app.hotshotk.services.RefreshService

@Module
abstract class ServiceAndReceiverModule {

    @PerReceiver
    @ContributesAndroidInjector
    abstract fun bindSynchronizationReceiver(): SynchronizationReceiver

    @PerService
    @ContributesAndroidInjector
    abstract fun bindRefreshService(): RefreshService
}