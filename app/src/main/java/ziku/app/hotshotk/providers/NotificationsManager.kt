package ziku.app.hotshotk.providers

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.support.v4.app.TaskStackBuilder
import ziku.app.hotshotk.R
import ziku.app.hotshotk.activities.hotshotmain.HotShotMainActivity
import ziku.app.hotshotk.db.entities.HotShot
import javax.inject.Inject

class NotificationsManager @Inject constructor(
        val context: Context,
        val sharedPreferencesManager: SharedPreferencesManager,
        val systemInfoProvider: SystemInfoProvider
) {

    companion object {
        const val NOTIFICATION_CHANNELL = "HotShot"
        const val NOTIFICATION_ID = 123
    }

    fun sendHotShotNotification(hotShot: HotShot) {
        if (sharedPreferencesManager.notificationForUser) {
            sendNotificationToUser(hotShot)
        }
    }

    fun clearAllNotification(){
        systemInfoProvider.notificationManager.cancelAll()
    }

    private fun sendNotificationToUser(hotShot: HotShot) {
        val stackBuilder = TaskStackBuilder.create(context)
        stackBuilder.apply {
            addParentStack(HotShotMainActivity::class.java)
            stackBuilder.addNextIntent(Intent(context, HotShotMainActivity::class.java))
        }
        val pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        val notificationToSend = createNotificationContent(hotShot.product_name, pendingIntent)
        systemInfoProvider.notificationManager.notify(NOTIFICATION_ID, notificationToSend)
    }

    private fun createNotificationContent(productName: String, pendingIntent: PendingIntent): Notification {
        //ToDo zrobikonki
        val notificationBuilder = NotificationCompat.Builder(context, NOTIFICATION_CHANNELL)
        notificationBuilder.apply {
            setContentTitle(NOTIFICATION_CHANNELL)
            setContentText(String.format("%s %s", context.getString(R.string.new_notification), productName))
            setContentIntent(pendingIntent)
            setAutoCancel(true)
            setSmallIcon(R.drawable.ic_go_to_icon)
            if (sharedPreferencesManager.vibrationInNotification) {
                setVibrate(longArrayOf(0, 150))
            }
        }
        return notificationBuilder.build()
    }

}