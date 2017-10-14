package ziku.app.hotshotk.activities.settings

import ziku.app.hotshotk.activities.BasePresenter
import ziku.app.hotshotk.activities.BaseView

class SettingsContractor {

    interface View : BaseView<Presenter>{

    }

    interface Presenter : BasePresenter<View>{

    }

    interface DataManager{

    }
}