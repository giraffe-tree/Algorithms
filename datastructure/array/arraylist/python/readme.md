# 动态数组

## 实验部分

文件名：SmallExperiment.py

- 实验1：函数length_compare_size()

  实验目的：探寻List长度与字节数关系

  实验结果：![1557642048766](G:\python\Algorithms\datastructure\array\arraylist\python\LengthBytes.png)

  实验解释：

  1. 从数据上可以看到，空List会预先请求一定数量字节的内存，在实验机上是64个字节；
  2.  从1到4的长度中，内存始终没有扩展，可以推断在增加元素时，List会自动扩展内存， 并且每个元素分配8个字节的内存，实验机为64位内存地址；

- 实验2：append操作时间复杂度

  实验目的：验证将数组以任意几何增长级数扩大，每次操作的摊销运行时间为O(1)

  实验结果：![AppendTime](G:\python\Algorithms\datastructure\array\arraylist\python\AppendTime.png)

  实验解释：动态数组append操作，时间复杂度为O(1)

- 实验3：insert操作时间复杂度

  实验目的：验证insert操作时间复杂度为O(n)

  实验结果：![InsertTime](G:\python\Algorithms\datastructure\array\arraylist\python\InsertTime.png)

  实验分析：动态数组insert操作，时间复杂度为O(n)



## 动态数组构建

文件名：DynamicList.py

### 变量列表：

1. 数组当前元素个数
2. 数组当前容量
3. 数组实际存储形式
4. 迭代器偏移量

### 方法列表：

1. 魔方方法：

   `__len__;__getitem__;__setitem__;__iter__;__next__;__str__`

2. 创建数组：

   `_make_array`

3. 增加元素：

   `append;insert`

4. 删除元素：

   `remove;pop`

5. 获取元素，设置元素：

   `get;set`

6. 检查数组：

   `_check_index;_check_capacity;is_empty`

7. 数组扩容：

   `_resize`

   

## 动态数组测试

- append和remove方法测试
- get和set方法测试
- getitem和setitem方法测试
- pop和insert方法测试
- iterator方法测试
- List与动态数组性能测试



## 不足之处

- 未实现extend方法
- 异常机制不够完善

