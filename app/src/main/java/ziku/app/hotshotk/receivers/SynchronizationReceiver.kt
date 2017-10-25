package ziku.app.hotshotk.receivers

import android.content.Context
import android.content.Intent
import dagger.android.DaggerBroadcastReceiver
import timber.log.Timber
import ziku.app.hotshotk.providers.JobShedulerManager
import ziku.app.hotshotk.providers.SystemInfoProvider
import ziku.app.hotshotk.services.RefreshService
import javax.inject.Inject

class SynchronizationReceiver : DaggerBroadcastReceiver(){

    @Inject
    lateinit var jobSchedulerManager: JobShedulerManager
    @Inject
    lateinit var systemInfoProvider: SystemInfoProvider

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        systemInfoProvider.acuireLocks()
        Timber.d("Receiver invoked")
        val synchronizationService = Intent(context, RefreshService::class.java)
        context?.startService(synchronizationService)
        jobSchedulerManager.setSynchronizationAlarmInBackground()
    }
}