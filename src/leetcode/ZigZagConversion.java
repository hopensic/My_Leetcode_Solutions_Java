package leetcode;

import tools.P;

public class ZigZagConversion
{
    private static int globalX;
    
    class Pos
    {
        private int x;
        
        private int y;
        
        Pos(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        
        public int getX()
        {
            return x;
        }
        
        public void setX(int x)
        {
            this.x = x;
        }
        
        public int getY()
        {
            return y;
        }
        
        public void setY(int y)
        {
            this.y = y;
        }
    }
    
    public static void main(String[] args)
    {
        String s = new ZigZagConversion().convert("abcdef", 2);
        P.lnrint(s);
    }
    
    public String convert(String s, int numRows)
    {
        if (numRows < 2)
            return s;
        globalX = numRows;
        int tmp = globalX * 2 - 2;
        int singleRow = globalX - 1;
        int len = s.length();
        int finalRows = (int)Math.ceil((double)len / tmp) * singleRow;
        
        char array[][] = new char[finalRows][globalX];
        
        int curX = globalX - 1;
        int curY = 0;
        
        Pos pos = new Pos(curX, curY);
        
        int diretcion = 0;
        
        char charArray[] = s.toCharArray();
        for (char ch : charArray)
        {
            if (diretcion == 0)
            {
                
                diretcion = back(array, ch, pos);
            }
            else
            {
                diretcion = forward(array, ch, pos);
            }
        }
        StringBuilder sb = new StringBuilder();
        char c;
        for (int j = globalX - 1; j >= 0; j--)
            for (int i = 0; i < finalRows; i++)
            {
                c = array[i][j];
                if (c != '\0')
                    sb.append(array[i][j]);
            }
        
        return sb.toString();
    }
    
    private int back(char[][] array, char value, Pos pos)
    {
        int x = pos.getX();
        int y = pos.getY();
        array[y][x] = value;
        pos.setX(--x);
        if (x == 0)
            return 1;
        else
            return 0;
    }
    
    private int forward(char[][] array, char value, Pos pos)
    {
        int x = pos.getX();
        int y = pos.getY();
        array[y][x] = value;
        pos.setX(++x);
        pos.setY(++y);
        if (x == globalX - 1)
            return 0;
        else
            return 1;
    }
    
}
