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
package seminar_class_sort_visual.run_project;
//  // name of package that we are working on it.
import seminar_class_sort_visual.run_project.*;
// improt seminar_class_sort_visual.run_project.*
public class mergeSort extends abstract_For_Sort_Algo {
    // public constructor.
    public mergeSort() { //  public constructor if we want to call it will show on the first page.
        super("Merge sort"); // // should be on supper
    }
    // sort Present.
    public static sortNames_Alogrithm run = new mergeSort();
    public void sort(sortArray array) {
        sort(array, 0, array.length());
        array.setRange(0, array.length(), sortArray.STATUS.FINISH);
         //show when sort is done
    }
    private static void sort(sortArray array, int begin, int stop) {
        if (!((0 <= begin && begin <= stop) && 
                (stop <= array.length()))) {
            throw new IllegalArgumentException();
        }
        if (stop - begin <= 1) {
            return;
        }
// doing mid to be in above or dowm of sort. 
        array.setRange(begin, stop, sortArray.STATUS.DO);
        int mid = (begin + stop) / 2;
        array.setRange(mid, stop, sortArray.STATUS.IDLE);
        sort(array, begin, mid);
        array.setRange(begin, mid, sortArray.STATUS.IDLE);
        sort(array, mid, stop);
        merge(array, begin, mid, stop);
    }
    private static void merge(sortArray array, int begin, int avg, int stop) {
        if (!((0 <= begin) 
                && (avg <= stop) 
                && (begin <= avg) 
                && (stop <= array.length()))) {
            throw new IllegalArgumentException();
        }
        if ((begin == avg) || (avg == stop)) {
            return;
        }
        array.setRange(begin, stop, sortArray.STATUS.DO);
        int left = avg - 1, right = avg;
        while ((begin <= left) && 
                (right < stop) && 
                (array.compare(left, right) > 0)) {
            left-=1;
            right+=1;
        }

        int n = right - avg;
        for (int i = 0; i < n; i++) {
            array.swap(avg - n + i, 
                    avg + i);
        }
        //show when sort is idle
        array.setRange(avg, stop, sortArray.STATUS.IDLE);
        merge(array, begin, left + 1, avg);
        array.setRange(begin, avg, sortArray.STATUS.IDLE);
        merge(array, avg, right, stop);
    }
}
