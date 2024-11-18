package io.github.t45k.kotlin_analysis_api_trial

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.psi.PsiManager
import org.jetbrains.kotlin.psi.KtFile

class SampleAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val currentOpeningFile = FileEditorManager.getInstance(project).selectedFiles[0]
        val psiFile = PsiManager.getInstance(project).findFile(currentOpeningFile)!!
        println(psiFile as? KtFile)
    }
}