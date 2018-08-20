package com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.broadcast

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.osfunapps.schedulesms.activity.frags.detail.presentation.banks.Finals
import com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.objects.MsgBundle
import com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.broadcast.MsgRequestReceiver
import javax.inject.Inject

/**
 * Created by osapps on 19/08/2018.
 */
class MsgAlarmManager @Inject constructor(private val context: Context){

    //TODO make delete mechanism to delete more then 50 messages
    fun scheduleMsg(msgBundle: MsgBundle) {
        val intent = Intent(context, MsgRequestReceiver::class.java)
        val mPendingIntentId = 123456
        intent.putExtra(Finals.INTENT_BUNDLE_ID, msgBundle.bundleId)
        val mPendingIntent = PendingIntent.getBroadcast(context, mPendingIntentId, intent, PendingIntent.FLAG_CANCEL_CURRENT)
        val mgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager?
        mgr!!.set(AlarmManager.RTC, msgBundle.timeInMillis ,mPendingIntent)
    }
}