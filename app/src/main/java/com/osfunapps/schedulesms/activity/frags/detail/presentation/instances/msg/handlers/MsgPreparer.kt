package com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.handlers

import android.Manifest
import android.content.Context
import android.widget.Toast
import com.osfunapps.schedulesms.R
import com.osfunapps.schedulesms.infrastructure.more.PermissionsHandler
import javax.inject.Inject

/**
 * Created by osapps on 19/08/2018.
 */
public class MsgPreparer{

    fun prepareMsg(context: Context, bundleId: Int) {
        if (PermissionsHandler.isPermissionGranted(context, Manifest.permission.SEND_SMS)) {
            val msgSender = MsgSender()
            msgSender.prepareAndSendMessage(context, bundleId)
        } else {
            Toast.makeText(context, context.getString(R.string.permission_send_sms_missing),
                    Toast.LENGTH_LONG).show()
        }
    }
}