package ziku.app.hotshotk.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ziku.app.hotshotk.http.RetrofitService
import javax.inject.Named
import javax.inject.Singleton

@Module
class HttpModule {

    @Provides
    @Singleton
    fun provideRetrofitService(@Named("retrofitUrl") retrofitUrl : String, okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
                .baseUrl(retrofitUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideHotShotSerrvice(retrofit: Retrofit) : RetrofitService.HotShotService{
        return retrofit.create(RetrofitService.HotShotService::class.java)

    }

    @Provides
    @Singleton
    fun privideOkHttp() : OkHttpClient {
        val okHttpBuilder =  OkHttpClient.Builder()
        return okHttpBuilder.build()
    }

    @Provides
    @Named("retrofitUrl")
    fun provideRetrofitUrl():String = "http://hotshot.ziku.ayz.pl"
}