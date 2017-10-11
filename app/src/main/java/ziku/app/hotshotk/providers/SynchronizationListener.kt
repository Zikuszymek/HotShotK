package ziku.app.hotshotk.providers

interface SynchronizationListener {
    fun onSynchronizationSuccess()
    fun onSynchronizationError()
}