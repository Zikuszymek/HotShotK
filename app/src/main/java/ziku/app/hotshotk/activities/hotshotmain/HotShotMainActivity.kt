package ziku.app.hotshotk.activities.hotshotmain

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import ziku.app.hotshotk.R
import ziku.app.hotshotk.activities.BaseActivity

class HotShotMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot_shot_main)

    }

}
