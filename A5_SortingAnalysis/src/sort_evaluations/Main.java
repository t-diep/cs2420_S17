/**
 * 
 */
package sort_evaluations;

import java.util.ArrayList;
/**
 * Tony Diep
 * u0934661
 * 2/19/17 
 * 2420 
 * Assignment 5
 * Partner: Cindy Liao
 * u0627241 
 * 
 * I pledge that the work done here was my own and that I have learned how to
 * write this program, such that I could throw it out and restart and finish it
 * in a timely manner. I am not turning in any work that I cannot understand,
 * describe, or recreate. I further acknowledge that I contributed substantially
 * to all code handed in and vouch for it's authenticity. 
 * 
 * Tony Diep
 * 
 * @author Tony Diep
 *
 */

/**
 * Provides a collection of all of the different sorting algorithms
 * 
 * Pseudocode:
 *     built a list of sorters
 *     add all of the sorts (e.g., Quick_Sort_Naive, Quick_Sort_Inplace...) to the list
 *     for each element of the list
 *        time it for a wide range of values (e.g., 10,000 -> 100,000,000)
 *     test insertion sort separately because you can't wait that long...
 *
 */
public class Main
{
	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		ArrayList<Sorter<Integer>> sort_methods = new ArrayList<>();
		
		Insertion_Sort<Integer> insertion = new Insertion_Sort<Integer>();
		Java_Sort<Integer> javaSort = new Java_Sort<Integer>();
		Merge_Sort<Integer> merge = new Merge_Sort<Integer>();
		Quick_Sort_Inplace_First_Pivot<Integer> firstPivotQuickSort = new Quick_Sort_Inplace_First_Pivot<Integer>();
		Quick_Sort_Inplace_M3<Integer> median3QuickSort = new Quick_Sort_Inplace_M3<Integer>();
		Quick_Sort_Inplace_Random_Pivot<Integer> inplaceRandomPivot = new Quick_Sort_Inplace_Random_Pivot<Integer>();
		Quick_Sort_Naive<Integer> quickSortNaive = new Quick_Sort_Naive<Integer>();
		Shell_Sort<Integer> shellSort = new Shell_Sort<Integer>();
		
		sort_methods.add(insertion);
		sort_methods.add(javaSort);
		sort_methods.add(merge);
		sort_methods.add(firstPivotQuickSort);
		sort_methods.add(median3QuickSort);
		sort_methods.add(inplaceRandomPivot);
		sort_methods.add(quickSortNaive);
		sort_methods.add(shellSort);
		
		Sort_Utils sort = new Sort_Utils();
		
		for (int index = 0; index < sort_methods.size(); index++){
			sort.test_and_time(sort_methods.get(index), 100, 500, 7_000, 400_000);
		}
	}
}
