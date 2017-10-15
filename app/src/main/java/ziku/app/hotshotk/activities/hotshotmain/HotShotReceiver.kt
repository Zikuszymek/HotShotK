package ziku.app.hotshotk.activities.hotshotmain

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter

class HotShotReceiver(val onReceiveAction: () -> Unit) : BroadcastReceiver() {

    companion object {
        val REFRESH_MAIN_ACTIVITY = "refresh_main_activity"
        val REFRESH_MACIN_ACTIVITY_INTENT_FILTER = IntentFilter(REFRESH_MAIN_ACTIVITY)
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        onReceiveAction()
    }

}