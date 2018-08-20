package com.osfunapps.schedulesms.activity.frags.detail.presentation

import android.Manifest
import android.app.Activity
import android.app.FragmentManager
import com.osfunapps.schedulesms.activity.frags.detail.view.DetailFragmentView

import javax.inject.Inject
import android.content.Context
import android.net.Uri
import android.widget.Toast
import com.osfunapps.schedulesms.R
import com.osfunapps.schedulesms.activity.frags.detail.presentation.banks.Finals
import com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.broadcast.MsgAlarmManager
import com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.handlers.ContactRequestHandler
import com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.handlers.LocalRepoManager
import com.osfunapps.schedulesms.infrastructure.more.PermissionsHandler
import com.osfunapps.schedulesms.infrastructure.more.timedate.TimeDateDialogCallback
import com.osfunapps.schedulesms.infrastructure.more.timedate.TimeDateDialogHandler
import java.util.*


/**
 * Created by osApps on 02/06/2017.
 */

class DetailFragmentPresenterImpl @Inject constructor(private var detailFragmentView: DetailFragmentView,
                                                      private var context: Context,
                                                      private var msgAlarmManager: MsgAlarmManager,
                                                      private var timeDateDialogHandler: TimeDateDialogHandler,
                                                      private var localRepoManager: LocalRepoManager,
                                                      private var contactRequestHandler: ContactRequestHandler,
                                                      private var contactObjectHandler: ContactObjectHandler) : TimeDateDialogCallback {

    fun onViewLoaded(fragmentManager: FragmentManager) {

        timeDateDialogHandler.setInstances(fragmentManager, this)
    }


    /**
     * when user chose time and date
     */
    override fun onDateTimeSet(calendar: Calendar) {
        val time = calendar.timeInMillis

        //todo: take these from views!
        val contactNum = detailFragmentView.contactNumber()
        val msgContent = detailFragmentView.msgContent()

        val msgBundle = localRepoManager.saveMsgBundle(context, time, contactNum, msgContent)
        msgAlarmManager.scheduleMsg(msgBundle)
        Toast.makeText(context, context.getString(R.string.permission_send_sms_approved), Toast.LENGTH_SHORT).show()
    }

    fun onClickScheduleMsg(mActivity: Activity?) {
        if (mActivity != null) {
            if (PermissionsHandler.isPermissionGranted(context, Manifest.permission.SEND_SMS)) {
                popDateDialog(mActivity)
            } else {
                PermissionsHandler.requestPermission(mActivity,
                        Manifest.permission.SEND_SMS, Finals.PERMISSION_REQUEST_CODE_SEND_SMS)
            }
        }

    }

    private fun popDateDialog(mActivity: Activity) =
        timeDateDialogHandler.popDateDialog(mActivity.fragmentManager)

    fun requestContact(mActivity: Activity) = contactRequestHandler.fetchContact(mActivity)

    fun undressContact(mActivity: Activity, data: Uri) {
        val contact = contactObjectHandler.undressPhoneNumberFromContact(mActivity, data)
        if(contact!= null)
            detailFragmentView.setContactPhone(contact.phoneNumber!!)

    }

}