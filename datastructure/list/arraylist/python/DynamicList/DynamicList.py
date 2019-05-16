# -*- coding: utf-8 -*-
# @Author : JoinApper
# @data   : 2019/5/12

"""
动态数组实现
"""


import ctypes


class DynamicList(object):
    """
    类似于Python中List的动态数组
    """
    def __init__(self, capacity=10):
        """
        创造一个空数组
        """
        self._n = 0
        self._capacity = capacity
        self._A = self._make_array(self._capacity)
        self.iter_index = 0

    def __len__(self):
        """
        返回数组的长度
        :return: 数组长度
        """
        return self._n

    def __getitem__(self, item):
        """
        返回数组索引对应的引用对象
        :param item: 索引
        :return: 引用对象
        """
        # 判断索引是否合法
        # if not 0 <= item < self._capacity:
        #     raise IndexError("非法索引")
        try:
            self._check_index(item)
        except IndexError as e:
            print(e)
        else:
            return self._A[item]

    def __setitem__(self, item, value):
        """
        设置数组指定位置的元素
        :param item: 索引
        :param value: 元素
        :return: None
        """
        try:
            self._check_index(item)
        except IndexError as e:
            print(e)
        else:
            self._A[item] = value

    def __iter__(self):
        """
        重写迭代器方法
        :return: 迭代器
        """
        self.iter_index = 0
        return self

    def __next__(self):
        """
        重写next方法
        :return: 数组元素
        """
        if self.iter_index < self._n:
            self.iter_index += 1
            return self._A[self.iter_index-1]
        else:
            raise StopIteration

    def __str__(self):
        return "["+",".join(map(str, self))+"]"
        # return "["+",".join(self.next())+"]"
        # list1 = []
        # for i in range(self._n):
        #     list1.append(self._A[i])
        # return str(list1)

    def next(self):
        """
        生成器函数
        :return: 生成器
        """
        for i in range(self._n):
            yield str(self._A[i])

    def is_empty(self):
        """
        判断数组是否为空
        :return: 返回布尔值
        """
        return self._n == 0

    def append(self, obj):
        """
        添加元素
        :param obj: 待添加的元素
        :return: None
        """
        # 判断当前是否需要扩容
        # if self._n == self._capacity:
        #     self._resize(2 * self._capacity)
        self._check_capacity()
        self._A[self._n] = obj
        self._n += 1

    def _resize(self, c):
        """
        数组扩容函数
        :param c: 数组扩充容量
        :return: None
        """
        new_list = self._make_array(c)
        for k in range(self._n):
            new_list[k] = self._A[k]
        self._A = new_list
        self._capacity = c

    def insert(self, item, value):
        """
        向数组中指定位置插入指定元素
        :param item: 索引
        :param value: 插入值
        :return: None
        """
        # 判定索引合法性
        # if not 0 <= item < self._capacity:
        #     raise IndexError("非法索引")
        # if self._n == self._capacity:
        #     self._resize(2 * self._capacity)
        self._check_index(item)
        self._check_capacity()
        for j in range(self._n, item, -1):
            self._A[j] = self._A[j - 1]
        self._A[item] = value
        self._n += 1

    def remove(self, value):
        """
        删除值为value的元素
        :param value: 索引
        :return: None
        """
        # 循环找出对应位置
        for i in range(self._n):
            if self._A[i] == value:
                # for j in range(i, self._n-1):
                #     self._A[j] = self._A[j+1]
                # self._A[self._n-1] = None
                # self._n -= 1
                self.pop(i)
                return
        raise ValueError("value not found")

    def pop(self, item):
        """
        删除指定位置的元素
        :param item: 索引
        :return: 索引处的元素
        """
        # 判断索引合法性
        temp = self._A[item]
        self._check_index(item)
        for i in range(item, self._n-1):
            self._A[i] = self._A[i+1]
        self._A[self._n-1] = None
        self._n -= 1
        return temp

    def get(self, item):
        """
        通过索引取得元素
        :param item: 索引
        :return:
        """
        try:
            self._check_index(item)
        except IndexError as e:
            print(e)
        else:
            return self._A[item]

    def set(self, item, value):
        """
        在数组指定位置赋值
        :param item:索引
        :param value:元素值
        :return:
        """
        try:
            self._check_index(item)
        except IndexError as e:
            print(e)
        else:
            self._A[item] = value

    def _check_index(self, item):
        """
        检查索引合法性
        :param item: 索引
        :return:
        """
        if not 0 <= item < self._capacity:
            raise IndexError("非法索引")

    def _check_capacity(self):
        if self._n == self._capacity:
            self._resize(2 * self._capacity)

    def _make_array(self, c):
        """
        利用ctypes模块创建一个容量为c的数组
        :param c: 数组容量
        :return: 数组
        """
        return (c * ctypes.py_object)()
