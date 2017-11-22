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
//  // name of package that we are working on it.
package seminar_class_sort_visual.run_project;
// improt seminar_class_sort_visual.run_project.*
import seminar_class_sort_visual.run_project.*;

/**
 * Implementation of bubble sort
 * @author Ali Nemati
 * @author Nursultan Irgaliyev
 */

public class bubbleSort extends abstract_For_Sort_Algo {
    public bubbleSort() {// public constructor if we want to call it will show on the first page.
        super("Bubble sort");// should be on supper
    }
    public static final sortNames_Alogrithm run = new bubbleSort();
    public void sort(sortArray array) {
        int x, y; // call x , y with integer values
        for (x = array.length(); x >= 1; x--) { // will start from x which is equal by array.length()
            // step of fist for is >=1; then will x-=-1
            for (y = 0; y < x - 1; y++) // will start from x which is equal by 0
            // step of fist for is < x - 1; then will y+=+1
            {
                array.compareAndSwap(y, y + 1); // it shows above array must be compare and swapping x , y
            }
            array.setElement(y - 1, sortArray.STATUS.FINISH);
            // it would show this step	in finish swapping		
        }
    }
}
