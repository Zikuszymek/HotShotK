package ziku.app.hotshotk.fragments.settings

import android.os.Bundle
import android.preference.PreferenceFragment
import ziku.app.hotshotk.R

class SettingsFragment : PreferenceFragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preferences_settings)
    }
}