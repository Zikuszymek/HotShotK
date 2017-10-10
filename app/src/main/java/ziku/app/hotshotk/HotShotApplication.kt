package ziku.app.hotshotk

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber
import ziku.app.hotshotk.di.components.DaggerHotShotAppComponent

class HotShotApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val hotshotAppComponent = DaggerHotShotAppComponent.builder()
                .application(this)
                .build()
        hotshotAppComponent.inject(this)
        return hotshotAppComponent
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}