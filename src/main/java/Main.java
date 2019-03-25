import java.util.*;

public class Main {
    public static void main(String[] args) {

          int[] num = new int[3];
          int[] player = new int[3];
          num = makeNumber();
          player = playerNumber();
          
    }

    public static int[] makeNumber()
    {
        int temp[] = new int[3];
        for(int i=0;i<temp.length;i++)
        {
            temp[i]  = (int)(Math.random()*9)+1;
            for ( int j = 0; j < i; j++ ){
                if( temp[i] == temp[j] ){
                    i--;
                }
            }
        }
        return temp;
    }

    public static int[] playerNumber()
    {
        int temp[] = new int[3];
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=temp.length-1;i>=0;i--)
        {
            temp[i] = num%10;
            num = num/10;
        }
        return temp;
    }
}

