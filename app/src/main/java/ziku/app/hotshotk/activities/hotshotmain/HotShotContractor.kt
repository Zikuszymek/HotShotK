package ziku.app.hotshotk.activities.hotshotmain

import ziku.app.hotshotk.activities.BasePresenter
import ziku.app.hotshotk.activities.BaseView
import ziku.app.hotshotk.providers.SynchronizationListener

class HotShotContractor {
    interface View : BaseView<Presenter>{
        fun refreshViewPagers()
        fun showErrorNotification()
    }

    interface Presenter : BasePresenter<View>{
        fun synchronizeHotShots()
        fun refreshOffer()
    }

    interface DataManager {
        fun synchronizeHotShots(synchronizationListener: SynchronizationListener)
    }
}