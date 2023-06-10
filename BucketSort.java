import java.util.*;
public class BucketSort{
    public static void main(String[] args){
        
        
        int a[] = {105, 87142, 95, 12987120, 7194, 9, 2, 3, 1, 10, 105, 87142, 95, 12987120, 7194, 9, 2, 3, 1, 10};
        LinkedIntList buckets[] = new LinkedIntList[10];   // To create the reference to the array.
        for (int i=0;  i < buckets.length;  i++)  buckets[i] = new LinkedIntList(); // To fill the array with the ten base buckets.
        int max = max(a);
        place(10, 1, buckets, a, max, 0);
        System.out.println(Arrays.toString(a));
    }
    public static int max(int a[]){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< a.length; i++) if(a[i] > max) max = a[i];    
        int digits = 0;
        while(max != 0){
            max = max/10;
            digits++;
        }
        return digits;
    }
    public static void place(int n, int x, LinkedIntList buckets[], int a[], int max, int c){
        for(int i = 0; i< a.length; i++) buckets[(a[i]%n)/x].add(a[i]);       
        pass(buckets, a, max, c, n, x);    
    }
    public static int[] pass(LinkedIntList buckets[], int a[], int max, int c, int n, int x){
        int count = 0;
        for(int i = 0; i<10; i++)
            for(int j = 0; j<buckets[i].size(); j++){
                a[count] = buckets[i].get(j);
                buckets[i].remove(j);
                j--;
                count++;
            }
        if(c <= max)place(n*10, x*10, buckets, a, max, c+1);
          return a;  
    }
}