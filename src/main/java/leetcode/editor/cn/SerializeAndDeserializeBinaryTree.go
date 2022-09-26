  package leetcode.editor.cn;
  
  /**
   * [297] 二叉树的序列化与反序列化
   */
  public class SerializeAndDeserializeBinaryTree{
      public static void main(String[] args) {
           Solution solution = new SerializeAndDeserializeBinaryTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type Codec struct {
    data string
}

func Constructor() Codec {
    return Codec{}
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) string {
  if root == nil {
    return ""
  }
	queue := make([]*TreeNode, 0)
	queue = append(queue, root)
	ans := make([]string, 0)
	for len(queue) != 0 {
		node := queue[0]
		queue = queue[1:]
		if node == nil {
			ans = append(ans, "N")
		} else {
			ans = append(ans, strconv.Itoa(node.Val))
			queue = append(queue, node.Left)
			queue = append(queue, node.Right)
		}
	}
	return strings.Join(ans, ",")
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
  if len(data) == 0 {
    return nil
  }
	arr := strings.Split(data, ",")
	queue := make([]*TreeNode, 0)

	n, _ := strconv.Atoi(arr[0])
	root := &TreeNode{Val: n}
	queue = append(queue, root)
	i := 1
	for len(queue) > 0 {

		node := queue[0]
		queue = queue[1:]

		// left
		if arr[i] != "N" {
			l, _ := strconv.Atoi(arr[i])
			node.Left = &TreeNode{Val: l}
			queue = append(queue, node.Left)
		}

		// right
		if arr[i+1] != "N" {
			r, _ := strconv.Atoi(arr[i+1])
			node.Right = &TreeNode{Val: r}
			queue = append(queue, node.Right)
		}

		i += 2
	}
	return root
}


/**
 * Your Codec object will be instantiated and called as such:
 * ser := Constructor();
 * deser := Constructor();
 * data := ser.serialize(root);
 * ans := deser.deserialize(data);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }