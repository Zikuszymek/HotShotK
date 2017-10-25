package ziku.app.hotshotk.activities.hotshotmain

import ziku.app.hotshotk.providers.HotShotSynchronization
import ziku.app.hotshotk.providers.SharedPreferencesManager
import javax.inject.Inject

class HotShotDataManager @Inject constructor(
        val synchronization: HotShotSynchronization,
        val sharedPreferencesManager: SharedPreferencesManager
) : HotShotContractor.DataManager {

    companion object {
        const val HOUR = 60 * 60 * 1000
    }

    override fun shallSynchronize() = System.currentTimeMillis() - HOUR > sharedPreferencesManager.lastSynchronization

    override fun synchronizeHotShots() {
        synchronization.invokeSynchronization(false)
    }

}