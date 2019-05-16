# -*- coding: utf-8 -*-
# @Author : JoinApper
# @data   : 2019/5/13 


"""
栈的实现
"""
from Node import Node
from Empty import Empty


class LinkedStack(object):
    def __init__(self):
        """
        创造一个空栈
        """
        self._head = None
        self._size = 0
        self.iter_pointer = None

    def __len__(self):
        """
        返回栈当前长度
        :return: 长度
        """
        return self._size

    def __iter__(self):
        self.iter_pointer = self._head
        return self

    def __next__(self):
        if self.iter_pointer is None:
            raise StopIteration
        else:
            now = self.iter_pointer
            self.iter_pointer = self.iter_pointer.next
            return now.element

    def __str__(self):
        return "["+",".join(str(i) for i in self)+"]"

    def is_empty(self):
        """
        判断栈是否为空
        :return: Bool
        """
        return self._size == 0

    def push(self, e):
        """
        添加节点到栈顶
        :param e: 添加元素
        :return: None
        """
        self._head = Node(e, self._head)
        self._size += 1

    def top(self):
        """
        返回栈顶元素，如果栈为空，抛出异常
        :return: 栈顶元素
        """
        if self.is_empty():
            raise Empty("Stack is empty")
        return self._head.element

    def pop(self):
        """
        移除并且返回栈顶元素
        :return: 栈顶元素
        """
        if self.is_empty():
            raise Empty("Stack is empty")
        answer = self._head.element
        self._head = self._head.next
        self._size -= 1
        return answer

