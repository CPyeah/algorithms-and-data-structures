  package leetcode.editor.cn;
  
  /**
   * [155] 最小栈
   */
  public class MinStack{
      public static void main(String[] args) {
           Solution solution = new MinStack().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
type MinStack struct {
  stack []int
  mStack []int
}


func Constructor() MinStack {
  minStack := MinStack{}
  minStack.stack = make([]int, 0)
  minStack.mStack = make([]int, 0)
  return minStack
}


func (this *MinStack) Push(val int)  {
  this.stack = append(this.stack, val)
  if len(this.mStack) == 0 || val <= peek(this.mStack) {
    this.mStack = append(this.mStack, val)
  }
}

func peek(s []int) int{
  return s[len(s)-1]
}

func (this *MinStack) Pop()  {
  v := peek(this.stack)
  this.stack = this.stack[:len(this.stack)-1]
  if v == peek(this.mStack) {
    this.mStack = this.mStack[:len(this.mStack)-1]
  }
}


func (this *MinStack) Top() int {
  return peek(this.stack)
}


func (this *MinStack) GetMin() int {
  return peek(this.mStack)
}


/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

  }