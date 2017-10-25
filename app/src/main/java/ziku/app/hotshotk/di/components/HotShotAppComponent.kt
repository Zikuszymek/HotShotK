package ziku.app.hotshotk.di.components

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ziku.app.hotshotk.HotShotApplication
import ziku.app.hotshotk.di.modules.*
import ziku.app.hotshotk.di.modules.fragments.FragmentModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ActivitiesModule::class,
        ServiceAndReceiverModule::class,
        FragmentModule::class,
        AppModule::class,
        HttpModule::class,
        DataBaseModule::class
))
 interface HotShotAppComponent : AndroidInjector<HotShotApplication> {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: HotShotApplication) : HotShotAppComponent.Builder
        fun build() : HotShotAppComponent
    }
}