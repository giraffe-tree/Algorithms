# -*- coding: utf-8 -*-
# @Author : JoinApper
# @data   : 2019/5/14


"""
循环队列测试
"""


from CircularQueue import CircularQueue


class CircularQueueTest(object):
    def __init__(self):
        self.queue = CircularQueue()

    def _enqueue_dequeue_test(self):
        """
        enqueue和dequeue方法测试
        :return: None
        """
        print("enqueue和dequeue方法测试中....")
        print("循环队列:", self.queue)
        size = 10
        print("开始enqueue元素%d次" % size)
        for i in range(size):
            self.queue.enqueue(i)
        print("当前第3个元素为", self.queue[2])
        print("enqueue结束，当前循环队列为:", self.queue)
        print("当前循环队列长度为:", len(self.queue))
        print("顶部元素为:", self.queue.first())
        print("开始dequeue元素%d次" % size)
        for i in range(size):
            self.queue.dequeue()
        print("dequeue结束，当前循环队列为:", self.queue)
        print("当前队列应该为空:", self.queue.is_empty())

    def _rotate_test(self):
        """
        rotate方法测试
        :return: None
        """
        print("\n" + "rotate方法测试中....")
        print("添加元素")
        for i in range(10):
            self.queue.enqueue(i)
        print("当前循环列表:", self.queue)
        print("执行rotate方法")
        self.queue.rotate()
        print("当前循环列表:", self.queue)

    def run(self):
        """
        执行测试方法
        :return: None
        """
        self._enqueue_dequeue_test()
        self._rotate_test()


if __name__ == "__main__":
    l1 = CircularQueueTest()
    l1.run()

