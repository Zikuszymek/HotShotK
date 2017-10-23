package ziku.app.hotshotk.providers

import android.content.Context
import ziku.app.hotshotk.db.entities.HotShot
import javax.inject.Inject

class NotificationsManager @Inject constructor(
        context: Context,
        sharedPreferencesManager: SharedPreferencesManager
){

    fun sendHotShotNotification(hotShot: HotShot){

    }
}