package ziku.app.hotshotk.di.modules

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ziku.app.hotshotk.http.RetrofitService
import ziku.app.hotshotk.moshi.IntToBooleanAdapter
import javax.inject.Named
import javax.inject.Singleton

@Module
class HttpModule {

    @Provides
    @Singleton
    fun provideRetrofitService(@Named("retrofitUrl") retrofitUrl : String, okHttpClient: OkHttpClient, moshi: Moshi) : Retrofit {
        return Retrofit.Builder()
                .baseUrl(retrofitUrl)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideMoshi() : Moshi{
        var moshi = Moshi.Builder()
        moshi.add(KotlinJsonAdapterFactory())
        moshi.add(IntToBooleanAdapter())
        return moshi.build()
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
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        okHttpBuilder.addInterceptor(logging)
        return okHttpBuilder.build()
    }

    @Provides
    @Named("retrofitUrl")
    fun provideRetrofitUrl():String = "http://hotshot.ziku.ayz.pl"
}