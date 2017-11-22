/**
 * Class that implements abstract array
 * @author Ali Nemati
 * @author Nursultan Irgaliyev

* Visualization of sorting techqniues
* Ali Nemati 1750210 , Nursultan Irgaliyev 1753142
* Professor: Dr. Mohamad Ali
* Date: 11/22/17
* Seminar Class / TCSS 598 : Visualizing of How Sorting Techniques Work
* Goal:
* Create a comprehensive visual representation of your implemented code.
* Show how different sorting techniques preform given a set of data by creating a video that records the sorting process.
* We submit our video online in YouTube.

**************************************
************************************​
 */
// name of package that we are working in
package seminar_class_sort_visual.run_project;
import seminar_class_sort_visual.run_project.*;
// improt seminar_class_sort_visual.run_project.*


public  class quickSort extends abstract_For_Sort_Algo {
	// public constructor.
	public quickSort() {//  public constructor if we want to call it will show on the first page.
	super("Quick sort "); // // should be on supper
}
	public static  sortNames_Alogrithm run = new quickSort();
	public void sort(sortArray array) {
		sort(array, 0, array.length());
	}
	private static void sort(sortArray array, int start, int end) {
		if (start == end)
			return;
		array.setRange(start, end, sortArray.STATUS.IDLE);
		int partition = start;
                int x;
		int pivot = end - 1;  // Do not change this!
		for ( x = start; x < end - 1; x++) {
			if (array.compare(x, pivot) < 0) {
				array.swap(x, partition);
				array.setElement(partition, sortArray.STATUS.IDLE);
				partition++;
			}
		}	
		array.swap(pivot, partition);
		pivot = partition;
		array.setElement(pivot, sortArray.STATUS.FINISH);
                // when sort is done
		array.setRange(pivot + 1, end, sortArray.STATUS.IDLE);
                // when sort is idle
		sort(array, start, pivot);
		sort(array, pivot + 1, end);
	}
}
