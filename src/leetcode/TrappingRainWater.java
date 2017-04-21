package leetcode;

import java.util.Arrays;

import tools.P;

public class TrappingRainWater
{
    
    public static void main(String[] args)
    {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        P.lnrint(new TrappingRainWater().trap(a));
        
    }
    
    public int trap(int[] height)
    {
        int len = height.length;
        if (len <= 1)
            return 0;
        int max = 0;
        for (int i : height)
            if (i >= max)
                max = i;
        int water = 0;
        
        for (int i = 1; i <= max; i++)
        {
            int beginIndex = 0;
            // int lastIndex = 0;
            boolean hasBegin = false;
            boolean hasWater = false;
            int tmpWater = 0;
            
            for (int j = 0; j < len; j++)
            {
                if (!hasBegin)
                {
                    if (height[j] >= 1)
                    {
                        beginIndex = j;
                        hasBegin = true;
                    }
                    else
                    {
                        continue;
                    }
                }
                else
                {
                    if (!hasWater)
                    {
                        if (height[j] <= height[beginIndex])
                        {
                            hasWater = true;
                            tmpWater++;
                        }
                        else
                        {
                            beginIndex = j;
                        }
                    }
                    else
                    {
                        if (height[j] >= height[beginIndex])
                        {
                            water += tmpWater;
                            tmpWater = 0;
                            beginIndex = j;
                        }
                    }
                }
            }
        }
        return water;
    }
    
}
