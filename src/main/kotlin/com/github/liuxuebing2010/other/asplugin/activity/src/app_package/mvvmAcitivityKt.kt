package com.github.liuxuebing2010.other.asplugin.activity.src.app_package

fun mvvmAcitivityKt(
    applicationPackage:String?,
    packageName:String,
    activityClass:String
)="""
package ${packageName}
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.kunminx.architecture.ui.page.DataBindingConfig
import com.oulive.base.ui.BaseVdbActivity
import ${applicationPackage}.BR
import ${applicationPackage}.databinding.Activity${activityClass}Binding
import com.oulive.ou_controler.arouter.ARouterPath

@Route(path = ARouterPath.${activityClass}Activity)
class ${activityClass}Activity : BaseVdbActivity<Activity${activityClass}Binding>() {

    lateinit var mState: ${activityClass}ViewModel
    
    override fun createObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {
        
    }

    override fun initViewModel() {
        mState = getActivityScopeViewModel(${activityClass}ViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig? {
        return DataBindingConfig(BR.viewModel, mState)
            .addBindingParam(BR.click, ClickProxy())
    }

    inner class ClickProxy {

        fun clickNext(view: View) {
        }

    }
}
"""