# -*- coding: utf-8 -*-
# @Author : JoinApper
# @data   : 2019/5/12 

"""
进行一些python内置数据结构的实验
"""


class Experiment(object):
    def __init__(self):
        pass

    @classmethod
    def length_compare_size(cls):
        """
        比较列表长度和字节大小的关系
        :return: None
        """
        import sys
        data = []
        for k in range(30):
            a = len(data)
            b = sys.getsizeof(data)
            print('Length:{0:3d}; Size in bytes:{1:4d}'.format(a, b))
            data.append(None)

    @classmethod
    def compute_append_average(cls, n):
        """
        在空数组中n次添加操作所需要的时间
        :param n: 添加操作次数
        :return: 单次操作所需时间
        """
        from time import time
        data = []
        start = time()
        for k in range(n):
            data.append(None)
        end = time()
        return (end - start)/n

    @classmethod
    def compute_insert_average(cls, n):
        """
        在数组中n次插入操作所需要的时间
        :param n: 插入操作次数
        :return: 单次操作所需时间
        """
        from time import time
        data = []
        start = time()
        for k in range(n):
            data.insert(k//2, None)
        end = time()
        return (end - start)/n

    @classmethod
    def plot_time(cls, fun):
        """
        描绘单次操作时间随操作次数的变化趋势
        :return: None
        """
        from matplotlib import pyplot as plt
        time_list = []
        append_nums = [10**k for k in range(1, 6)]
        for i in range(len(append_nums)):
            time_list.append(fun(append_nums[i]))
        print(time_list)
        plt.plot(append_nums, time_list)
        plt.show()

    @classmethod
    def run(cls):
        """
        运行实验函数
        :return: None
        """
        # cls.length_compare_size()
        cls.plot_time(cls.compute_insert_average)


if __name__ == "__main__":
    Experiment.run()
