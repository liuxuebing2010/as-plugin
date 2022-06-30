package com.github.liuxuebing2010.other.asplugin.fragment.res.layout

fun mvvmFragmentXml(
    applicationPackage: String?,
    packageName: String,
    fragmentClass: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">

    <data>
    
        <variable
            name="viewModel"
            type="${packageName}.${fragmentClass}ViewModel" />

        <variable
            name="click"
            type="${packageName}.${fragmentClass}Activity.ClickProxy" />
    
    </data>
    
   <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="${packageName.replace(applicationPackage!!.plus("."),"",true)}.${fragmentClass}Fragment">
    
    
    
    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
"""