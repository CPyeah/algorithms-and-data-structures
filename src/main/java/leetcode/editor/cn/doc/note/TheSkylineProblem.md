type Point struct {
    id int
    x int
    y int
    leftOrRight int // -1 is left, 1 is right
}

维护一个Heap，保存所有的Point
如果是左端点，add， 如果是右端点，remove
更快速获得Heap中的最大y值

把所有point排好序，排序有讲究
优先按x排序
如果x一样，左端点按y逆序，右端点按y顺序

再按照x遍历
如果是左端点，
看当前点的y是不是最大，如果是，输出[x,y]
加入到Heap中

如果是右端点，从Heap中移除对应的左端点。
看点是否大于，Heap中最大的y，
如果是，输出[x, maxY]

