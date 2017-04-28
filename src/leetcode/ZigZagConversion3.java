package leetcode;

import tools.P;

public class ZigZagConversion3
{
    
    public static void main(String[] args)
    {
        String s = new ZigZagConversion3().convert("abcdef", 3);
        P.lnrint(s);
    }
    
    public String convert(String s, int numRows)
    {
        if (numRows < 2)
            return s;
        char charArray[] = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        
        int maxStep = numRows * 2 - 2;
        int x = maxStep;
        int y = maxStep - x;
        int z = 0;
        
        boolean isCalculateSingle = true;
        for (int i = 0; i < numRows; i++)
        {
            z = x > y ? x : y;
            int j = i;
            if (j >= len)
                continue;
            if (x == 0 || y == 0 || x == y)
                isCalculateSingle = true;
            else
                isCalculateSingle = false;
            if (isCalculateSingle)
            {
                for (; j < len; j += z)
                    sb.append(charArray[j]);
            }
            else
            {
                while (j < len)
                {
                    if (j >= len)
                        break;
                    sb.append(charArray[j]);
                    j += x;
                    if (j >= len)
                        break;
                    sb.append(charArray[j]);
                    j += y;
                    
                }
            }
            x -= 2;
            y += 2;
        }
        return sb.toString();
    }
}
