package ziku.app.hotshotk.di.modules

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ziku.app.hotshotk.http.RetrofitService
import javax.inject.Named
import javax.inject.Singleton

@Module
class HttpModule {

    @Provides
    @Singleton
    fun provideRetrofitService(@Named("retrofitUrl") retrofitUrl : String) : Retrofit {
        return Retrofit.Builder()
                .baseUrl(retrofitUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideHotShotSerrvice(retrofit: Retrofit) : RetrofitService.HotShotService{
        return retrofit.create(RetrofitService.HotShotService::class.java)

    }

    @Provides
    @Named("retrofitUrl")
    fun provideRetrofitUrl():String = "http://hotshot.ziku.ayz.pl"
}