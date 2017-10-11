package ziku.app.hotshotk.providers

import io.reactivex.Single
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

    init {
        synchronizeAllData(null)
    }

    fun invokeSynchronization(synchronizationListener: SynchronizationListener) {
        synchronizeAllData(synchronizationListener)
    }

    private fun synchronizeAllData(synchronizationListener: SynchronizationListener?) {
        Single.zip(
                retrofitService.getProductCategories(),
                retrofitService.getWebPages(),
                retrofitService.getHotShots(),
                Function3<List<ProductCategory>, List<WebPage>, List<HotShot>, Boolean> { categories, webPages, hotShots ->
                    categories.forEach({insertOrUpdate(categoryDao, it)})
                    webPages.forEach({insertOrUpdate(webPageDao, it)})
                    hotShots.forEach({insertOrUpdate(hotshodDao, it)})
                    true
                }
        ).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(
                        {
                            Timber.d("Success")
                            synchronizationListener?.onSynchronizationSuccess()
                        },
                        {
                            synchronizationListener?.onSynchronizationError()
                            Timber.d("Error")
                        })
    }

    private fun <T, V> insertOrUpdate(baseDAO: T, baseEntity: V) where T : BaseDAO<V>, V : BaseEntity {
        val existingEntity = baseDAO.getObjectById(baseEntity.id)
        if (existingEntity == null) {
            baseDAO.insertOne(baseEntity)
        } else {
            baseDAO.updateOne(baseEntity)
        }
    }
}