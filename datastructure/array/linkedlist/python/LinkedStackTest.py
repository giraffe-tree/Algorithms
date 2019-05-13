# -*- coding: utf-8 -*-
# @Author : JoinApper
# @data   : 2019/5/13


"""
栈测试
"""

from LinkedStack import LinkedStack


class LinkedStackTest(object):
    def __init__(self):
        self.stack = LinkedStack()

    def _push_pop_test(self):
        """
        push和pop方法测试
        :return: None
        """
        print("push和pop方法测试中....")
        print("栈:", self.stack)
        size = 10
        print("开始push元素%d次" % size)
        for i in range(size):
            self.stack.push(i)
        print("push结束，当前栈为:", self.stack)
        print("当前栈长度为:", len(self.stack))
        print("顶部元素为:", self.stack.top())
        print("开始pop元素%d次" % size)
        for i in range(size):
            self.stack.pop()
        print("pop结束，当前栈为:", self.stack)
        print("当前应该为空:", self.stack.is_empty())

    def run(self):
        """
        执行测试方法
        :return: None
        """
        self._push_pop_test()


if __name__ == "__main__":
    l1 = LinkedStackTest()
    l1.run()
