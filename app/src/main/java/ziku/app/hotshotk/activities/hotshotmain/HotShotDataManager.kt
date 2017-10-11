package ziku.app.hotshotk.activities.hotshotmain

import ziku.app.hotshotk.providers.SynchronizationListener

interface HotShotDataManager {
    fun synchronizeHotShots(synchronizationListener: SynchronizationListener)
}