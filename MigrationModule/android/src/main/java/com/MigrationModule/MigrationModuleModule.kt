package com.MigrationModule

import android.app.Activity
import android.content.Intent
import com.facebook.react.bridge.*

class MigrationModuleModule(reactContext: ReactApplicationContext?) :
    NativeMigrationModuleSpec(reactContext) {
    private val ctx: ReactApplicationContext? = reactContext;
    private var promise: Promise? = null;

    override fun getName(): String {
        return NAME
    }
    private val mActivityEventListener: ActivityEventListener = object : BaseActivityEventListener() {
        override fun onActivityResult(activity: Activity, requestCode: Int, resultCode: Int, intent: Intent?) {
                when (resultCode) {
                    1 -> {
                        promise?.resolve("String from Android side")
                    }
                    0 -> {
                        promise?.reject("USER_CANCELLED", "User has cancelled", null)
                    }
            }
        }
    }

    override fun navigate(data: String?, promise: Promise?) {
        val activity = currentActivity

        if (activity == null) {
            promise?.reject("ERR", "Activity doesn't exist")
            return
        }

        ctx?.addActivityEventListener(mActivityEventListener)
        val intent = Intent(ctx, CustomActivity::class.java)
        activity?.startActivityForResult(intent, 1);
    }

    companion object {
        const val NAME = "MigrationModule"
    }
}