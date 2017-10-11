package ziku.app.hotshotk.activities

interface BasePresenter<T> {
    fun attachView(view : T)
    fun deattachView()
}