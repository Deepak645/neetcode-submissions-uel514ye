class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();

        // 1 - max
        int left = 1, right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int totalH = 0;
            for (int i = 0; i < piles.length; i++) {
                totalH += (piles[i]+mid-1)/mid;
            }

            if (totalH <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
