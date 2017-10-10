package ziku.app.hotshotk.providers

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.SingleSource
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import ziku.app.hotshotk.db.dao.BaseDAO
import ziku.app.hotshotk.db.dao.CategoryDao
import ziku.app.hotshotk.db.dao.HotShotDao
import ziku.app.hotshotk.db.dao.WebPageDao
import ziku.app.hotshotk.db.entities.BaseEntity
import ziku.app.hotshotk.db.entities.HotShot
import ziku.app.hotshotk.db.entities.ProductCategory
import ziku.app.hotshotk.db.entities.WebPage
import ziku.app.hotshotk.http.RetrofitService
import javax.inject.Inject

class HotShotSynchronization @Inject constructor(
        val retrofitService: RetrofitService.HotShotService,
        val hotshodDao: HotShotDao,
        val categoryDao: CategoryDao,
        val webPageDao: WebPageDao
) {

    fun invokeSynchronization(){
        synchronizeAllData()
    }

    private fun synchronizeAllData() {
        Single.zip(
                retrofitService.getProductCategories() ,
                retrofitService.getWebPages(),
                retrofitService.getHotShots(),
                Function3<List<ProductCategory>, List<WebPage>, List<HotShot>, Boolean> { categories, webPages, hotShots ->
                    syncAllCategories(categories)
                    syncAllWebPages(webPages)
                    syncAllHotShots(hotShots)
                    true
                }
        ).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(
                        {
                            Timber.d("Success")
                        },
                        {
                            Timber.d("Error")
                        })
    }

    fun syncAllCategories(categoriesList : List<ProductCategory>){
        categoriesList.forEach({
            val category = categoryDao.getObjectById(it.idweb_page_category)
            if(category == null){
                categoryDao.insertAll(it)
            } else {
                categoryDao.update(it)
            }
        })
    }

    fun syncAllWebPages(webPageList : List<WebPage>){
        webPageList.forEach({
            val webPage = webPageDao.getObjectById(it.id_web_page)
            if(webPage == null){
                webPageDao.insertAll(it)
            } else {
                webPageDao.update(it)
            }
        })
    }

    fun syncAllHotShots(hotshotList: List<HotShot>){
        hotshotList.forEach({
            val hotshot = hotshodDao.getObjectById(it.id_hot_shot)
            if(hotshot == null){
                hotshodDao.insertAll(it)
            } else {
                hotshodDao.update(it)
            }
        })
    }

//    fun insertOrUpdate(baseEntity: BaseEntity, baseDAO: BaseDAO, entityToInsert: BaseEntity){
//        if(baseEntity == null){
//            baseDAO.insertAll(entityToInsert)
//        } else {
//            baseDAO.update(entityToInsert)
//        }
//    }

}