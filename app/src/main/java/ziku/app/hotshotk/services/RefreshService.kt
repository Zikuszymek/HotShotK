package ziku.app.hotshotk.services

import android.content.Intent
import dagger.android.DaggerIntentService
import timber.log.Timber
import ziku.app.hotshotk.providers.HotShotSynchronization
import ziku.app.hotshotk.providers.SharedPreferencesManager
import ziku.app.hotshotk.providers.SystemInfoProvider
import javax.inject.Inject

class RefreshService : DaggerIntentService(RefreshService.INTENT_NAME) {

    @Inject
    lateinit var synchronization: HotShotSynchronization
    @Inject
    lateinit var sharedPreferencesManager: SharedPreferencesManager
    @Inject
    lateinit var systemInfoProvider: SystemInfoProvider

    companion object {
        const val INTENT_NAME = "HotShot_Synchronization"
    }

    override fun onHandleIntent(intent: Intent?) {
        Timber.d("Servie invoked")
        if (sharedPreferencesManager.synchronizeOnluWithWiFi) {
            if(!systemInfoProvider.wifiManager.isWifiEnabled)
                return
        }
        Timber.d("Synchronization invoked")
        synchronization.invokeSynchronization(true)
    }

}