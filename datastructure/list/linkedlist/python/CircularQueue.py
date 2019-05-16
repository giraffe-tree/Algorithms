# -*- coding: utf-8 -*-
# @Author : JoinApper
# @data   : 2019/5/14


"""
循环链表实现循环队列
"""


from Node import Node
from Empty import Empty


class CircularQueue(object):
    def __init__(self):
        self._tail = None
        self._size = 0
        self.iter_pointer = 0

    def __len__(self):
        """
        返回当前循环队列的长度
        :return: 长度
        """
        return self._size

    def __getitem__(self, item):
        """
        获取指定索引的元素
        :param item: 索引
        :return: 元素
        """
        if item >= self._size:
            raise IndexError("Index is valid")
        current = self._tail
        for i in range(item+1):
            current = current.next
        return current.element

    def __iter__(self):
        self.iter_pointer = 0
        return self

    def __next__(self):
        if self.iter_pointer >= self._size:
            raise StopIteration
        else:
            self.iter_pointer += 1
            return self[self.iter_pointer - 1]

    def __str__(self):
        return "["+",".join(str(i) for i in self)+"]"

    def is_empty(self):
        """
        判断当前循环队列是否为空
        :return: Bool
        """
        return self._size == 0

    def first(self):
        """
        返回循环队列的首元素
        :return: 首元素
        """
        # 判断循环队列是否为空
        if self.is_empty():
            raise Empty("Queue is empty")
        head = self._tail.next
        return head.element

    def dequeue(self):
        """
        移除队列首元素
        :return:队列首元素
        """
        if self.is_empty():
            raise Empty("Queue is empty")
        oldhead = self._tail.next
        if self._size == 1:
            self._tail = None
        else:
            self._tail.next = oldhead.next
        self._size -= 1
        return oldhead.element

    def enqueue(self, e):
        """
        增添元素
        :return:None
        """
        newest = Node(e, None)
        # print(newest.element)
        if self.is_empty():
            newest.next = newest
        else:
            newest.next = self._tail.next
            self._tail.next = newest
        self._tail = newest
        self._size += 1

    def rotate(self):
        """
        旋转首元素到队列末尾
        :return: None
        """
        if self._size > 0:
            self._tail = self._tail.next





