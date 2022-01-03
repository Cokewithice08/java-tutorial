package io.github.jast90.zk.client;

import io.github.jast90.swt.component.menu.MenuNode;
import io.github.jast90.swt.component.menu.MyMenu;
import io.github.jast90.zk.client.ui.ConnectDialog;
import io.github.jast90.zk.client.ui.Main;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.ArrayList;
import java.util.List;

public class ZookeeperClient {

    public static void main(String[] args) {
        Display display = Display.getDefault();
        Shell shell = new Shell(display);
//		shell.setLayout(null);
        shell.setText("Zookeeper Client GUI");
        shell.setLayout(new FillLayout(SWT.HORIZONTAL));
        Main main = new Main(shell, SWT.NONE);
        main.pack();

        List<MenuNode> list = new ArrayList<>();
        MenuNode serverMenu = new MenuNode();
        serverMenu.setTitle("服务器");
        List<MenuNode> children = new ArrayList<>();
        MenuNode child = new MenuNode();
        child.setTitle("添加");
        child.setSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ConnectDialog connectDialog = new ConnectDialog(shell, SWT.NONE);
                connectDialog.setMain(main);
                connectDialog.open();
            }

        });
        children.add(child);
        serverMenu.setChildren(children);
        list.add(serverMenu);
        MyMenu myMenu = new MyMenu(list,shell);


        shell.open();
//		shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

}
