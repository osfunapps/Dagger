package com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.osfunapps.schedulesms.R
import com.osfunapps.schedulesms.activity.frags.detail.presentation.banks.Finals.INTENT_BUNDLE_ID
import com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.handlers.MsgPreparer
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MsgRequestReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context, intent: Intent) {
        val bundleId = intent.getIntExtra(INTENT_BUNDLE_ID, -1)
        if (bundleId != -1) {
            val msgPreparer = MsgPreparer()
            msgPreparer.prepareMsg(context, bundleId)
        }
        else
            Toast.makeText(context, context.getString(R.string.send_msg_error), Toast.LENGTH_SHORT).show()
    }

}
