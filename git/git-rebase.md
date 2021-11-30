# git rebase使用

## 合并本地分支多次提交
前提本地多次提交未push远程分支

```shell
git rebase -i HEAD~2
```

### 案例
本地有个2个commit：`doc:git rebase 合并多个本地未push的commit 1` 和 `doc:git rebase 合并多个本地未push的commit 2`。
执行如下步骤进行合并多个本地未提交的commit：
1. git rebase
```shell
git rebase -i HEAD~2 
```
2. 执行1后 弹出vi文件内容如下：
```shell
pick 102d48b doc:git rebase 合并多个本地未push的commit 1
pick d2bc7fb doc:git rebase 合并多个本地未push的commit 2

# Rebase 4638274..d2bc7fb onto 4638274 (2 commands)
#
# Commands:
# p, pick <commit> = use commit
# r, reword <commit> = use commit, but edit the commit message
# e, edit <commit> = use commit, but stop for amending
# s, squash <commit> = use commit, but meld into previous commit
# f, fixup [-C | -c] <commit> = like "squash" but keep only the previous
#                    commit's log message, unless -C is used, in which case
#                    keep only this commit's message; -c is same as -C but
#                    opens the editor
# x, exec <command> = run command (the rest of the line) using shell
# b, break = stop here (continue rebase later with 'git rebase --continue')
# d, drop <commit> = remove commit
# l, label <label> = label current HEAD with a name
# t, reset <label> = reset HEAD to a label
# m, merge [-C <commit> | -c <commit>] <label> [# <oneline>]
# .       create a merge commit using the original merge commit's
# .       message (or the oneline, if no original merge commit was
# .       specified); use -c <commit> to reword the commit message
#
# These lines can be re-ordered; they are executed from top to bottom.
#
# If you remove a line here THAT COMMIT WILL BE LOST.
#
# However, if you remove everything, the rebase will be aborted.
#
```

3. 修改2中的内容

将`pick d2bc7fb doc:git rebase 合并多个本地未push的commit 2`改为
`s d2bc7fb doc:git rebase 合并多个本地未push的commit 2`
保存退出`wq`，将会弹出4. 中的commit message 编辑的文件，具体内容如4. 中所示

4. commit message 编辑的文件

```shell
# This is a combination of 2 commits.
# This is the 1st commit message:

doc:git rebase 合并多个本地未push的commit 1

# This is the commit message #2:

doc:git rebase 合并多个本地未push的commit 2

# Please enter the commit message for your changes. Lines starting
# with '#' will be ignored, and an empty message aborts the commit.
#
# Date:      Tue Nov 30 15:10:48 2021 +0800
#
# interactive rebase in progress; onto 4638274
# Last commands done (2 commands done):
#    pick 102d48b doc:git rebase 合并多个本地未push的commit 1
#    squash d2bc7fb doc:git rebase 合并多个本地未push的commit 2
# No commands remaining.
# You are currently rebasing branch 'zhiwen' on '4638274'.
#
# Changes to be committed:
#       modified:   git/git-rebase.md
#
~

```
直接保存退出

5. 经过以上步骤完成多个commit合并
6. 查看提交记录
```shell
$ git log
commit 335d8d0a7f266de259decce9b2d16fea9315e06b (HEAD -> zhiwen)
Author: jast90 <zhangz_w45@163.com>
Date:   Tue Nov 30 15:10:48 2021 +0800

    doc:git rebase 合并多个本地未push的commit 1

    doc:git rebase 合并多个本地未push的commit 2

commit 4638274f5963a3cb47fa8e02484dd9ea98d76a28 (origin/zhiwen)
Author: jast90 <zhangz_w45@163.com>
Date:   Tue Nov 30 14:50:42 2021 +0800

    doc:git rebase usage
```
可以看到多个commit合并成一个commit
