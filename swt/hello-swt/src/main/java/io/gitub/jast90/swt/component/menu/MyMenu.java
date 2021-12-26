package io.gitub.jast90.swt.component.menu;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import java.util.List;

public class MyMenu extends Composite {

    private List<MenuNode> data;

    private Shell shell;

    public MyMenu(Composite parent, int style, List<MenuNode> data, Shell shell) {
        super(parent, style);
        this.data = data;
        this.shell = shell;
        init();
    }

    private void init() {
        Menu bar = new Menu(shell, SWT.BAR);
        shell.setMenuBar(bar);
        for (MenuNode each : data) {
            MenuItem helpItem = new MenuItem(bar, SWT.CASCADE);
            helpItem.setText(each.getTitle());
            Menu submenu = new Menu(shell, SWT.DROP_DOWN);
            helpItem.setMenu(submenu);
            if (each.getChildren() != null && each.getChildren().size() > 0) {
                for (MenuNode child : each.getChildren()) {
                    MenuItem aboutItem = new MenuItem(submenu, SWT.PUSH);
                    aboutItem.setText(child.getTitle());
                }
            }
        }
    }
}
