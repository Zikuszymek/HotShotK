package ziku.app.hotshotk.di.components

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ziku.app.hotshotk.HotShotApplication
import ziku.app.hotshotk.di.modules.*
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ActivitiesModule::class,
        AppModule::class
))
 interface HotShotAppComponent : AndroidInjector<HotShotApplication> {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: HotShotApplication) : HotShotAppComponent.Builder
        fun build() : HotShotAppComponent
    }
}