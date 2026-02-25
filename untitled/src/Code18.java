public class Code18 {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
      public int sumRootToLeaf(TreeNode root) {
            return  DFS(root,0);
      }
      public int DFS(TreeNode nood, int current)  {
          if(nood == null) return 0;
          current =current*2 + nood.val;
          if(nood.left == null && nood.right == null) {
              return current;
          }
          return DFS(nood.left,current) + DFS(nood.right,current);
      }

}
