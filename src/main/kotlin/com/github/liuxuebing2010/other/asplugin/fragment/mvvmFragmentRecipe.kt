package com.github.liuxuebing2010.other.asplugin.fragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.github.liuxuebing2010.other.asplugin.fragment.res.layout.mvvmFragmentXml
import com.github.liuxuebing2010.other.asplugin.fragment.src.app_package.mvvmFragmentKt
import com.github.liuxuebing2010.other.asplugin.fragment.src.app_package.mvvmViewModel


fun RecipeExecutor.mvvmFragmentRecipe(
    moduleData: ModuleTemplateData,
    fragmentClass: String,
    layoutName: String,
    packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension

    addAllKotlinDependencies(moduleData)

    val mvvmFragment = mvvmFragmentKt(projectData.applicationPackage, packageName, fragmentClass)
    // 保存Fragment
    save(mvvmFragment, srcOut.resolve("${fragmentClass}Fragment.${ktOrJavaExt}"))
    // 保存xml
    save(
        mvvmFragmentXml(projectData.applicationPackage, packageName, fragmentClass),
        resOut.resolve("layout/${layoutName}.xml")
    )
    // 保存viewmodel
    save(
        mvvmViewModel(packageName, fragmentClass),
        srcOut.resolve("${fragmentClass}ViewModel.${ktOrJavaExt}")
    )
    // 保存repository
//    save(mvvmRepository(packageName, activityClass), srcOut.resolve("${activityClass}Repository.${ktOrJavaExt}"))
}