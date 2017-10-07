package ziku.app.hotshotk.activities.hotshotmain

import ziku.app.hotshotk.activities.BaseView

class HotShotPresenterImp : HotShotMainPresenter {

    override var view: BaseView? = null

    override fun attachView(view: BaseView) {
        this.view = view
    }

    override fun deattachView() {
        view = null
    }
}