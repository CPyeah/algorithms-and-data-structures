  package leetcode.editor.cn;
  
  /**
   * [208] 实现 Trie (前缀树)
   */
  public class ImplementTriePrefixTree{
      public static void main(String[] args) {
           Solution solution = new ImplementTriePrefixTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
type Trie struct {
  Head *Node
}

type Node struct {
  Val byte
  NextNodes []*Node
  IsEnd bool
}


func Constructor() Trie {
  return Trie{Head: &Node{NextNodes: make([]*Node, 0)}}
}


func (this *Trie) Insert(word string)  {
  p := this.Head
  for i:=0; i<len(word); i++ {
    v := word[i]
    next := findNext(v, p)
    if next == nil {
      next = &Node{Val:v, NextNodes:make([]*Node, 0)}
      p.NextNodes = append(p.NextNodes, next)
    }
    if i == len(word)-1 {
      next.IsEnd = true
    }
    p = next
  }
}

func findNext(t byte, p *Node)*Node {
  if len(p.NextNodes) == 0{
    return nil
  }
  for _,v := range p.NextNodes {
    if v.Val == t {
      return v
    }
  }
  return nil
}


func (this *Trie) Search(word string) bool {
  p := this.Head
  for i:=0; i<len(word); i++ {
    v := word[i]
    next := findNext(v, p)
    if next == nil {
      return false
    }
    p = next
  }
  return p.IsEnd
}


func (this *Trie) StartsWith(prefix string) bool {
  p := this.Head
  for i:=0; i<len(prefix); i++ {
    v := prefix[i]
    next := findNext(v, p)
    if next == nil {
      return false
    }
    p = next
  }
  return true
}


/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }