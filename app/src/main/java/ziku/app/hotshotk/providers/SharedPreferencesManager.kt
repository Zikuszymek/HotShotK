package ziku.app.hotshotk.providers

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferencesManager @Inject constructor(val sharedPreferences: SharedPreferences){

    var sharedPreferencesEditor = sharedPreferences.edit()

    companion object {
        val SHALL_SYNCHRONIZE_IN_BACKGROUND = "HotShotSynchronization"
        val SYNCHRONIZE_ONLY_WITH_WIFI = "onlyWifiSynchronization"
        val NOTIFY_USER_ABOUT_NEW= "notification"
        val VIBRATNION_IN_NOTIFICATION = "vibration"
    }

    fun readBoleanValue(keyValue : String) : Boolean = sharedPreferences.getBoolean(keyValue, false)

    fun putBooleanValue(keyValue: String , booleanValue: Boolean) {
        sharedPreferencesEditor.putBoolean(keyValue, booleanValue)
        commit()
    }

    private fun commit(){
        sharedPreferencesEditor.commit()
    }

}