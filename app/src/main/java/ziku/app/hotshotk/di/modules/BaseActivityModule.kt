package ziku.app.hotshotk.di.modules

import android.app.Activity
import android.content.Context
import dagger.Binds
import dagger.Module
import ziku.app.hotshotk.di.scope.PerActivity

@Module
abstract class BaseActivityModule {

    companion object {
        val ACTIVITY_FRAGMENT_MANAGER = "BaseActivityFragmentManager"
    }

    @Binds
    @PerActivity
    abstract fun activityContext(activity : Activity) : Context
}