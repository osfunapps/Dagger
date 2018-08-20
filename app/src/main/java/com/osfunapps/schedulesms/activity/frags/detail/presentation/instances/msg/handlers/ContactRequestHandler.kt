package com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.handlers

import android.Manifest
import android.app.Activity
import com.osfunapps.schedulesms.infrastructure.more.PermissionsHandler
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.provider.ContactsContract
import android.content.Intent
import com.osfunapps.schedulesms.activity.frags.detail.presentation.banks.Finals
import com.osfunapps.schedulesms.activity.frags.detail.presentation.banks.Finals.PERMISSION_REQUEST_PICK_CONTACT


/**
 * Created by osapps on 19/08/2018.
 */
class ContactRequestHandler {

    fun fetchContact(mActivity: Activity){
        if(PermissionsHandler.isPermissionGranted(mActivity, Manifest.permission.READ_CONTACTS)){
            openContactIntent(mActivity)
        } else
            PermissionsHandler.requestPermission(mActivity, Manifest.permission.READ_CONTACTS, PERMISSION_REQUEST_PICK_CONTACT)
    }

    fun openContactIntent(mActivity: Activity) {
        val intent = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
        mActivity.startActivityForResult(intent, Finals.REQUEST_PICK_CONTACT)
    }
}