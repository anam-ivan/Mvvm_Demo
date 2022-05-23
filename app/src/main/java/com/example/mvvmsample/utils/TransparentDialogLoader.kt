package com.example.mvvmsample.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import com.example.mvvmsample.R

class TransparentDialogLoader {

    var dialog: CustomDialog?=null

    fun show(context: Context): Dialog {
        val inflater = (context as Activity).layoutInflater
        val view = inflater.inflate(R.layout.layout_dialog_progress, null)
        dialog = CustomDialog(context)
        dialog?.setContentView(view)
        dialog?.show()
        return dialog!!
    }

    fun dismiss(){
        dialog?.dismiss()
    }

    class CustomDialog(context: Context) : Dialog(context, R.style.CustomDialogTheme) {
        init {
            // Set Semi-Transparent Color for Dialog Background
            window?.decorView?.rootView?.setBackgroundResource(R.color.transparent)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT_WATCH) {
                window?.decorView?.setOnApplyWindowInsetsListener { _, insets ->
                    insets.consumeSystemWindowInsets()
                }
            }
        }
    }
}