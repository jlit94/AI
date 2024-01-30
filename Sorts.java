package Week2;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.*;
public class Sorts
{
	public static void main(String[] args) 
	{
		long startTime = System.currentTimeMillis();
		ThreadMXBean tmb = ManagementFactory.getThreadMXBean();
		long startCPUtime = tmb.getCurrentThreadCpuTime();
		
		for(int i=1; i<=1; i++) 
		{
			Random random = new Random();
			int n = 10;
			int A[] = new int[n];
			for(int ii=0; ii < n-1; ii++)
			{
				A[ii] = random.nextInt(n);
			}
			
			printArray(A, n);
			//selectionSort(A, n);
			//insertionSort(A, n);
			MergeSort ms = new MergeSort();
			ms.sort(A, 0, A.length-1);
			printArray(A, n);
			
		}
		
		long endTime = System.currentTimeMillis();
		long et = (endTime - startTime);
		
		double elapsedTime = et/1000.00;
		System.out.println(elapsedTime);
		
		long endCPUTime = tmb.getCurrentThreadCpuTime();
		long elapsedCPUTime = endCPUTime - startCPUtime;
		
		double seconds = (double)elapsedCPUTime/1000000000.00;
		System.out.println(seconds);
		
	}
		
	public static void selectionSort ( int A[], int n ) 
	{ 
        for (int i = 0; i < n-1; i++) 
        { 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (A[j] < A[min_idx]) 
                    min_idx = j; 
  
            int temp = A[min_idx]; 
            A[min_idx] = A[i]; 
            A[i] = temp; 
        } 
	
	}
		
	public static void insertionSort ( int A[], int n ) 
	{
		for (int i = 1; i < n; ++i) 
		{
            int key = A[i];
            int j = i - 1;
 
            while (j >= 0 && A[j] > key) 
            {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = key;
		}
	}
	
	public static void printArray(int A[], int n)
    {
        for (int i = 0; i < n; ++i)
            System.out.print(A[i] + " ");
 
        System.out.println();
    }
}

class MergeSort 
{ 
    void merge(int arr[], int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
  
        for (int i = 0; i < n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j]; 
  
        int i = 0, j = 0; 
  
        int k = l; 
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 

        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 

    void sort(int arr[], int l, int r) 
    { 
        if (l < r) { 

            int m = (l + r) / 2; 

            sort(arr, l, m); 
            sort(arr, m + 1, r); 

            merge(arr, l, m, r); 
        } 
    } 
    
}