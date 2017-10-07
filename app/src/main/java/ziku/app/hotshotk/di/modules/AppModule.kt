package ziku.app.hotshotk.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ziku.app.hotshotk.HotShotApplication

@Module(includes = arrayOf(ActivitiesModule::class))
class AppModule {

    @Provides
    fun provideContext(application: HotShotApplication): Context = application.applicationContext
}