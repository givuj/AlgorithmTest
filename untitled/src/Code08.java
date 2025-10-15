import java.util.ArrayList;
import java.util.List;

public class Code08 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        dfs(candidates,target,ans,temp,0);
        return ans;
    }
    public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp,int index)
    {
        if(index == candidates.length)
        {
            return;
        }
        if(target == 0)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0)
        {
            return;
        }

        //选择下一个
        dfs(candidates, target , ans,temp,index+1);
        //还是选择这个
        temp.add(candidates[index]);
        dfs(candidates, target - candidates[index], ans,temp,index);
        temp.remove(temp.size()-1);

    }

}
