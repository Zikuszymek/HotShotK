package ziku.app.hotshotk.fragments.settings

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceFragment
import android.preference.SwitchPreference
import ziku.app.hotshotk.HotShotApplication
import ziku.app.hotshotk.R
import ziku.app.hotshotk.providers.JobShedulerManager

class SettingsFragment : PreferenceFragment(), SharedPreferences.OnSharedPreferenceChangeListener {

    val synchronizePreferences: SwitchPreference by lazy {
        preferenceScreen.findPreference(getString(R.string.pref_synchronize_in_background)) as SwitchPreference
    }

    val synchronizeOnlyWithWiFiPreferences: SwitchPreference by lazy {
        preferenceScreen.findPreference(getString(R.string.pref_synchronize_only_with_wifi)) as SwitchPreference
    }

    val notificationsPreferences: SwitchPreference by lazy {
        preferenceScreen.findPreference(getString(R.string.pref_notify_user_about_new)) as SwitchPreference
    }

    val vibrationsPreferences: SwitchPreference by lazy {
        preferenceScreen.findPreference(getString(R.string.pref_vibration_in_notification)) as SwitchPreference
    }

    val jobShedulerManager : JobShedulerManager by lazy {
        (activity.applicationContext as HotShotApplication).jobShedulerManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferenceManager.sharedPreferencesName = getString(R.string.hot_shot)
        addPreferencesFromResource(R.xml.preferences_settings)
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        when (key) {
            getString(R.string.pref_notify_user_about_new) -> {
                switchTextDetails(notificationsPreferences)
                disableConnectedPreference(notificationsPreferences, vibrationsPreferences)
            }
            getString(R.string.pref_synchronize_in_background) -> {
                setBackgroundSynchronization(synchronizePreferences.isChecked)
                switchTextDetails(synchronizePreferences)
                disableConnectedPreference(synchronizePreferences, synchronizeOnlyWithWiFiPreferences)
            }
            getString(R.string.pref_vibration_in_notification) -> {
                switchTextDetails(vibrationsPreferences)
            }
        }
    }

    private fun setBackgroundSynchronization(enableBackgroundSynchronization : Boolean){
        if(enableBackgroundSynchronization){
            jobShedulerManager.setSynchronizationAlarmInBackground()
        } else {
            jobShedulerManager.cancelAlarmManagers()
        }
    }

    private fun disableConnectedPreference(switchPreference: SwitchPreference, preferenceToDisable: SwitchPreference) {
        preferenceToDisable.isEnabled = switchPreference.isChecked
    }

    private fun switchTextDetails(switchPreference: SwitchPreference) {
        if (switchPreference.isChecked) {
            switchPreference.summary = getString(R.string.active)
        } else {
            switchPreference.summary = getString(R.string.inactive)
        }

    }
}