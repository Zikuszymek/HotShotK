package ziku.app.hotshotk

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import ziku.app.hotshotk.di.components.DaggerHotShotAppComponent
import javax.inject.Inject

class HotShotApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val hotshotAppComponent = DaggerHotShotAppComponent.builder()
                .application(this)
                .build()
        hotshotAppComponent.inject(this)
        return hotshotAppComponent
    }

}