package ziku.app.hotshotk.activities.details

import ziku.app.hotshotk.activities.BasePresenter
import ziku.app.hotshotk.activities.BaseView
import ziku.app.hotshotk.db.entities.HotShot
import ziku.app.hotshotk.providers.PriceModel

interface DetailsContractor {

    interface View : BaseView<Presenter> {
        fun loadDetailsView(priceDetails: PriceModel)
    }

    interface Presenter : BasePresenter<View> {
        fun loadProperViewData(hotShot: HotShot)
        fun getTextForWebPage(web_page: Int, body: (string : String) -> Unit)

    }

    interface DataManager {
        fun getPriceDetails(hotShot: HotShot): PriceModel
        fun getWebPageButtonText(web_page: Int, body: (string: String) -> Unit)
    }
}