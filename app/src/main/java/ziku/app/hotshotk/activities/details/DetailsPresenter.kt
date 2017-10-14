package ziku.app.hotshotk.activities.details

class DetailsPresenter : DetailsContractor.Presenter{

    var view : DetailsContractor.View? = null

    override fun attachView(view: DetailsContractor.View) {
        this.view = view
    }

    override fun deattachView() {
        this.view = null
    }
}