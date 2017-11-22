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
// name of package that we are working on it.
package seminar_class_sort_visual.run_project;
import seminar_class_sort_visual.run_project.*;
// improt seminar_class_sort_visual.run_project.*
public  class insertionSort extends abstract_For_Sort_Algo {
	// public constructor.
	public insertionSort() {// public constructor if we want to call it will show on the first page.
	super("Insertion sort");// should be on supper
}
	public static  sortNames_Alogrithm run = new insertionSort();
	public void sort(sortArray array) {
		int length = array.length(), x, y;
		array.setRange(0, length, sortArray.STATUS.IDLE);// happend when sort is idle
		for ( x = 0; x < length; x++) {// first for
			for ( y = x; y >= 1 &&
                                array.compareAndSwap(y - 1, y); y--);//second for to do compare and swapping
		}
		array.setRange(0, length, sortArray.STATUS.FINISH);
                 // it would show this stepin finish compareAndSwap
	}	
}
