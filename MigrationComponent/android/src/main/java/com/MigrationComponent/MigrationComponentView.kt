package com.MigrationComponent

import com.facebook.react.bridge.ReactContext
import androidx.constraintlayout.widget.ConstraintLayout


class MigrationComponentView(ctx: ReactContext) : ConstraintLayout(ctx) {

    init {
        val inflater = ctx.currentActivity?.layoutInflater;
        inflater?.inflate(R.layout.frame_content, this)
    }

}