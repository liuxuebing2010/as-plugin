package com.github.liuxuebing2010.asplugin.services

import com.intellij.openapi.project.Project
import com.github.liuxuebing2010.asplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
