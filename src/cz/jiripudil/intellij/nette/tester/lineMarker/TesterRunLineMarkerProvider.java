package cz.jiripudil.intellij.nette.tester.lineMarker;

import com.intellij.execution.lineMarker.RunLineMarkerContributor;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.psi.PsiElement;
import com.jetbrains.php.lang.psi.elements.PhpClass;
import cz.jiripudil.intellij.nette.tester.TesterIcons;
import cz.jiripudil.intellij.nette.tester.action.TesterCreateRunTestAction;
import cz.jiripudil.intellij.nette.tester.action.TesterRunTestAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TesterRunLineMarkerProvider extends RunLineMarkerContributor {
    @Override
    public @Nullable Info getInfo(@NotNull PsiElement psiElement) {
        if (psiElement instanceof PhpClass) {
            AnAction[] actions = new AnAction[2];
            actions[0] = new TesterRunTestAction(psiElement, ((PhpClass) psiElement).getName());
            actions[1] = new TesterCreateRunTestAction(psiElement, ((PhpClass) psiElement).getName());

            return new Info(TesterIcons.RUN_CLASS, actions, RunLineMarkerContributor.RUN_TEST_TOOLTIP_PROVIDER);
        }
        return null;
    }

}