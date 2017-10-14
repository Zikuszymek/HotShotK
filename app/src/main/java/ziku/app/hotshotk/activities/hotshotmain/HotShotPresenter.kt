package ziku.app.hotshotk.activities.hotshotmain

import ziku.app.hotshotk.providers.SynchronizationListener
import javax.inject.Inject

class HotShotPresenter @Inject constructor(val hotShotDataManager: HotShotDataManager) : HotShotContractor.Presenter {

    var view: HotShotContractor.View? = null

    override fun attachView(view: HotShotContractor.View) {
        this.view = view
    }

    override fun deattachView() {
        view = null
    }

    override fun refreshOffer() {
//        hotShotDataManager.synchronizeHotShots(getSynchronizationListener())
    }

    override fun synchronizeHotShots() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun getSynchronizationListener() : SynchronizationListener{
        return object : SynchronizationListener{
            override fun onSynchronizationSuccess() {
                view?.refreshViewPagers()
            }

            override fun onSynchronizationError() {
                view?.showErrorNotification()
            }

        }
    }
}