package ArraysAndHashing;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int lastVal = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = lastVal * nums[i];
            lastVal = result[i];
        }
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix * (i + 1 >= nums.length ? 1 : result[i + 1]);
            prefix = prefix * nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3, 3};
        productExceptSelf(nums);
    }
}
