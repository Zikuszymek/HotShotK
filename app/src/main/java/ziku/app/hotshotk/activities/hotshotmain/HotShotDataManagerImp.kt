package ziku.app.hotshotk.activities.hotshotmain

import ziku.app.hotshotk.db.entities.HotShot
import ziku.app.hotshotk.db.entities.ProductCategory
import ziku.app.hotshotk.db.entities.WebPage
import ziku.app.hotshotk.http.RetrofitService
import ziku.app.hotshotk.providers.HotShotSynchronization
import ziku.app.hotshotk.providers.SharedPreferencesManager
import javax.inject.Inject

class HotShotDataManagerImp @Inject constructor(
        sharedPreferencesManager: SharedPreferencesManager,
        synchronization: HotShotSynchronization
) : HotShotDataManager {

    var productCategoriesList: List<ProductCategory> = mutableListOf()
    var webPageList: List<WebPage> = mutableListOf()
    var hotShotsList: List<HotShot> = mutableListOf()

    init {
        synchronization.invokeSynchronization()
//        hotShotSynchronization
//        retrofitService.getProductCategories()
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.io())
//                .subscribe({
//                    l -> productCategoriesList = l
//                })
//
//        retrofitService.getWebPages()
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.io())
//                .subscribe({
//                    l -> webPageList = l
//                })
//
//        retrofitService.getHotShots()
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.io())
//                .subscribe({
//                    l -> hotShotsList = l
//                })
    }
}