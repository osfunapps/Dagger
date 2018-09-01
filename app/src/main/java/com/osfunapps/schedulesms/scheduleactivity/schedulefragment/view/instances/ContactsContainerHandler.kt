package com.osfunapps.schedulesms.scheduleactivity.schedulefragment.view.instances

import android.app.Activity
import android.support.constraint.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.osfunapps.schedulesms.R

/**
 * Created by osapps on 02/09/2018.
 */

private const val DEAD_SPACE_AT_BUBBLE_END = 20

class ContactsContainerHandler{

    fun inflateContact(layoutInflater: LayoutInflater, contactsContainer: LinearLayout): View? {
            contactsContainer.measure(0,0)
            val v = layoutInflater.inflate(R.layout.recipient_list_item, contactsContainer, false)
            contactsContainer.addView(v,contactsContainer.childCount)
            //add margin to view start
            //contactsContainer.addView(v)
            return v
    }


    fun adjustBubbleSize(contactView: View) {

        val personNameTV = contactView.findViewById<TextView>(R.id.person_name_tv)
        personNameTV.measure(0, 0);
        val personNameLP = personNameTV.layoutParams as ConstraintLayout.LayoutParams
        val tvWidth = personNameTV.measuredWidth + personNameLP.leftMargin + personNameLP.rightMargin

        val picTV = contactView.findViewById<ImageView>(R.id.person_pic_iv)
        picTV.measure(0, 0);
        val picTvLP = picTV.layoutParams as ConstraintLayout.LayoutParams
        val picWidth = picTV.measuredWidth + picTvLP.leftMargin + picTvLP.rightMargin

        val personBubble = contactView.findViewById<ImageView>(R.id.person_bubble_iv)
        personBubble.measure(0,0)
        var lp = personBubble.layoutParams
        lp.width = tvWidth + picWidth + DEAD_SPACE_AT_BUBBLE_END
        personBubble.layoutParams = lp

        val papaView = contactView.findViewById<ConstraintLayout>(R.id.papa_view_l)
        papaView.measure(0,0)
        lp = papaView.layoutParams as LinearLayout.LayoutParams
        lp.marginStart = 16
        papaView.layoutParams = lp
        papaView.invalidate()



    }
}