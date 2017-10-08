package ziku.app.hotshotk.http

import io.reactivex.Single
import retrofit2.http.GET
import ziku.app.hotshotk.db.entities.HotShot
import ziku.app.hotshotk.db.entities.ProductCategory
import ziku.app.hotshotk.db.entities.WebPage

class RetrofitService {

    interface HotShotService {
        @GET("categories/?format=json")
        fun getProductCategories(): Single<List<ProductCategory>>

        @GET("webpages/?format=json")
        fun getWebPages(): Single<List<WebPage>>

        @GET("hotshots/?format=json")
        fun getHotShots(): Single<List<HotShot>>
    }

}