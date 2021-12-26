package io.gitub.jast90.swt.basic.menu;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class Menus {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Redis 客户端");
        shell.open();

        createMenu(shell);

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    private static void createMenu(Shell shell){
        Menu bar = new Menu(shell, SWT.BAR);
        shell.setMenuBar(bar);
        createSeverMenu(shell,bar);
        createHelpMenu(shell,bar);
    }

    private static void createHelpMenu(Shell shell,Menu bar){
        MenuItem helpItem = new MenuItem(bar, SWT.CASCADE);
        helpItem.setText("&帮助");
        Menu submenu = new Menu(shell, SWT.DROP_DOWN);
        helpItem.setMenu(submenu);

        MenuItem aboutItem = new MenuItem(submenu, SWT.PUSH);
        aboutItem.addListener(SWT.Selection,e->{
            System.out.println("关于");
        });
        aboutItem.setText("关于");
    }


    private static void createSeverMenu(Shell shell,Menu bar){
        MenuItem serverItem = new MenuItem(bar, SWT.CASCADE);
        serverItem.setText("&服务器");

        Menu submenu = new Menu(shell, SWT.DROP_DOWN);
        serverItem.setMenu(submenu);

        MenuItem addItem = new MenuItem(submenu, SWT.PUSH);
        addItem.addListener(SWT.Selection,e->{
            System.out.println("添加");
        });
        addItem.setText("添加");
        addItem.setAccelerator(SWT.MOD1+'N');

        MenuItem updateItem = new MenuItem(submenu, SWT.PUSH);
        updateItem.addListener(SWT.Selection,e->{
            System.out.println("修改");
        });
        updateItem.setText("修改");
        updateItem.setAccelerator(SWT.MOD1+'U');

        MenuItem deleteItem = new MenuItem(submenu, SWT.PUSH);
        deleteItem.addListener(SWT.Selection,e->{
            System.out.println("删除");
        });
        deleteItem.setText("删除");
        deleteItem.setAccelerator(SWT.MOD1+'D');

        MenuItem viewItem = new MenuItem(submenu, SWT.PUSH);
        viewItem.addListener(SWT.Selection,e->{
            System.out.println("查看");
        });
        viewItem.setText("查看");
        viewItem.setAccelerator(SWT.MOD1+'V');

        MenuItem quitItem = new MenuItem(submenu, SWT.PUSH);
        quitItem.addListener(SWT.Selection,e->{
            System.out.println("退出");
            shell.dispose();
        });
        quitItem.setText("退出");
        quitItem.setAccelerator(SWT.MOD1+'E');
    }
}
