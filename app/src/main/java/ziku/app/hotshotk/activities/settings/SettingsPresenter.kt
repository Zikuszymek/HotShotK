package ziku.app.hotshotk.activities.settings

import javax.inject.Inject


class SettingsPresenter @Inject constructor(val settingsDataManager: SettingsDataManager): SettingsContractor.Presenter {

    var view : SettingsContractor.View? = null

    override fun attachView(view: SettingsContractor.View) {
        this.view = view
    }

    override fun deattachView() {
        view = null
    }
}