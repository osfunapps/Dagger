package com.osfunapps.schedulesms.activity.frags.detail.view

/**
 * Created by osApps on 02/06/2017.
 */

interface DetailFragmentView {
    fun setContactPhone(contactPhone: String)
    fun contactNumber(): String
    fun msgContent(): String
}

