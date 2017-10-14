package ziku.app.hotshotk.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ziku.app.hotshotk.activities.hotshotmain.HotShotMainActivity
import ziku.app.hotshotk.activities.intro.IntroActivity
import ziku.app.hotshotk.activities.settings.SettingsActivity
import ziku.app.hotshotk.di.modules.presenters.HotShotPresenterModule
import ziku.app.hotshotk.di.modules.presenters.SettingsPresenterModule
import ziku.app.hotshotk.di.scope.PerActivity

@Module
abstract class ActivitiesModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun provideIntroActivity(): IntroActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(HotShotPresenterModule::class))
    abstract fun provideHotShotMainActivity(): HotShotMainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(SettingsPresenterModule::class))
    abstract fun provideSettingsActivity(): SettingsActivity
}