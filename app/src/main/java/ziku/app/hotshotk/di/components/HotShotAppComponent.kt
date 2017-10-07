package ziku.app.hotshotk.di.components

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ziku.app.hotshotk.HotShotApplication
import ziku.app.hotshotk.di.modules.ActivitiesModule
import ziku.app.hotshotk.di.modules.AppModule
import ziku.app.hotshotk.di.modules.DataBaseModule
import ziku.app.hotshotk.di.modules.HttpModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ActivitiesModule::class,
        AppModule::class,
        DataBaseModule::class,
        HttpModule::class
))
 interface HotShotAppComponent : AndroidInjector<HotShotApplication> {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: HotShotApplication) : HotShotAppComponent.Builder
        fun build() : HotShotAppComponent
    }
}