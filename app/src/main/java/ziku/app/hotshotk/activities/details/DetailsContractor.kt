package ziku.app.hotshotk.activities.details

import ziku.app.hotshotk.activities.BasePresenter
import ziku.app.hotshotk.activities.BaseView

interface DetailsContractor {

    interface View : BaseView<Presenter>{

    }

    interface Presenter : BasePresenter<View>{

    }

    interface DataManager{

    }
}