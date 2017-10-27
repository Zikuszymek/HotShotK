package ziku.app.hotshotk.providers

import android.app.AlarmManager
import android.app.NotificationManager
import android.content.Context
import android.net.wifi.WifiManager
import android.os.Build
import android.os.PowerManager
import javax.inject.Inject

class SystemInfoProvider @Inject constructor(
        val context: Context
) {

    companion object {
        const val LOCK_NAME = "HotShot"
        const val WAKE_LOCK_TIME_OUT = 60 * 1000L
    }

    private var wakeLock : PowerManager.WakeLock? = null
    private var wifiLock: WifiManager.WifiLock? = null

    val wifiManager by lazy {
        context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    }

    val alarmManager by lazy {
        context.applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }

    val powerManager by lazy {
        context.applicationContext.getSystemService(Context.POWER_SERVICE) as PowerManager
    }

    val notificationManager by lazy {
        context.applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    fun isWifiEnabled() = wifiManager.isWifiEnabled

    fun getSystemAPIVersion() = Build.VERSION.SDK_INT

    fun acuireLocks(){
        if(wakeLock == null){
            wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOCK_NAME)
            wakeLock?.setReferenceCounted(true)
        }
        if(wifiLock == null){
            wifiLock = wifiManager.createWifiLock(WifiManager.WIFI_MODE_FULL_HIGH_PERF, LOCK_NAME)
        }
        wakeLock?.acquire(WAKE_LOCK_TIME_OUT)
        wifiLock?.acquire()
    }

    fun releaseLocks(){
        wakeLock?.let {
            it.release()
            wakeLock = null
        }
        wifiLock?.let {
            it.release()
            wifiLock = null
        }
    }

}