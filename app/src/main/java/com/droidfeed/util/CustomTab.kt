package com.droidfeed.util

import android.app.Activity
import android.content.ComponentName
import android.net.Uri
import android.support.customtabs.CustomTabsClient
import android.support.customtabs.CustomTabsIntent
import android.support.customtabs.CustomTabsServiceConnection
import android.support.v4.content.ContextCompat
import android.view.View
import android.webkit.URLUtil
import com.droidfeed.BuildConfig
import com.droidfeed.R
import org.jetbrains.anko.design.snackbar


/**
 * Created by Dogan Gulcan on 11/8/17.
 */
class CustomTab constructor(val activity: Activity) {

    fun showTab2(url: String) {

        if (URLUtil.isValidUrl(url)) {

            val connection = object : CustomTabsServiceConnection() {
                override fun onCustomTabsServiceConnected(componentName: ComponentName,
                                                          client: CustomTabsClient) {
                    client.warmup(0L)
                    val builder = CustomTabsIntent.Builder()
                    val customTabsIntent = builder.build()
                    builder.setToolbarColor(ContextCompat.getColor(activity, R.color.colorPrimary))
                    customTabsIntent.launchUrl(activity, Uri.parse(url))
                }

                override fun onServiceDisconnected(name: ComponentName) {}
            }
            CustomTabsClient.bindCustomTabsService(activity, "com.android.chrome", connection)

        } else {
            snackbar(View(activity), activity.getString(R.string.error_invalid_article_url))
        }

    }
}