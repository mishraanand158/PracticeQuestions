import java.util.Scanner;

// 5
// 4
// 2
// 7
// 1
// 3
// 10
public class TargetSubSetProblem {
    public static void main(String[] args) {
         
         
         Scanner sc  =  new Scanner(System.in);
         int num =  sc.nextInt();
         int [] arr = new int[num];
         for(int i=0;i<num;i++)
         {
             arr[i]= sc.nextInt();
         }

         int target = sc.nextInt();
         sc.close();

         boolean [][] dp = new boolean[arr.length+1][target+1];

         for(int i=0;i<dp.length;i++)
         {
             for(int j=0;j<dp[0].length;j++)
             {
                if(i==0 && j==0)
                dp[i][j] = true;
                else if (i==0)
                dp[i][j] =false;
                else if(j==0)
                dp[i][j] = true;
                else if(dp[i-1][j]){
                    dp[i][j] =true;

                }
                else {
                  //  =j-arr[i] //column and i-1 check ture then return ture ;
                    // int val = arr[i-1] ; value at dp[i]
                    int val = arr[i-1];

                    if(j>=val && dp[i-1][j-val]==true)
                    dp[i][j] = true;

                }
                //check


             }

         }
         System.out.println(dp[dp.length-1][target]);
    }
    
}
