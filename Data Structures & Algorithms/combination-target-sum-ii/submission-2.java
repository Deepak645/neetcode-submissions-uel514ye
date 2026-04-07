class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, target, candidates, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(
        int start,
        int target,
        int[] candidates,
        List<Integer> path,
        List<List<Integer>> result
    ) {

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {

            // 🔑 Skip duplicates at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // Optional pruning (since array is sorted)
            if (candidates[i] > target) break;

            path.add(candidates[i]);
            backtrack(i + 1, target - candidates[i], candidates, path, result);
            path.remove(path.size() - 1);
        }
    }
}
