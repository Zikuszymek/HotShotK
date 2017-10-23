package ziku.app.hotshotk.activities.hotshotmain

import ziku.app.hotshotk.activities.BasePresenter
import ziku.app.hotshotk.activities.BaseView

class HotShotContractor {
    interface View : BaseView<Presenter> {
        fun refreshViewPagers()
        fun showErrorNotification()
    }

    interface Presenter : BasePresenter<View> {
        fun synchronizeHotShots()
    }

    interface DataManager {
        fun synchronizeHotShots()
    }
}