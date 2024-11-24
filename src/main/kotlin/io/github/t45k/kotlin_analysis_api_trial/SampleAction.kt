package io.github.t45k.kotlin_analysis_api_trial

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.psi.PsiManager
import org.jetbrains.kotlin.analysis.api.analyze
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtNameReferenceExpression

class SampleAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val currentOpeningFile = FileEditorManager.getInstance(project).selectedFiles[0]
        val ktFile = PsiManager.getInstance(project).findFile(currentOpeningFile) as KtFile
        ApplicationManager.getApplication().executeOnPooledThread {
            ApplicationManager.getApplication().runReadAction {
//                val condition = ktFile.children[4].children[1].children[1].children[0].children[0] as KtExpression
                // this@analyze.calculateExpectedType()

                // animal = ktFile.children[4].children[1].children[1].children[1].children[0].children[0].children[0]
                analyze(ktFile) {
                    val animal = ktFile.children[4].children[1].children[1].children[1].children[0].children[0].children[0] as KtNameReferenceExpression
                    println()
                }
            }
        }
    }
}
