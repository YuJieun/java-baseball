import java.util.*;

public class Main {

    public static void playgame(){
        /* 게임진행 함수*/
        int[] num;
        int[] player;
        int[] result;

        num = makeNumber();
        while(true){
            player = playerNumber();
            result = result(num,player);
            if(result[0]==0 && result[1]==0){
                System.out.println("낫싱");
            }
            else if(result[0]==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            else if(result[1]==0) {
                System.out.printf("%d스트라이크\n",result[0]);
            }
            else if(result[0]==0) {
                System.out.printf("%d볼\n",result[1]);
            }
            else{
                System.out.printf("%d스트라이크 %d볼\n",result[0], result[1]);
            }
        }
        return;
    }

    public static int[] makeNumber()
    {
        /* 난수 생성 함수 */
        int temp[] = new int[3];
        for(int i=0;i<temp.length;i++)
        {
            temp[i]  = (int)(Math.random()*9)+1;
            if(checkDuplicate(temp[i], temp, i))
                i--;
        }
        return temp;
    }

    public static boolean checkDuplicate(int num, int[] arr, int pos){
        /* 난수 중복검사 함수 */

        for ( int j = 0; j < pos; j++ ){
            if( num == arr[j] ){
                return true;
            }
        }
        return false;
    }

    public static int[] playerNumber() {
        /*  플레이어에게 숫자를 입력받는 함수 */

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
        /* 게임 결과 함수 */

        int result[] = new int[2];
        //result[0] : 스트라이크, result[1] : 볼
        for(int i=0; i<3; i++){
            if(num[i]==player[i])
                result[0] += 1;
            else{
                result[1] += checkBall(player[i], num);
            }
        }
        return result;
    }

    public static int checkBall(int num, int[] numbers){
        /* 볼이 몇개인지 카운트하는 함수 */

        for(int i=0; i<numbers.length; i++){
            if(num == numbers[i])
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
          while(true){
              playgame();
              System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
              Scanner sc = new Scanner(System.in);
              int tmp = sc.nextInt();
              if(tmp == 1)
                  ;
              else if(tmp ==2)
                  break;
          }
    }
}

