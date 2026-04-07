class Solution {
    Set<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        result=new HashSet<>();
        helper(0,target,candidates,new ArrayList());
        return new ArrayList(result);

        
    }

    public void helper(int ind,int target,int[] candidates,ArrayList<Integer> arr){

       
        if(target==0) {result.add(new ArrayList<>(arr));};
         if(target<0||ind>=candidates.length) return;
        arr.add(candidates[ind]);
        helper(ind+1,target-candidates[ind],candidates,arr);
        arr.remove(arr.size()-1);

        helper(ind+1,target,candidates,arr);

        return ;

    }
}
