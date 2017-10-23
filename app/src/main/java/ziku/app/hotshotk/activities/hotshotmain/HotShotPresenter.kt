package ziku.app.hotshotk.activities.hotshotmain

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HotShotPresenter @Inject constructor(
        val hotShotDataManager: HotShotDataManager,
        val disposable: CompositeDisposable
) : HotShotContractor.Presenter {

    var view: HotShotContractor.View? = null

    override fun attachView(view: HotShotContractor.View) {
        this.view = view
    }

    override fun deattachView() {
        disposable.clear()
        view = null
    }

    override fun refreshOffer() {
        disposable.add(
                Single.fromCallable { hotShotDataManager.synchronizeHotShots() }
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { view?.refreshViewPagers() },
                                { view?.showErrorNotification() }
                        )
        )
        hotShotDataManager.synchronizeHotShots()
    }

    override fun synchronizeHotShots() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}