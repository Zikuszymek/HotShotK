package ziku.app.hotshotk.activities.hotshotmain

import ziku.app.hotshotk.providers.HotShotSynchronization
import ziku.app.hotshotk.providers.SynchronizationListener
import javax.inject.Inject

class HotShotDataManager @Inject constructor(
        val synchronization: HotShotSynchronization
) : HotShotContractor.DataManager{

    override fun synchronizeHotShots(synchronizationListener: SynchronizationListener) {
        synchronization.invokeSynchronization(synchronizationListener)
    }

}