package com.osfunapps.schedulesms.infrastructure.more

import android.Manifest
import android.support.v4.app.ActivityCompat
import android.content.pm.PackageManager
import android.app.Activity
import android.content.Context
import android.support.v4.content.ContextCompat


/**
 * Created by osapps on 19/08/2018.
 */

public object PermissionsHandler {

    //permission for example: Manifest.permission.SEND_SMS
    public fun isPermissionGranted(mContext: Context, permissionName: String) =
            ContextCompat.checkSelfPermission(mContext, permissionName) ==
                    PackageManager.PERMISSION_GRANTED

    //permission for example: Manifest.permission.SEND_SMS
    public fun requestPermission(activity: Activity, permissionName: String, requestCode: Int) =
            ActivityCompat.requestPermissions(activity,
                    arrayOf(permissionName), requestCode)


    /*on your activity:
    @activity
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults)
    {
        switch(requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS : {

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted
                    sendSms(phone, message);
                } else {
                    // permission denied
                }
                return;
            }
        }
    }
    */
}