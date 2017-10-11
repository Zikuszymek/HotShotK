package ziku.app.hotshotk.activities.hotshotmain

import ziku.app.hotshotk.providers.HotShotSynchronization
import ziku.app.hotshotk.providers.SynchronizationListener
import javax.inject.Inject

class HotShotDataManagerImp @Inject constructor(
        val synchronization: HotShotSynchronization
) : HotShotDataManager {

    override fun synchronizeHotShots(synchronizationListener: SynchronizationListener) {
        synchronization.invokeSynchronization(synchronizationListener)
    }

}