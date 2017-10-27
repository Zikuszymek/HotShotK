package ziku.app.hotshotk.di.modules

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import ziku.app.hotshotk.HotShotApplication
import ziku.app.hotshotk.R
import ziku.app.hotshotk.providers.PriceManager
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideContext(application: HotShotApplication): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideSharedPrefs(context: Context) : SharedPreferences = context.getSharedPreferences(context.getString(R.string.hot_shot), Activity.MODE_PRIVATE)

    @Provides
    @Singleton
    fun providePriceManager() : PriceManager = PriceManager()

    @Provides
    fun provideDisposable() : CompositeDisposable = CompositeDisposable()

}