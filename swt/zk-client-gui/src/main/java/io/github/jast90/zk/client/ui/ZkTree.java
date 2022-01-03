package io.github.jast90.zk.client.ui;

import io.github.jast90.swt.component.tree.MyTree;
import io.github.jast90.swt.component.tree.TreeNode;
import io.github.jast90.zk.client.SessionManager;
import io.github.jast90.zk.client.ZkManager;
import org.apache.curator.framework.CuratorFramework;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ZkTree extends MyTree {

    private StyledText text;

    public ZkTree(Composite parent, int style) {
        super(parent, style);
        updateTree();
    }

    public StyledText getText() {
        return text;
    }

    public void setText(StyledText text) {
        this.text = text;
    }

    @Override
    public List<TreeNode> getRootNodes() {
        if(SessionManager.getCurrentConfig() ==null){
            return new ArrayList<>();
        }else{
            return super.getRootNodes();
        }
    }

    @Override
    public List<TreeNode<String>> getTreeNodes(TreeItem root) {
        String path = (String) root.getData();
        List<TreeNode<String>> list = new ArrayList<>();
        CuratorFramework connection = null;
        try {
            connection = ZkManager.getConnection();
            List<String> strings = connection.getChildren().forPath(path);

            TreeNode<String> treeNode;
            for (String string : strings) {
                treeNode = new TreeNode();
                treeNode.setLabel(string);
                treeNode.setData(String.format("%s/%s", Objects.equals("/", path) ? "" : path, string));
                list.add(treeNode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return list;
    }

    @Override
    public String getData4Item(TreeItem root) {
        if (root == null || root.getData() == null) {
            text.setText("");
            return null;
        }
        String path = (String) root.getData();
        CuratorFramework connection = null;
        String str = "";
        try {
            connection = ZkManager.getConnection();
            byte[] bytes = connection.getData().forPath(path);
            if (bytes != null) {
                str = new String(bytes);
            }
            SessionManager.setCurrentPath(path);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        text.setText(str);
        text.setLineJustify(0,1,true);
        return str;
    }

    @Override
    public void deleteNode(TreeItem treeItem) {
        String path = (String) treeItem.getData();
        ConfirmDailog confirmDailog = new ConfirmDailog(getShell(), SWT.NONE,"删除节点",String.format("确定删除节点%s",path),
                new SelectionAdapter(){
            @Override
            public void widgetSelected(SelectionEvent e) {
                CuratorFramework connection = ZkManager.getConnection();
                if(connection!=null){
                    try {
                        connection.delete().forPath(path);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                }
            }
        });
        confirmDailog.open();

    }

    @Override
    public void addNode(TreeItem treeItem) {
        String path = (String) treeItem.getData();
        String prefix = String.format("%s%s", path, Objects.equals("/", path) ? "" : "/");
        NodeAddDialog nodeAddDialog = new NodeAddDialog(getShell(), SWT.NONE, prefix, "添加节点");
        nodeAddDialog.open();
    }
}
