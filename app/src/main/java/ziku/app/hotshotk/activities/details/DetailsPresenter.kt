package ziku.app.hotshotk.activities.details

import javax.inject.Inject

class DetailsPresenter @Inject constructor(val detailsDataManager: DetailsDataManager): DetailsContractor.Presenter{

    var view : DetailsContractor.View? = null

    override fun attachView(view: DetailsContractor.View) {
        this.view = view
    }

    override fun deattachView() {
        this.view = null
    }
}