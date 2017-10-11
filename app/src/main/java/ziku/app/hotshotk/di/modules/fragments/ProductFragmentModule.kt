package ziku.app.hotshotk.di.modules.fragments

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides
import ziku.app.hotshotk.di.modules.AppModule
import ziku.app.hotshotk.di.scope.PerFragment

@Module(includes = arrayOf(AppModule::class))
class ProductFragmentModule {

    @Provides
    @PerFragment
    fun provideLinearLayoutManager(context: Context) : LinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
}