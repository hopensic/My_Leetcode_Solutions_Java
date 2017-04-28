package leetcode;

import tools.P;

public class ZigZagConversion2
{
    private static int globalX;
    
    public static void main(String[] args)
    {
        String s = new ZigZagConversion2().convert("abcdef", 3);
        P.lnrint(s);
    }
    
    public String convert(String s, int numRows)
    {
        if (numRows < 2)
            return s;
        globalX = numRows;
        int len = s.length();
        int t[] = new int[len];
        int index = 0;
        
        int maxStep = globalX * 2 - 2;
        int x = maxStep;
        int y = maxStep - x;
        int z = 0;
        
        boolean isCalculateSingle = true;
        for (int i = 0; i < globalX; i++)
        {
            z = x > y ? x : y;
            int j = i + 1;
            if (j > len)
                continue;
            if (x == 0 || y == 0 || x == y)
                isCalculateSingle = true;
            else
                isCalculateSingle = false;
            if (isCalculateSingle)
            {
                for (; j <= len; j += z)
                    t[index++] = j;
            }
            else
            {
                while (j <= len)
                {
                    if (j > len)
                        break;
                    t[index++] = j;
                    j += x;
                    if (j > len)
                        break;
                    t[index++] = j;
                    j += y;
                    
                }
            }
            x -= 2;
            y += 2;
        }
        char charArray[] = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < globalX; i++)
            sb.append(charArray[t[i]]);
        return sb.toString();
    }
}
