package com.nasa.pictureapp.util

import android.app.Activity
import android.app.Dialog
import com.nasa.pictureapp.R

class AppProgressDialog {
    companion object {
        private var customProgress: AppProgressDialog? = null
    }

    private var mDialog: Dialog? = null

    fun getInstance(): AppProgressDialog? {
        if (customProgress == null) {
            customProgress = AppProgressDialog()
        }
        return customProgress
    }

    fun showProgress(activity: Activity) {
        if (mDialog != null && mDialog!!.isShowing) {
            return
        }
        mDialog = Dialog(activity)
        mDialog?.setContentView(R.layout.progressbar_layout)
        mDialog?.show()
    }

    fun hideProgress() {
        mDialog?.let {
            if (it.isShowing)
                try {
                    it.dismiss()
                } catch (exception: Exception) {
                }
        }
        mDialog = null
    }
}