import java.util.*;
public class FCFS {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of process : ");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int ar[] = new int[n];
        int ct[] = new int[n];
        int bt[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        for(int i = 0; i<n; i++){
            System.out.println("Enter the arrival time for process "+(i+1)+"");
            ar[i] = sc.nextInt();
            System.out.println("Enter the Burst time for process "+(i+1)+"");
            bt[i] = sc.nextInt();
            pid[i] = i+1;
        }
        for(int i = 0; i<n; i++){
            int temp;
            for (int j = 0; j<n - (i+1); j++){
                if(ar[j]>ar[j+1]){
                    temp = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = temp;
                    temp = bt[j];
                    bt[j] = bt[j+1];
                    bt[j+1] = bt[j];
                    temp = pid[j];
                    pid[j] = pid[j+1];
                    pid[j+1] = temp;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(i == 0){
                ct[i] = ar[i] + bt[i];
            }else{
                if(ar[i]>ct[i-1]){
                    ct[i] = ar[i] + bt[i];
                }else{
                    ct[i] = ct[i-1] + bt[i];
                }
            }
            tat[i] = ct[i] - ar[i];
            wt[i] = tat[i] - bt[i];
        }
        System.out.println("process arrival complete turn wait");
        for (int i = 0; i <n; i++){
            System.out.println(""+pid[i]+"\t"+ar[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]+"");
        }
        sc.close();
    }
}
