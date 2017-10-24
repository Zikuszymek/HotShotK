package ziku.app.hotshotk.providers

import android.annotation.TargetApi
import android.app.AlarmManager
import android.app.PendingIntent
import android.app.job.JobScheduler
import android.app.job.JobInfo
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import ziku.app.hotshotk.receivers.SynchronizationReceiver
import ziku.app.hotshotk.services.RefreshService
import java.util.*
import javax.inject.Inject

class JobShedulerManager @Inject constructor(
        val context: Context,
        val sharedPreferencesManager: SharedPreferencesManager,
        val systemInfoProvider: SystemInfoProvider
) {

    companion object {
        const val REQUEST_CODE = 1234
        const val ONE_MINUTE = 60 * 1000
        const val TIMER = 4 * ONE_MINUTE
        const val PERIOD = 60 * ONE_MINUTE
    }

    private val alarmPendingIntent by lazy {
        val intent = Intent(context, SynchronizationReceiver::class.java)
        PendingIntent.getBroadcast(context, REQUEST_CODE, intent, 0)
    }

    fun setSynchronizationInBackground() {
        menageSynchronizationFromAPI()
    }

    private fun menageSynchronizationFromAPI() {
        if (sharedPreferencesManager.synchronizeInBackground) {
            if (sharedPreferencesManager.synchronizeOnluWithWiFi) {
                if (!systemInfoProvider.isWifiEnabled()) {
                    return
                }
            }
            setServiceByApiVersion()
        }
    }

    private fun setServiceByApiVersion() {
        cancelAlarmManagers()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            systemInfoProvider.alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, getProperStartTime(), alarmPendingIntent)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            systemInfoProvider.alarmManager.setExact(AlarmManager.RTC_WAKEUP, getProperStartTime(), alarmPendingIntent)
        } else {
            systemInfoProvider.alarmManager.set(AlarmManager.RTC_WAKEUP, getProperStartTime(), alarmPendingIntent)
        }
    }

    private fun getProperStartTime(): Long {
        return (System.currentTimeMillis() - (Calendar.getInstance().get(Calendar.MINUTE) * ONE_MINUTE)) + PERIOD + TIMER
    }

    @TargetApi(23)
    private fun jobShedulerAPI() {
        val serviceComponent = ComponentName(context, RefreshService::class.java)
        val builder = JobInfo.Builder(0, serviceComponent)
        builder.setMinimumLatency((1 * 1000).toLong()) // wait at least
        builder.setOverrideDeadline((3 * 1000).toLong()) // maximum delay
        //builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED); // require unmetered network
        //builder.setRequiresDeviceIdle(true); // device should be idle
        //builder.setRequiresCharging(false); // we don't care if the device is charging or not
        val jobScheduler = context.getSystemService(JobScheduler::class.java)
        jobScheduler.schedule(builder.build())
    }

    fun cancelAlarmManagers() {
        systemInfoProvider.alarmManager.cancel(alarmPendingIntent)
    }

}