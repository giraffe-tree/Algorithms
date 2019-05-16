# -*- coding: utf-8 -*-
# @Author : JoinApper
# @data   : 2019/5/14


"""
管理双向链表的基本类
"""

from Node import Node


class _DoublyLinkedBase(object):
    def __init__(self):
        self._head = Node(None, None, None)
        self._tail = Node(None, None, None)
        self._head.next = self._tail
        self._tail.prev = self._head
        self._size = 0

    def __len__(self):
        """
        返回双向链表的长度
        :return: 长度
        """
        return self._size

    def is_empty(self):
        """
        判断双向链表是否为空
        :return: Bool
        """
        return self._size == 0

    def _insert_between(self, e, predecessor, successor):
        """
        给定前驱，后继，插入元素
        :param e: 元素
        :param predecessor:前驱
        :param successor: 后继
        :return: 插入节点
        """
        newest = Node(e, predecessor, successor)
        predecessor.next = newest
        successor.prev = newest
        self._size += 1
        return newest

    def _delete_node(self, node):
        """
        删除指定节点，返回该节点元素值
        :param node: 需删除节点
        :return: 节点元素值
        """
        predecessor = node.prev
        successor = node.next
        predecessor.next = successor
        successor.prev = predecessor
        self._size -= 1
        element = node.element
        node.prev = node.next = node.element = None
        return element


