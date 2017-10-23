package ziku.app.hotshotk.providers

import android.annotation.TargetApi
import android.app.job.JobScheduler
import android.app.job.JobInfo
import android.content.ComponentName
import android.content.Context
import ziku.app.hotshotk.services.RefreshService
import javax.inject.Inject


class JobShedulerManager @Inject constructor(
        val context: Context
) {

    fun menageSynchronizationFromAPI(){
        jobShedulerAPI()
    }

    @TargetApi(21)
    private fun jobShedulerAPI(){
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
}