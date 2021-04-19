package simple;



/**
 * @author ：Curtain
 * @date ：Created in 2021/4/13 13:53
 * @description：二叉搜索树节点最小距离
 * 示例 1：
 *
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumDistanceBetweenBSTNodes {
    static int pre;
    static int ans;

    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode3);
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode treeNode = new TreeNode(4, treeNode2, treeNode1);
        System.out.println(minDiffInBST(treeNode));
    }
    
    public static int minDiffInBST(TreeNode root){
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    private static void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        if (pre == -1)
            pre = root.val;
        else{
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
    
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
