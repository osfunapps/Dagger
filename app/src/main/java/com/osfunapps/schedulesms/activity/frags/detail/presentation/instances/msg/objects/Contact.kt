package com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.objects

import com.osfunapps.schedulesms.activity.frags.detail.presentation.MissingFieldException

/**
 * Created by osapps on 19/08/2018.
 */
class Contact {

    var name: String? = null
        set(newStr) {
            field = fieldErrCheck(newStr, "name")
        }

    var phoneNumber: String? = null
        set(newStr) {
            field = fieldErrCheck(newStr, "phone number")
        }


    private fun fieldErrCheck(newStr: String?, fieldName: String): String? {
        if (newStr.isNullOrBlank())
            throw MissingFieldException(fieldName)
        else
            return newStr
    }
}