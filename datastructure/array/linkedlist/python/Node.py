# -*- coding: utf-8 -*-
# @Author : JoinApper
# @data   : 2019/5/13 


"""
链表节点类
"""


class Node(object):
    """
    链表节点
    """
    __slots__ = 'element', 'next'

    def __init__(self, element, next, prev=None):
        self.element = element
        self.next = next
        self.prev = prev
