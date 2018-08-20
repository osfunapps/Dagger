package com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.handlers

import android.content.Context
import android.telephony.SmsManager
import android.widget.Toast
import com.osfunapps.schedulesms.R
import com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.objects.MsgBundle
import com.osfunapps.schedulesms.infrastructure.localrepository.LocalRepositoryImpl

/**
 * Created by osapps on 18/08/2018.
 */

//will send the message (or not, depending on permissions)
class MsgSender {

    fun prepareAndSendMessage(context: Context, bundleId: Int) {
        val repoManager = LocalRepoManager(null)
        val msgBundle = repoManager.loadMsgBundle(context, bundleId)
        if (msgBundle != null)
            sendMessage(context, msgBundle)
        else
            Toast.makeText(context, context.getString(R.string.send_msg_error_2), Toast.LENGTH_LONG).show()

    }

    private fun sendMessage(context: Context, msgBundle: MsgBundle) {
        val smsManager = SmsManager.getDefault()
        val destinationAddress = msgBundle.destinationAddress
        val msgContent = msgBundle.msgContent
        smsManager.sendTextMessage(destinationAddress, null, msgContent, null, null)

        //show msg sent
        Toast.makeText(context, context.getString(R.string.message_sent_to) + destinationAddress, Toast.LENGTH_LONG).show()
    }
}