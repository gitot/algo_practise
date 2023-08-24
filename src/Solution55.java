public class Solution55 {
    public boolean canJump(int[] nums) {
        boolean[] canReach = new boolean[nums.length];
        canReach[0] = true;
        for(int i = 0; i < nums.length; i++){
            if(!canReach[i]) continue;
            for(int j = 1; j <= nums[i] && j + i < nums.length; j++){
                if (!canReach[j + i]) {
                    canReach[j + i] = true;
                }
            }
        }
        return canReach[nums.length-1];
    }

    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        boolean b = solution55.canJump(new int[]{2, 5, 0, 0});
        System.out.println(b);

    }
}
