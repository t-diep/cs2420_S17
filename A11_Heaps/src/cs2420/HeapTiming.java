package cs2420;

import java.util.Random;

/**
 * The main program that contains timing experiments
 * 
 * @author Tony Diep, last updated 4-14-17
 */
public class HeapTiming 
{
	public static void main(String[] args) 
	{
		jimsExperiment();
		tonysExperiment();
	}
	
	/**
	 * The standard experiment derived from Jim's experiment
	 */
	public static void jimsExperiment()
	{
		Random gen = new Random();

		System.out.printf("%20s\t%20s\t%20s\t%20s\t%20s\t%20s\n", "Count", "ordered", "random", "reverse", "constant ordered", "constant random");
			

		for(int N = 1000; N < 1_000_000; N+= 1000)
		{
			Integer array_sorted[] = new Integer[N];
			Integer array_rand[] = new Integer[N];
			Integer array_reverse[] = new Integer[N];
		

			for (int i = 0; i < N; i++)
			{
				array_sorted[i] = i;
				array_rand[i] = gen.nextInt(N);
				array_reverse[i] = N - i;
			}

			Heap<Integer> heap_of_random = new Heap<>();
			Heap<Integer> heap_ordered = new Heap<>();
			Heap<Integer> heap_reverse = new Heap<>();

			heap_ordered.build_heap_from_array(array_sorted);
			heap_of_random.build_heap_from_array(array_rand);
			heap_reverse.build_heap_from_array(array_reverse);

			System.out.printf("%20s\t%20s\t%20s\t%20s\t%20s\t%20s\n", N, heap_ordered.numOfSwaps, heap_of_random.numOfSwaps, heap_reverse.numOfSwaps, 
					String.format("%.8f", (double) heap_ordered.numOfSwaps/heap_ordered.size()), String.format("%.2f", (double)heap_of_random.numOfSwaps/heap_of_random.size()));
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	/**
	 * My custom experiment for heaps
	 * 
	 * Compares the amortized times for inserting and removing
	 * between a Binary Search Tree (BST) and the min heap array
	 */
	public static void tonysExperiment()
	{
		Random gen = new Random();

		System.out.printf("%20s\t%20s\t%20s\n", "Count", "Average Insertion Heap", "Average Insertion BST");
		
		long startTimeHeap = 0;
		long endTimeHeap = 0;
		long totalHeapAdd = 0;
		
		long startTimeDequeue = 0;
		long endTimeDequeue = 0;
		long totalTimeDequeue = 0;
		
		long startTimeBST = 0;
		long endTimeBST = 0;
		long totalBSTAdd = 0;
		
		long startTimeDelete = 0;
		long endTimeDelete = 0;
		long totalTimeDelete = 0;
		
		for(int N = 1000; N < 100_000_000; N+= 1000)
		{		
			BinarySearchTree intTree = new BinarySearchTree();
			Heap<Integer> heap_ordered = new Heap<>();
			
			for (int index = 0; index < N; index++)
			{
				//Timing experiment for inserting elements into heap
				startTimeHeap = System.nanoTime();
				heap_ordered.add(N - index);
				endTimeHeap = System.nanoTime();
				totalHeapAdd+= endTimeHeap - startTimeHeap;
				
				//Timing experiment for dequeuing elements from heap
				startTimeDequeue = System.nanoTime();
				if(heap_ordered.size() != 0)
				{
					heap_ordered.dequeue();
				}
				endTimeDequeue = System.nanoTime();
				totalTimeDequeue += endTimeDequeue -startTimeDequeue;
				
				//Timing experiment for inserting elements into BST
				startTimeBST = System.nanoTime();
				intTree.insert(gen.nextInt(N));
				endTimeBST = System.nanoTime();
				totalBSTAdd+= endTimeBST - startTimeBST;
				
				//Timing experiment for deleting elements from BST
				startTimeDelete = System.nanoTime();
				if(intTree.root != null)
				{
					intTree.delete(index + 1);
				}
				endTimeDelete = System.nanoTime();
				totalTimeDelete += endTimeDelete - startTimeDelete;
			}
			//Print the results for the inserting elements timing experiment
			System.out.printf("%20s\t%20s\t%20s\n", N, String.format("%.2f", (double) totalHeapAdd / 100_000), String.format("%.2f", (double) totalBSTAdd / 100_000));		
			//Print the results for the removing elements timing experiment
			System.out.printf("%20s\t%20s\t%20s\n", N, String.format("%.2f", (double) totalTimeDequeue/ 100_000), String.format("%.2f", (double) totalTimeDelete / 100_000));
		}
	}
}
