package com.github.liuxuebing2010.other.asplugin.fragment.src.app_package

fun mvvmViewModel(
    packageName:String,
    fragmentClass:String
)="""
package ${packageName}

import com.oulive.net.base.BaseViewModel

class ${fragmentClass}ViewModel : BaseViewModel() {
    
}    
"""