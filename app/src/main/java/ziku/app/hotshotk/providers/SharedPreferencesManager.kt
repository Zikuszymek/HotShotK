package ziku.app.hotshotk.providers

import android.content.Context
import android.content.SharedPreferences
import ziku.app.hotshotk.R
import javax.inject.Inject

class SharedPreferencesManager @Inject constructor(val sharedPreferences: SharedPreferences, val context: Context) {

    private val sharedPreferencesEditor: SharedPreferences.Editor by lazy {
        sharedPreferences.edit()
    }

    var synchronizeInBackground: Boolean
        get() { return readBooleanValue(context.getString(R.string.pref_synchronize_in_background), true)}
        set(value) {putBooleanValue(context.getString(R.string.pref_synchronize_in_background), value)}

    var synchronizeOnluWithWiFi: Boolean
        get() { return readBooleanValue(context.getString(R.string.pref_synchronize_only_with_wifi), false)}
        set(value) {putBooleanValue(context.getString(R.string.pref_synchronize_only_with_wifi), value)}

    var notificationForUser: Boolean
        get() { return readBooleanValue(context.getString(R.string.pref_notify_user_about_new), true)}
        set(value) {putBooleanValue(context.getString(R.string.pref_notify_user_about_new), value)}

    var vibrationInNotification: Boolean
        get() { return readBooleanValue(context.getString(R.string.pref_vibration_in_notification), true)}
        set(value) {putBooleanValue(context.getString(R.string.pref_vibration_in_notification), value)}

    private fun readBooleanValue(keyValue: String, defaultValue : Boolean): Boolean = sharedPreferences.getBoolean(keyValue, defaultValue)

    private fun putBooleanValue(keyValue: String, booleanValue: Boolean) {
        sharedPreferencesEditor.putBoolean(keyValue, booleanValue)
        sharedPreferencesEditor.commit()
    }

}
