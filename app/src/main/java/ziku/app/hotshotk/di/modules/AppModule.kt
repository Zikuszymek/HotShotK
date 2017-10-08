package ziku.app.hotshotk.di.modules

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import ziku.app.hotshotk.HotShotApplication
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideContext(application: HotShotApplication): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideSharedPrefs(context: Context) : SharedPreferences = context.getSharedPreferences("HotShot", Activity.MODE_PRIVATE)
}