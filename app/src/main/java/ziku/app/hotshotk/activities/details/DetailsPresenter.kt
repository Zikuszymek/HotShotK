package ziku.app.hotshotk.activities.details

import ziku.app.hotshotk.db.entities.HotShot
import javax.inject.Inject

class DetailsPresenter @Inject constructor(val detailsDataManager: DetailsDataManager) : DetailsContractor.Presenter {

    var view: DetailsContractor.View? = null

    override fun attachView(view: DetailsContractor.View) {
        this.view = view
    }

    override fun deattachView() {
        this.view = null
    }

    override fun loadProperViewData(hotShot: HotShot) {
        view?.loadDetailsView(detailsDataManager.getPriceDetails(hotShot))
    }

    override fun getTextForWebPage(web_page: Int, body: (string: String) -> Unit) = detailsDataManager.getWebPageButtonText(web_page, body)
}