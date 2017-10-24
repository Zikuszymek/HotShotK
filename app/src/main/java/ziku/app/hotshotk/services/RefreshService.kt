package ziku.app.hotshotk.services

import android.content.Intent
import dagger.android.DaggerIntentService
import ziku.app.hotshotk.providers.HotShotSynchronization
import javax.inject.Inject

class RefreshService : DaggerIntentService(RefreshService.INTENT_NAME) {

    @Inject
    lateinit var synchronization: HotShotSynchronization

    companion object {
        const val INTENT_NAME = "HotShot_Synchronization"
    }

    override fun onHandleIntent(intent: Intent?) {
        synchronization.invokeSynchronization(true)
    }

}