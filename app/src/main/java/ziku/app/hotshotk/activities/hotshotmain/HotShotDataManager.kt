package ziku.app.hotshotk.activities.hotshotmain

import ziku.app.hotshotk.providers.HotShotSynchronization
import javax.inject.Inject

class HotShotDataManager @Inject constructor(
        val synchronization: HotShotSynchronization
) : HotShotContractor.DataManager {

    override fun synchronizeHotShots() {
        synchronization.invokeSynchronization(false)
    }

}