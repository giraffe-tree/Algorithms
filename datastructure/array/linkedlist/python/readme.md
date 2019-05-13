# 链表

## 单向链表实现栈

栈实现文件：LinkedStack

栈测试文件：LinkedStackTest

### 变量列表

1. 头指针：`_head`
2. 栈长度：`_size`
3. 迭代器指针：`_iter_pointer`

### 方法列表

1. 魔方方法：

   `__len__;__iter__;__next__;__str__`

2. 增加对象

   `push`：头指针移动到新添加对象，长度加1

3. 删除栈顶对象

   `pop`：判断当前栈是否为空，头指针移动到下一个对象，长度减1

4. 获取栈顶对象

   `top`：判断当前栈是否为空

5. 栈空判断

   `is_empty`

### 方法测试

- pop和push方法测试
- top和is_empty方法测试



## 单向链表实现队列

队列实现文件：LinkedQueue

队列测试文件：LinkedQueueTest

### 变量列表

1. 头指针：`_head`
2. 尾指针：`_tail`
3. 队列长度：`_size`
4. 迭代器指针：`_iter_pointer`

### 方法列表

1. 魔方方法：

   `__len__;__iter__;__next__;__str__`

2. 增加对象

   `enqueue`：需判断当前队列是否为空，头指针和尾指针赋值，长度加1

3. 删除队列首对象

   `dequeue`：判断当前队列是否为空，头指针和尾指针赋值，长度减1

4. 获取队列首对象

   `first`：判断当前队列是否为空

5. 队列空判断

   `is_empty`

### 方法测试

- enqueue和dequeue方法测试
- first和is_empty方法测试