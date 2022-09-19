双节点DFS
func dfs(node1, node2)bool {
    return dfs(node1.Left, node2.Right) 
        && dfs(node1.Right, node2.Left)
}