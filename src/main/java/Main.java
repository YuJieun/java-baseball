import java.util.*;

public class Main {
    public static void main(String[] args) {

          int[] num = new int[3];
          num = makeNumber();
          for(int i=0;i<num.length;i++){
              System.out.print(num[i]);
          }

//        Scanner sc = new Scanner(System.in);
//
//        int page = sc.nextInt();
//        int[] arr = new int[10];
//
//        arr = book(page,arr);
//        for(int i=0;i<10;i++) {
//            System.out.print(arr[i]+" ");
//        }
    }

    public static int[] makeNumber()//정수형 배열 리턴하는 메소드
    {
        int temp[] = new int[3]; //배열 생성
        for(int i=0;i<temp.length;i++)
        {
            temp[i]  = (int)(Math.random()*9)+1;
            for ( int j = 0; j < i; j++ ){
                if( temp[i] == temp[j] ){
                    i--;
                }
            }
        }
        return temp;//배열리턴
    }
}

