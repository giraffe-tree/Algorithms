# -*- coding: utf-8 -*-
# @Author : JoinApper
# @data   : 2019/5/24


"""
链式二叉树测试
"""


from LinkedBinaryTree import LinkedBinaryTree


class LinkedBinaryTreeTest(object):
    def __init__(self, elements):
        self.elements = elements
        self.tree = LinkedBinaryTree()  # 初始化一颗空树

    def _add_nodes_test(self):
        # 节点添加方法测试
        print("节点添加方法测试中--------")
        print("当前树的根结点为：", self.tree.root())
        print("添加根节点")
        self.tree.add(0, self.elements.pop(0))
        print("当前树的根结点为：", self.tree.root())
        print("添加剩余元素--------")
        queue = list()
        queue.append(self.tree.root())
        while self.elements:
            # 添加左边元素
            newNode = queue.pop(0)
            self.tree.add(1, self.elements.pop(0), newNode)
            queue.append(self.tree.left(newNode))
            if self.elements:
                self.tree.add(2, self.elements.pop(0), newNode)
                queue.append(self.tree.right(newNode))
        # 调用其迭代方法
        print("打印整棵树，调用中序遍历--------")
        for element in self.tree:
            print(element, end=" ")

    def _add_nodes_test(self):
        # 节点添加方法测试
        print("节点添加方法测试中--------")
        print("当前树的根结点为：", self.tree.root())
        print("添加根节点")
        self.tree.add(0, self.elements.pop(0))
        print("当前树的根结点为：", self.tree.root())
        print("添加剩余元素--------")
        queue = list()
        queue.append(self.tree.root())
        while self.elements:
            # 添加左边元素
            newNode = queue.pop(0)
            self.tree.add(1, self.elements.pop(0), newNode)
            queue.append(self.tree.left(newNode))
            if self.elements:
                self.tree.add(2, self.elements.pop(0), newNode)
                queue.append(self.tree.right(newNode))
        # 调用其迭代方法
        print("打印整棵树，调用中序遍历--------")
        for element in self.tree:
            print(element, end=" ")

    def _replace_delete_test(self):
        # 节点元素替代/删除方法测试
        print("节点元素替代方法测试--------")
        self.tree.replace(self.tree.root(), 9)
        print("当前树的根节点为9：", self.tree.root().element())
        print("节点元素删除方法测试--------")
        self.tree.delete(self.tree.right(self.tree.left(self.tree.root())))
        print("当前树删除节点5")
        for element in self.tree:
            print(element, end=" ")

    def run(self):
        self._add_nodes_test()
        self._replace_delete_test()


if __name__ == "__main__":
    elements = [1, 2, 3, 4, 5, 6, 7, 8]
    l = LinkedBinaryTreeTest(elements)
    l.run()



