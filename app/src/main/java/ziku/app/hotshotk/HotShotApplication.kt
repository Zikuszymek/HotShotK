package ziku.app.hotshotk

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber
import ziku.app.hotshotk.di.components.DaggerHotShotAppComponent
import ziku.app.hotshotk.providers.JobShedulerManager
import javax.inject.Inject
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric



class HotShotApplication : DaggerApplication() {

    @Inject
    lateinit var jobShedulerManager : JobShedulerManager

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val hotshotAppComponent = DaggerHotShotAppComponent.builder()
                .application(this)
                .build()
        hotshotAppComponent.inject(this)
        return hotshotAppComponent
    }

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
        Timber.plant(Timber.DebugTree())
    }

}