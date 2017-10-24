package ziku.app.hotshotk.providers

import android.app.AlarmManager
import android.content.Context
import android.net.wifi.WifiManager
import android.os.Build
import javax.inject.Inject

class SystemInfoProvider @Inject constructor(
        val context: Context
) {

    val wifiManager by lazy {
        context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    }

    val alarmManager by lazy {
        context.applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }

    fun isWifiEnabled() = wifiManager.isWifiEnabled

    fun getSystemAPIVersion() = Build.VERSION.SDK_INT

}