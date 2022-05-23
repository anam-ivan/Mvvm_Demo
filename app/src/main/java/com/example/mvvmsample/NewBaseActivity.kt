package com.example.mvvmsample

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmsample.utils.SessionManager

/*abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {
    private lateinit var binding: B
    private lateinit var viewModel: VM
    // protected val transparentDialogLoader = TransparentDialogLoader()

    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.TRANSPARENT
        }
        super.onCreate(savedInstanceState)
        bindContentView(layoutId())
    }

    private fun bindContentView(layoutId: Int) {
        binding = DataBindingUtil.setContentView(this, layoutId)
        viewModel = ViewModelProvider(this, viewModelFactory).get(getViewModelClass())
    }

    abstract fun getViewModelClass(): Class<VM>

    @LayoutRes
    protected abstract fun layoutId(): Int

    *//*protected fun getHttpError(responseBody: ResponseBody): ErrorModel?{
        return try{
            val jsonObject = JSONObject(responseBody.string())
            Gson().fromJson(jsonObject.toString(), ErrorModel::class.java)
        }catch (e: Exception){
            e.printStackTrace()
            null
        }
    }*//*

    fun toggleStatusBarTextColor(light: Boolean) {
        // clear any existing flags
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (light)
                window.insetsController?.setSystemBarsAppearance(0, APPEARANCE_LIGHT_STATUS_BARS)
            else
                window.insetsController?.setSystemBarsAppearance(APPEARANCE_LIGHT_STATUS_BARS, APPEARANCE_LIGHT_STATUS_BARS)
        }else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
            if (light) {
                window.decorView.systemUiVisibility =
                    (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            } else {
                window.decorView.systemUiVisibility =
                    (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
            }
        }
    }

    protected fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    protected fun View.showKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    *//*protected fun showErrorMsg(msg:String,view:View) {
        val snackbar = Snackbar.make(
            view,
            msg,
            Snackbar.LENGTH_LONG
        )

        val snack_root_view = snackbar.view
        snackbar.view.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        val snack_text_view = snack_root_view
            .findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
        //val snack_action_view = snack_root_view
        // .findViewById<Button>(com.google.android.material.R.id.snackbar_action)
        snack_root_view.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        snack_text_view.setTextColor(Color.WHITE)
        snack_text_view.textSize = 12.2f
        val tf = ResourcesCompat.getFont(this, R.font.mulish_semi_bold)
        snack_text_view.typeface = tf
//    snack_action_view.typeface = tf
//    snack_action_view.setTextColor(ContextCompat.getColor(this, R.color.Sunglow))
//    snackbar.setAction("Retry") {
//
//    }
        snackbar.show()
    }*//*

    *//*protected fun generateFcmToken(){
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("Fcm error", "Fetching FCM registration token failed", task.exception)
                generateFcmToken()
                return@OnCompleteListener
            }
            task.result?.let { Log.e("fcm", it)
                sessionManager.storePushFcmToken(it)
                return@let
            }
        })
    }*//*
}*/
