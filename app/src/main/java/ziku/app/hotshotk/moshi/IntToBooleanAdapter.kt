package ziku.app.hotshotk.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import timber.log.Timber

class IntToBooleanAdapter {

    init {
        Timber.d("AdapterInitialized")
    }

    @ToJson
    fun toJson(@IntToBoolean value: Boolean): Int {
        Timber.d("toJson")
        if (value) {
            return 1
        }
        return 0
    }

    @FromJson
    @IntToBoolean
    fun fromJson(value: Int): Boolean {
        Timber.d("fromJson")
        if(value == 0){
            return false
        }
        return true
    }
}