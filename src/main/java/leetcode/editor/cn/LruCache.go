  package leetcode.editor.cn;
  
  /**
   * [146] LRU 缓存
   */
  public class LruCache{
      public static void main(String[] args) {
           Solution solution = new LruCache().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
type LRUCache struct {
  capacity int
  size int
  dict map[int]*Node
  head *Node
  tail *Node
}

type Node struct {
  Key int
  Val int
  Next *Node
  Prev *Node
}


func Constructor(capacity int) LRUCache {
  cache := LRUCache{capacity:capacity, dict:make(map[int]*Node)}
  headNode := &Node{}
  tailNode := &Node{}
  headNode.Next = tailNode
  tailNode.Prev = headNode
  cache.head = headNode
  cache.tail = tailNode
  return cache
}


func (this *LRUCache) Get(key int) int {
  n, ok := this.dict[key]
  if !ok {
    return -1
  }
  // remove node from origin place
  n.Prev.Next = n.Next
  n.Next.Prev = n.Prev

  // add to the head
  top1 := this.head.Next
  this.head.Next, n.Prev = n, this.head
  n.Next, top1.Prev = top1, n
  return n.Val
}


func (this *LRUCache) Put(key int, value int)  {
  n, ok := this.dict[key]
    if ok {
      this.dict[key].Val = value
      this.Get(key)
      return
    }
    n = &Node{Key:key, Val: value}
    this.dict[key] = n
    // add to the head
    top1 := this.head.Next
    this.head.Next, n.Prev = n, this.head
    n.Next, top1.Prev = top1, n
    if this.size == this.capacity {
      // remove tailNode
      n = this.tail.Prev
      n.Prev.Next = n.Next
      n.Next.Prev = n.Prev
      delete(this.dict, n.Key)
    } else {
      this.size ++
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }