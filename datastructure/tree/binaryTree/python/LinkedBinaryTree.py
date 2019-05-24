# -*- coding: utf-8 -*-
# @Author : JoinApper
# @data   : 2019/5/20 


"""
二叉树具体实现
"""


from BinaryTree import BinaryTree


class LinkedBinaryTree(BinaryTree):

    class _Node:
        __slots__ = 'element', 'parent', 'left', 'right'

        def __init__(self, element, parent=None, left=None, right=None):
            self.element = element
            self.parent = parent
            self.left = left
            self.right = right

    class Position(BinaryTree.Position):
        def __init__(self, container, node):
            self.container = container
            self.node = node

        def element(self):
            """
            返回当前位置的元素
            :return: 元素
            """
            return self.node.element

        def __eq__(self, other):
            return type(other) is type(self) and other.node is self.node

    def __init__(self):
        self._root = None
        self._size = 0

    def __len__(self):
        return self._size

    def root(self):
        return self._make_position(self._root)

    def parent(self, p):
        """
        返回位置p父节点的位置实例
        :return: 位置实例
        """
        node = self._validate(p)
        return self._make_position(node.parent)

    def left(self, p):
        """
        返回位置p的左节点位置实例
        :param p: 位置p
        :return: 左节点位置实例
        """
        node = self._validate(p)
        return self._make_position(node.left)

    def right(self, p):
        """
        返回位置p右节点的位置实例
        :param p: 位置p
        :return: 右节点位置实例
        """
        node = self._validate(p)
        return self._make_position(node.right)

    def num_children(self, p):
        """
        返回位置p的子节点数目
        :param p: 位置p
        :return: 子节点数目
        """
        node = self._validate(p)
        count = 0
        if node.left:
            count += 1
        if node.right:
            count += 1
        return count

    def _validate(self, p):
        """
        如果位置是合法的，返回位置相关联的节点
        :param p: 位置实例p
        :return: 相关联的节点
        """
        if not isinstance(p, self.Position):
            raise TypeError("p must be proper Position type")
        if p.container is not self:
            raise ValueError("p does not belong to this container")
        if p.node.parent is p.node:
            raise ValueError("p is not longer valid")
        return p.node

    def _make_position(self, node):
        """
        返回给定节点的位置实例
        :param node: 节点node
        :return: 位置实例
        """
        return self.Position(self, node) if node is not None else None

    def _add_root(self, e):
        """
        给一颗空树增加根节点，其节点元素为e
        :param e: 节点元素
        :return: 根节点位置实例
        """
        if self._root is not None:
            raise ValueError("Root exists")
        else:
            self._size = 1
            self._root = self._Node(e)
            return self._make_position(self._root)

    def _add_left(self, p, e):
        """
        对于位置实例p，添加一个左子节点，其元素值为e
        :param p: 位置实例p
        :param e: 新节点的元素e
        :return: 新节点的位置实例
        """
        node = self._validate(p)
        if node.left is not None:
            raise ValueError("Left child exists")
        self._size += 1
        node.left = self._Node(e, node)
        return self._make_position(node.left)

    def _add_right(self, p, e):
        """
        对于位置实例p，添加一个右子节点，其元素值为e
        :param p: 位置实例p
        :param e: 新节点的元素e
        :return: 新节点的位置实例
        """
        node = self._validate(p)
        if node.right is not None:
            raise ValueError("right child exists")
        self._size += 1
        node.right = self._Node(e, node)
        return self._make_position(node.right)

    def add(self, flag, e, p=None):
        """
        公开的添加函数
        :param flag: 0代表root节点，1代表左节点，2代表右节点
        :param e: 节点元素
        :param p: 指定节点
        :return: 新节点位置实例
        """
        if flag == 0:
            # 调用_add_root方法
            return self._add_root(e)
        elif flag == 1:
            # 调用_add_left方法
            return self._add_left(p, e)
        elif flag == 2:
            # 调用_add_right方法
            return self._add_right(p, e)

    def _replace(self, p, e):
        """
        位置实例p的关联节点元素替换成e
        :param p: 位置实例
        :param e: 替换元素
        :return: 被替换元素
        """
        node = self._validate(p)
        old = node.element
        node.element = e
        return old

    def replace(self, p, e):
        return self._replace(p, e)

    def _delete(self, p):
        """
        删除位置实例p处的节点
        :param p: 位置实例
        :return: 被删除节点的元素
        """
        node = self._validate(p)
        if self.num_children(p) == 2:
            raise ValueError("p has two children")
        child = node.left if node.left is not None else node.right
        if child is not None:
            child.parent = node.parent
        if node is self._root:
            self._root = child
        else:
            parent = node.parent
            if node is parent.left:
                parent.left = child
            else:
                parent.right = child
        self._size -= 1
        node.parent = node
        return node.element

    def delete(self, p):
        return self._delete(p)

    def _attach(self, p, t1, t2):
        """
        将树t1和树t2分别链接为叶子结点p的左右子树
        :param p: 叶子结点
        :param t1: 左树
        :param t2: 右树
        :return:
        """
        node = self._validate(p)
        if not self.is_leaf(p):
            raise ValueError("position must be leaf")
        if not type(self) is type(t1) is type(t2):
            raise ValueError("Tree types must match")
        self._size += len(t1) + len(t2)
        if not t1.is_empty():
            t1._root.parent = node
            node.left = t1._root
            t1._root = None
            t1._size = 0
        if not t2.is_empty():
            t2._root.parent = node
            node.right = t2._root
            t2._root = None
            t2._size = 0

    def attach(self, p, t1, t2):
        self._attach(p, t1, t2)


