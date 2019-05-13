# -*- coding: utf-8 -*-
# @Author : JoinApper
# @data   : 2019/5/13


"""
队列的实现
"""


from Node import Node
from Empty import Empty


class LinkedQueue(object):
    def __init__(self):
        """
        创建一个空队列
        """
        self._head = None
        self._tail = None
        self._size = 0
        self.iter_pointer = None

    def __len__(self):
        """
        返回队列长度
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
        判断队列是否为空
        :return: Bool
        """
        return self._size == 0

    def first(self):
        """
        取得第一个元素
        :return: 第一个元素
        """
        if self.is_empty():
            raise Empty("Queue is empty")
        return self._head.element

    def dequeue(self):
        """
        移除并且返回第一个元素
        :return:第一个元素
        """
        if self.is_empty():
            raise Empty("Queue is empty")
        answer = self._head.element
        self._head = self._head.next
        self._size -= 1
        if self.is_empty():
            self._tail = None
        return answer

    def enqueue(self, e):
        """
        添加一个元素到队列
        :return: None
        """
        newest = Node(e, None)
        if self.is_empty():
            self._head = newest
        else:
            self._tail.next = newest
        self._tail = newest
        self._size += 1
