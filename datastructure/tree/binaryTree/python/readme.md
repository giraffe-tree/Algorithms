# 树

## 树

树实现文件：Tree

### 内部类

- Position

  方法列表：

  1. 元素存储位置：`element`
  2. 当前位置对应对象与目标对象等或不等：`__eq__`,`__ne__`

### 方法列表(只定义了方法名，继承类具体实现)：

1. 树根节点：`root`
2. 父亲节点：`parent`
3. 孩子数目：`num_chiledren`
4. 孩子节点：`children` 
5. 判断型方法：`is_root`,`is_leaf`,`is_empty`
6. 树的高度，深度：`height`,`depth`

## 二叉树(继承树类)

二叉树实现文件：BinaryTree

### 变量列表

1. 树根节点：`_root`
2. 树节点个数：`_size`

### 方法列表

1. 左孩子节点：`left`
2. 右孩子节点：`right`
3. 兄弟节点：`sibling`
4. 孩子节点：`children` 采用yield方式

## 链表二叉树(继承二叉树)

链表二叉树实现文件：LinkedBinaryTree

### 内部类

- _Node

  变量列表：`element,parent,left,right`

- Position(继承二叉树的内部类Position)

  变量列表：`container,node`

  方法列表：`element,__eq__`

### 方法列表：

1. 继承方法重写：`root,parent,left,right,num_children`
2. 特殊方法：`_validate,_make_position`
3. 节点添加方法：`_add_root,_add_left,_add_right,add`
4. 元素值替代：`_replace,replace`
5. 节点删除：`_delete,delete`  没有考虑两个孩子的情况，后续会增加
6. 树的连接：`_attach`

