package com.osfunapps.schedulesms.activity.frags.detail.presentation

import android.net.Uri
import android.provider.ContactsContract
import android.app.Activity
import android.content.Context
import android.widget.Toast
import com.osfunapps.schedulesms.R
import com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.objects.Contact


class ContactObjectHandler {
    fun undressPhoneNumberFromContact(mActivity: Activity, data: Uri): Contact? {
        var contact: Contact? = null

        val cursor = mActivity.contentResolver.query(data, null, null, null, null)

        if (cursor.moveToFirst()) {
            val phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
            val nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)

            try {
                contact = Contact()
                contact.phoneNumber = cursor.getString(phoneIndex)
                contact.name = cursor.getString(nameIndex)

            } catch (exception: MissingFieldException) {
                Toast.makeText(mActivity, exception.message, Toast.LENGTH_LONG).show()
                contact = null
            } finally {
                cursor.close()
            }
            return contact
        }

        return contact
    }

}

class MissingFieldException(fieldType: String) : RuntimeException() {

    private val ERR_MSG = "CONTACT ERROR. MISSING FIELD: $fieldType"
    override val message: String?
        get() = ERR_MSG
}
