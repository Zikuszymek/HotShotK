package ziku.app.hotshotk.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ziku.app.hotshotk.activities.hotshotmain.HotShotMainActivity
import ziku.app.hotshotk.activities.intro.IntroActivity
import ziku.app.hotshotk.di.scope.PerActivity

@Module(includes = arrayOf(
        PresentersModule::class
))
abstract class ActivitiesModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun provideIntroActivity(): IntroActivity

    @PerActivity
    @ContributesAndroidInjector
    abstract fun provideHotShotMainActivity(): HotShotMainActivity
}