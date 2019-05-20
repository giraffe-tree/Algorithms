# -*- coding: utf-8 -*-
# @Author : JoinApper
# @data   : 2019/5/20 


"""
二叉树的定义
"""


from Tree import Tree


class BinaryTree(Tree):
    def left(self, p):
        """
        返回节点p的左子节点，如果没有返回None
        :param p: 节点p
        :return: 左子节点
        """
        raise NotImplementedError("must be implemented by subclass")

    def right(self, p):
        """
        返回节点p的右子节点，如果没有返回None
        :param p: 节点p
        :return: 右子节点
        """
        raise NotImplementedError("must be implemented by subclass")

    def sibling(self, p):
        """
        返回节点p的兄弟节点
        :param p: 节点p
        :return: 兄弟节点
        """
        parent = self.parent(p)
        if parent is None:
            return None
        else:
            if p == self.left(parent):
                return self.right(parent)
            else:
                return self.left(parent)

    def children(self, p):
        """
        生成节点p的孩子节点迭代
        :return: 生成节点p的孩子节点
        """
        if self.left(p):
            yield self.left(p)
        if self.right(p):
            yield self.right(p)
