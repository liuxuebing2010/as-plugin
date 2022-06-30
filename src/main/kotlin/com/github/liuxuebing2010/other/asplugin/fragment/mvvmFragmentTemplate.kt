package com.github.liuxuebing2010.other.asplugin.fragment

import com.android.tools.idea.wizard.template.*

val mvvmFragmentTemplate
    get() = template {
//        revision = 1
        name = "MVVM Fragment"
        description = "适用于OU项目中MVVM框架的Fragment"
//        minApi = MIN_API
//        minBuildApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.FragmentGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )

        lateinit var layoutName: StringParameter

        val fragmentClass = stringParameter {
            name = "Fragment Name"
            default = "Main"
            help = "只输入名字，不要包含Fragment"
            constraints = listOf(Constraint.NONEMPTY)
        }

        layoutName = stringParameter {
            name = "Layout Name"
            default = "fragment_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
//            suggest = { "${fragmentToLayout(fragmentClass.value.lowercase())}" }
            suggest = { "fragment_${camelCaseToUnderlines(fragmentClass.value)}" }
        }

        val packageName = defaultPackageNameParameter

        widgets(
            TextFieldWidget(fragmentClass),
            TextFieldWidget(layoutName),
            PackageNameWidget(packageName)
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            mvvmFragmentRecipe(
                data as ModuleTemplateData,
                fragmentClass.value,
                layoutName.value,
                packageName.value
            )
        }
    }


val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.oulive.ou"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }
