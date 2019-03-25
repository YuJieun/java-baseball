import java.util.*;

public class Main {
    public static void main(String[] args) {

          int[] num;
          int[] player;
          int[] result;

          while(true){
              num = makeNumber();
              while(true){
                  player = playerNumber();
                  result = result(num,player);
                  if(result[0]==0 && result[1]==0){
                      System.out.println("낫싱");
                  }
                  else if(result[0]==0) {
                      System.out.printf("%d볼\n",result[1]);
                  }
                  else if(result[1]==0) {
                      System.out.printf("%d스트라이크\n",result[0]);
                      if(result[0]==3){
                          System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                          break;
                      }
                  }
                  else{
                      System.out.printf("%d스트라이크 %d볼\n",result[0], result[1]);
                  }
              }
              System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
              Scanner sc = new Scanner(System.in);
              int tmp = sc.nextInt();
              if(tmp == 1)
                  ;
              else if(tmp ==2)
                  break;
          }
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
        System.out.print("숫자를 입력해주세요 : ");
        int num = sc.nextInt();
        for(int i=temp.length-1;i>=0;i--)
        {
            temp[i] = num%10;
            num = num/10;
        }
        return temp;
    }
    public static int[] result(int[] num, int[] player){
        int result[] = new int[2];
        //result[0] : 스트라이크, result[1] : 볼
        for(int i=0; i<3; i++){
            if(num[i]==player[i])
                result[0] += 1;
            else{
                for(int j=0;j<num.length;j++){
                    if(player[i] == num[j]){
                        result[1] += 1;
                        break;
                    }
                }
            }
        }
        return result;
    }
}

