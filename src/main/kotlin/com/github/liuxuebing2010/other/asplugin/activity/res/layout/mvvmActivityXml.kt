package com.github.liuxuebing2010.other.asplugin.activity.res.layout

fun mvvmActivityXml(
    applicationPackage: String?,
    packageName: String,
    activityClass: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">

    <data>
        <variable
            name="viewModel"
            type="${packageName}.${activityClass}ViewModel" />

        <variable
            name="click"
            type="${packageName}.${activityClass}Activity.ClickProxy" />
    </data>
    
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="${packageName.replace(applicationPackage!!+".","",true)}.${activityClass}Activity">
    
    
    
</androidx.constraintlayout.widget.ConstraintLayout>
</layout>
"""