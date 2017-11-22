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
// improt seminar_class_sort_visual.run_project all

import seminar_class_sort_visual.run_project.*;
//class selection sort which is extends by abstract_For_Sort_Algo

public class selectionSort extends abstract_For_Sort_Algo {

    public selectionSort() {// public constructor if we want to call it will show on the first page.
        super("Selection sort");//// should be on supper
    }
    public static final sortNames_Alogrithm run = new selectionSort();
    public void sort(sortArray array) { // create a metho sort
        int length = array.length();// call integer array.length
        int x, y;// call x,y
        for ( x = 0; x < length; x++) {// above array
            int midValue = x;// call mid value
            for ( y = x + 1; y < length; y++) {// blow array
                if (array.compare(y, midValue) < 0) { // if this
                    midValue = y;// so do for above if
                }
            }
            // in this case starting to swapping
            array.swap(x, midValue); // it shows above array must be compare and swapping x , y
            array.setElement(x, sortArray.STATUS.FINISH);
            // it would show this step	in finish swapping
        }
    }
}
