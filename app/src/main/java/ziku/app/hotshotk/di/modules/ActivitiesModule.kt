package ziku.app.hotshotk.di.modules

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import ziku.app.hotshotk.activities.hotshotmain.HotShotMainActivity
import ziku.app.hotshotk.activities.intro.IntroActivity
import ziku.app.hotshotk.di.scope.PerActivity

@Module(includes = arrayOf(BaseActivityModule::class))
abstract class ActivitiesModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun provideIntroActivity(): IntroActivity


    @ContributesAndroidInjector
    abstract fun provideHotShotMainActivity(): HotShotMainActivity
}