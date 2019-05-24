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

    def _subtree_inorder(self, p):
        """"
        生成以节点p为根节点的子树的中序遍历
        :param p: 节点
        :return: 生成器
        """
        if self.left(p):
            # self._subtree_inorder(self.left(p))
            for other in self._subtree_inorder(self.left(p)):
                yield other
        yield p
        if self.right(p):
            # self._subtree_inorder(self.right(p))
            for other in self._subtree_inorder(self.right(p)):
                yield other

    def inorder(self):
        """
        生成以根节点的子树的中序迭代
        :return: 生成器
        """
        if not self.is_empty():
            for p in self._subtree_inorder(self.root()):
                yield p

    def positions(self):
        # 可以调用其它遍历方法
        # return self.postorder()
        return self.inorder()
