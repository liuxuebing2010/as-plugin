package com.github.liuxuebing2010.other.asplugin.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.github.liuxuebing2010.other.asplugin.activity.res.layout.mvvmActivityXml
import com.github.liuxuebing2010.other.asplugin.activity.src.app_package.mvvmAcitivityKt
import com.github.liuxuebing2010.other.asplugin.activity.src.app_package.mvvmViewModel


fun RecipeExecutor.mvvmActivityRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    layoutName: String,
    packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension

    addAllKotlinDependencies(moduleData)

    generateManifest(
        moduleData = moduleData,
        activityClass = "${
            packageName.replace(
                projectData.applicationPackage!! + ".",
                "",
                true
            )
        }.${activityClass}Activity",
        packageName = packageName,
        isLauncher = false,
        hasNoActionBar = false,
        generateActivityTitle = false
    )

    val mvvmActivity = mvvmAcitivityKt(projectData.applicationPackage, packageName, activityClass)
    // 保存Activity
//    save(mvvmActivity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
    save(mvvmActivity, srcOut.resolve("${activityClass}Activity.kt"))
    // 保存xml
    save(
        mvvmActivityXml(projectData.applicationPackage, packageName, activityClass),
        resOut.resolve("layout/${layoutName}.xml")
    )
    // 保存viewmodel
//    save(mvvmViewModel(packageName, activityClass), srcOut.resolve("${activityClass}ViewModel.${ktOrJavaExt}"))
    save(mvvmViewModel(packageName, activityClass), srcOut.resolve("${activityClass}ViewModel.kt"))
    // 保存repository
//    save(mvvmRepository(packageName, activityClass), srcOut.resolve("${activityClass}Repository.${ktOrJavaExt}"))

}