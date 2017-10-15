package ziku.app.hotshotk.activities.details

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ziku.app.hotshotk.db.dao.WebPageDao
import ziku.app.hotshotk.db.entities.HotShot
import ziku.app.hotshotk.providers.PriceManager
import ziku.app.hotshotk.providers.PriceModel
import javax.inject.Inject

class DetailsDataManager @Inject constructor(private val priceManager: PriceManager, private val webPageDao: WebPageDao) : DetailsContractor.DataManager {

    override fun getPriceDetails(hotShot: HotShot): PriceModel = priceManager.getPriceDataForView(hotShot)

    override fun getWebPageButtonText(web_page: Int, body: (string: String) -> Unit) {
        Single.fromCallable { webPageDao.getObjectById(web_page) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            body(it?.name_web_page ?: "")
                        },
                        {})
    }
}