package com.github.liuxuebing2010.other

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.github.liuxuebing2010.other.asplugin.activity.mvvmActivityTemplate
import com.github.liuxuebing2010.other.asplugin.fragment.mvvmFragmentTemplate

class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {

    override fun getTemplates(): List<Template> = listOf(
        // activity的模板
        mvvmActivityTemplate,
        // fragment的模板
        mvvmFragmentTemplate
    )
}