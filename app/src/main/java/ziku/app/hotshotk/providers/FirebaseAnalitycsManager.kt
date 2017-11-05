package ziku.app.hotshotk.providers

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import javax.inject.Inject

class FirebaseAnalitycsManager @Inject constructor(
        val context : Context
){
    companion object {
        const val NAVIGATION_LOG = "navigation_log"
        const val OPEN_PRODUCT_DETAILS = "open_product_details"
        const val VISIT_PRODUCT_DETAILS = "visit_product_details"
        const val LOG_ERROR_STRING = "string_error"
        const val PRODUCT_URL = "product_url"
        const val PRODUCT_NAME = "product_name"
        const val ERROR = "app_error"
    }

    val firebaseAnalytics by lazy {
        FirebaseAnalytics.getInstance(context)
    }

    fun navigationToActivity(startedActivity: String) {
        var bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.CONTENT, startedActivity)
        firebaseAnalytics.logEvent(NAVIGATION_LOG, bundle)
    }

    fun openDetailsAboutProduct(productName: String){
        var bundle = Bundle()
        bundle.putString(PRODUCT_NAME, productName)
        firebaseAnalytics.logEvent(OPEN_PRODUCT_DETAILS, bundle)
    }

    fun logGoToProduct(productName: String, productUrl: String) {
        var bundle = Bundle()
        bundle.putString(PRODUCT_NAME, productName)
        bundle.putString(PRODUCT_URL, productUrl)
        firebaseAnalytics.logEvent(VISIT_PRODUCT_DETAILS, bundle)
    }

    fun logError(error: String) {
        var bundle = Bundle()
        bundle.putString(LOG_ERROR_STRING, error)
        firebaseAnalytics.logEvent(ERROR, bundle)
    }
}