package ziku.app.hotshotk.activities.hotshotmain

import ziku.app.hotshotk.activities.BaseView
import javax.inject.Inject

class HotShotPresenterImp @Inject constructor(hotShotDataManager: HotShotDataManager) : HotShotMainPresenter {
    override fun refreshOffer() {
    }

    override var view: BaseView? = null

    override fun attachView(view: BaseView) {
        this.view = view
    }

    override fun deattachView() {
        view = null
    }

    override fun synchronizeHotShots() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}