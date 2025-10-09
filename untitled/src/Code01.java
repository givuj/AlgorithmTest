//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Code01 {
     public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right)
        {
          this.val = val;
          this.left = left;
          this.right = right;
        }
  }
    public static class ReturnType1{
         public int uncovered;
         public int coveredNoCamera;
         public int coveredHasCamera;
         public ReturnType1(int un,int no,int has) {
                uncovered = un;
                coveredNoCamera = no;
                coveredHasCamera = has;
         }
    }
    public static ReturnType1 process(TreeNode x) {
         if(x==null)
         {
             return new ReturnType1(100, 0, 100);
         }
         ReturnType1 left = process(x.left);
         ReturnType1 right = process(x.right);
         int uncovered = left.coveredNoCamera+right.coveredNoCamera;
         int coveredNoCamera = Math.min(left.coveredHasCamera+ right.coveredHasCamera,
                 Math.min(left.coveredHasCamera+right.coveredNoCamera,left.coveredNoCamera+right.coveredHasCamera));
         int coverdHasCamera =  Math.min(left.uncovered,
                                        Math.min(left.coveredHasCamera,left.coveredNoCamera))+
                                Math.min(right.uncovered,
                                        Math.min(right.coveredNoCamera,right.coveredHasCamera))
                                +1;
         return  new ReturnType1(uncovered,coveredNoCamera,coverdHasCamera);

    }
    public static int minCameraCover(TreeNode root)
    {
        ReturnType1 ans = process(root);
        return Math.min(ans.uncovered+1,Math.min(ans.coveredNoCamera,ans.coveredHasCamera));
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
         node.left = new TreeNode(0);
         node.left.left = new TreeNode(0);
         node.left.right = new TreeNode(0);
        System.out.println(minCameraCover(node));

    }
}