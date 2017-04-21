package leetcode;

import tools.P;

public class HouseRobber1
{
    
    public static void main(String[] args)
    {
        int[] a = {1, 3, 4, 5, 2, 9, 7, 1, 2};
        P.lnrint(new HouseRobber1().rob(a));
        
    }
    
    public int rob(int[] nums)
    {
        int len = nums.length;
        return getMax(nums, 0, len - 1);
    }
    
    private int getMax(int[] nums, int left, int right)
    {
        if (right - left > 1)
        {
            int middle = left + ((right - left) / 2);
            return getMax(nums, left, middle) + getMax(nums, middle + 1, right);
        }
        else if (right == left + 1)
        {
            return nums[left] > nums[right] ? nums[left] : nums[right];
        }
        else
        {
            return nums[left];
        }
    }
    
}
