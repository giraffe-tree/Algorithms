# -*- coding: utf-8 -*-
# @Author : JoinApper
# @data   : 2019/5/12

"""
动态数组测试
"""


from DynamicList import DynamicList


class DynamicListTest(object):
    def __init__(self):
        """
        初始化数组
        """
        self.list = DynamicList(10)

    def _append_remove_test(self):
        """
        测试add和remove方法
        :return: None
        """
        print("append与remove方法测试中....")
        print("列表:", self.list)
        for i in range(30):
            self.list.append(i)
        print("执行append方法30次")
        print("列表:", self.list)
        print("索引0处值:", self.list[0])
        for j in range(10):
            self.list.remove(j)
        print("执行remove方法10次")
        print("索引0处值:", self.list[0])
        print("数组长度:", len(self.list))
        print(self.list.is_empty())

    def _get_set_test(self):
        """
        测试get与set方法
        :return: None
        """
        print("\n"+"get与set方法测试中....")
        print("列表:", self.list)
        print("索引0处值:", self.list.get(0))
        self.list.set(1, 20)
        print("执行set方法,索引1处值应该为20:", self.list[1])
        # print(self.list.get(31))

    def _getitem_setitem_test(self):
        """
        getitem和setitem方法测试
        :return: None
        """
        print("\n"+"getitem与setitem方法测试中....")
        print("列表:", self.list)
        print("索引0处值:", self.list[0])
        self.list[1] = 10
        print("执行__setitem__方法,索引1处值应为10:", self.list[1])
        # print(self.list[31])

    def _pop_insert_test(self):
        """
        pop和insert函数测试
        :return:
        """
        print("\n"+"pop与insert方法测试中....")
        print("列表:", self.list)
        for i in range(10):
            self.list.pop(i)
        print("执行pop方法10次")
        print("列表:", self.list)
        for j in range(10):
            self.list.insert(0, j*3)
        print("执行insert方法10次")
        print("列表:", self.list)

    def _list_dynamic_test(self):
        """
        List与dynamicList性能比较
        :return: None
        """
        print("\n"+"List与dynamicList测试中....")
        import time
        list1 = list()
        list2 = DynamicList()
        size = 1000000
        start1 = time.time()
        for i in range(size):
            list1.append(i)
        end1 = time.time()
        print("List cost:", end1 - start1)
        start2 = time.time()
        for j in range(size):
            list2.append(j)
        end2 = time.time()
        print("dynamicList cost:", end2 - start2)

    def _iterator_test(self):
        """
        迭代器测试
        :return: None
        """
        print("\n"+"iter方法测试中....")
        list1 = DynamicList(10)
        for i in range(100):
            list1.append(i)
        print("列表为:", list1)
        for i in list1:
            print(i, end=" ")

    def run(self):
        """
        运行所有测试方法
        :return:
        """
        self._append_remove_test()
        self._pop_insert_test()
        self._get_set_test()
        self._getitem_setitem_test()
        self._list_dynamic_test()
        self._iterator_test()


if __name__ == "__main__":
    t1 = DynamicListTest()
    t1.run()



