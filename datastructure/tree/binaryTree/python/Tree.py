# -*- coding: utf-8 -*-
# @Author : JoinApper
# @data   : 2019/5/20


"""
树的基类
"""


class Tree(object):
    # ---------------内部类---------------
    class Position:
        def element(self):
            """
            返回元素存储位置
            :return: 存储位置
            """
            raise NotImplementedError("must be implemented by subclass")

        def __eq__(self, other):
            """
            判断是否相等
            :param other:判别目标
            :return: Bool
            """
            raise NotImplementedError("must be implemented by subclass")

        def __ne__(self, other):
            """
            判别目标不相等
            :param other: 判别目标
            :return: Bool
            """
            return not (self == other)

    def root(self):
        """
        返回树的根结点
        :return: 根节点
        """
        raise NotImplementedError("must be implemented by subclass")

    def parent(self, p):
        """
        返回节点p的父节点
        :param p: 节点p
        :return: 父节点
        """
        raise NotImplementedError("must be implemented by subclass")

    def num_children(self, p):
        """
        返回节点p的子节点数目
        :param p: 节点p
        :return: 子节点数目
        """
        raise NotImplementedError("must be implemented by subclass")

    def children(self, p):
        """"
        返回节点p的子节点
        :param p: 节点p
        :return: 子节点
        """
        raise NotImplementedError("must be implemented by subclass")

    def __len__(self):
        """
        返回树的节点数目
        :return: 节点数目
        """
        raise NotImplementedError("must be implemented by subclass")

    def __iter__(self):
        """
        生成树元素的迭代
        :return: 树元素
        """
        for p in self.positions():
            yield p.element()

    def _subtree_preorder(self, p):
        """
        生成以p为根节点的子树的先序迭代
        :param p: 节点
        :return: 生成器
        """
        yield p
        for c in self.children(p):
            for other in self._subtree_preorder(c):
                yield other

    def preorder(self):
        """
        生成以根节点的子树的先序迭代
        :return: 生成器
        """
        if not self.is_empty():
            for p in self._subtree_preorder(self.root()):
                yield p

    def _subtree_postorder(self, p):
        """
        生成以节点p为根节点的子树的后序遍历
        :param p: 节点
        :return: 生成器
        """
        for c in self.children(p):
            for other in self._subtree_postorder(c):
                yield other
        yield p

    def postorder(self):
        """
        生成以根节点的子树的先序迭代
        :return: 生成器
        """
        if not self.is_empty():
            for p in self._subtree_postorder(self.root()):
                yield p

    def breadthfirst(self):
        """
        生成树的广度遍历迭代
        :return: 生成器
        """
        if not self.is_empty():
            fringe = list()
            fringe.append(self.root())
            while fringe:
                p = fringe.pop(0)
                yield p
                for c in self.children(p):
                    fringe.append(c)

    def positions(self):
        return self.preorder()

    def is_root(self, p):
        """
        判别p是否是树的根节点
        :param p: 节点p
        :return: Bool
        """
        return self.root() == p

    def is_leaf(self, p):
        """
        判别p是否是树的叶子节点
        :param p: 节点p
        :return: Bool
        """
        return self.num_chiledren(p) == 0

    def is_empty(self):
        """
        判别树是否是空的
        :return: Bool
        """
        return len(self) == 0

    def depth(self, p):
        """
        树节点p的深度
        :param p: 节点p
        :return: 节点p的深度
        """
        if self.is_root(p):
            return 0
        else:
            return 1+self.depth(self.parent(p))

    def _height(self, p):
        """
        返回节点p的高度
        :return: 节点p的高度
        """
        if self.is_leaf(p):
            return 0
        else:
            return max(self._height(c) for c in self.children(p))+1

    def height(self, p=None):
        """
        返回节点p的高度，如果节点p没有赋值，默认为树的高度
        :param p: 节点p
        :return: 节点p的高度
        """
        if not p:
            p = self.root()
        return self._height(p)
