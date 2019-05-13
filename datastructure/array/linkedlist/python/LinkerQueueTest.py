# -*- coding: utf-8 -*-
# @Author : JoinApper
# @data   : 2019/5/13


"""
队列测试
"""


from LinkedQueue import LinkedQueue


class LinkedQueueTest(object):
    def __init__(self):
        self.queue = LinkedQueue()

    def _enqueue_dequeue_test(self):
        """
        enqueue和dequeue方法测试
        :return: None
        """
        print("enqueue和dequeue方法测试中....")
        print("队列:", self.queue)
        size = 10
        print("开始enqueue元素%d次" % size)
        for i in range(size):
            self.queue.enqueue(i)
        print("push结束，当前队列为:", self.queue)
        print("当前队列长度为:", len(self.queue))
        print("顶部元素为:", self.queue.first())
        print("开始dequeue元素%d次" % size)
        for i in range(size):
            self.queue.dequeue()
        print("dequeue结束，当前队列为:", self.queue)
        print("当前应该为空:", self.queue.is_empty())

    def run(self):
        """
        执行测试方法
        :return: None
        """
        self._enqueue_dequeue_test()


if __name__ == "__main__":
    l1 = LinkedQueueTest()
    l1.run()
