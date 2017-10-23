package ziku.app.hotshotk.providers

import ziku.app.hotshotk.db.dao.BaseDAO
import ziku.app.hotshotk.db.dao.CategoryDao
import ziku.app.hotshotk.db.dao.HotShotDao
import ziku.app.hotshotk.db.dao.WebPageDao
import ziku.app.hotshotk.db.entities.BaseEntity
import ziku.app.hotshotk.db.entities.HotShot
import ziku.app.hotshotk.http.RetrofitService
import javax.inject.Inject

class HotShotSynchronization @Inject constructor(
        val retrofitService: RetrofitService.HotShotService,
        val hotshodDao: HotShotDao,
        val categoryDao: CategoryDao,
        val webPageDao: WebPageDao,
        val notificationsManager: NotificationsManager
) {

    fun invokeSynchronization(backgroundSynchronization: Boolean) {
        synchronizeAllData(backgroundSynchronization)
    }

    private fun synchronizeAllData(backgroundSynchronization: Boolean) {
        synchronizeCategories()
        synchronizeWebPages()
        val hotShotToNotification = synchronizeHotShots()
        notifyUserAboutHotShot(hotShotToNotification, backgroundSynchronization)
    }

    private fun notifyUserAboutHotShot(hotShotToNotification: HotShot?, backgroundSynchronization: Boolean) {
        if (backgroundSynchronization && hotShotToNotification != null)
            notificationsManager.sendHotShotNotification(hotShotToNotification)
    }

    private fun synchronizeCategories() {
        val productCategoriesList = retrofitService.getProductCategories().blockingGet()
        productCategoriesList.forEach({ insertOrUpdate(categoryDao, it) })
    }

    private fun synchronizeWebPages() {
        val webPagesList = retrofitService.getWebPages().blockingGet()
        webPagesList.forEach({ insertOrUpdate(webPageDao, it) })
    }

    private fun synchronizeHotShots(): HotShot? {
        val hotShotsList = retrofitService.getHotShots().blockingGet()
        return handleHotShotUpdate(hotShotsList)
    }

    private fun <T, V> insertOrUpdate(baseDAO: T, baseEntity: V) where T : BaseDAO<V>, V : BaseEntity {
        val existingEntity = baseDAO.getObjectById(baseEntity.id)
        if (existingEntity == null) {
            baseDAO.insertOne(baseEntity)
        } else {
            baseDAO.updateOne(baseEntity)
        }
    }

    private fun handleHotShotUpdate(hotShotList: List<HotShot>): HotShot? {
        val currentHotShotsList = hotshodDao.getAll()
        var hotShotToNotification: HotShot? = null
        hotShotList.forEach {
            val hotShot = currentHotShotsList.firstOrNull { hotShot -> hotShot.id == it.id }
            if (hotShot != null && hotShot.product_name != it.product_name && it.product_name != "-") {
                hotShotToNotification = it
            }
        }
        hotShotList.forEach({ insertOrUpdate(hotshodDao, it) })
        return hotShotToNotification
    }
}