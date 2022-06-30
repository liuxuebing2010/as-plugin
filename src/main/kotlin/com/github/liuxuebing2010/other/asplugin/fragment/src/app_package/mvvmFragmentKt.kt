package com.github.liuxuebing2010.other.asplugin.fragment.src.app_package

fun mvvmFragmentKt(
    applicationPackage:String?,
    packageName:String,
    fragmentClass:String
)="""
package ${packageName}

import android.os.Bundle
import android.view.View
import com.kunminx.architecture.ui.page.DataBindingConfig
import com.oulive.base.ui.BaseVbFragment
import ${applicationPackage}.BR;
import ${applicationPackage}.databinding.Fragment${fragmentClass}Binding

class ${fragmentClass}Fragment : BaseVbFragment<Fragment${fragmentClass}Binding>() {

    lateinit var mState: ${fragmentClass}ViewModel

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun lazyLoadData() {

    }

    override fun createObserver() {
        super.createObserver()
    }

    override fun initViewModel() {
        super.initViewModel()
        mState = getFragmentScopeViewModel(${fragmentClass}ViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig? {
        super.getDataBindingConfig()
        return DataBindingConfig(BR.viewModel, mState)
            .addBindingParam(BR.click, ClickProxy())
    }

    inner class ClickProxy {

        fun clickNext(view: View) {
        }

    }
}
 
"""