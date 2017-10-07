package ziku.app.hotshotk.activities

interface BasePresenter {
    var view : BaseView?
    fun attachView(view : BaseView)
    fun deattachView()
}