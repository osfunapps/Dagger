package com.osfunapps.schedulesms.activity.frags.detail.presentation.instances.msg.objects

//TODO: change in millis to possibly calendar?
data class MsgBundle (val destinationAddress: String,
                      val msgContent: String,
                      val timeInMillis: Long,
                      val bundleId: Int)
