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
import seminar_class_sort_visual.run_project.*;// call all algo in seminar_class_sort_visual.run_project
import java.util.Arrays;
// this is main class to run algorithms 
//runs runClass on all 5 algorithms
public class mainClass {
    public static void main(String[] args) {
        // create an array which called algorithems to 
        //run bubbleSort,selectionSort,insertionSort,mergeSort,quickSort
        sortNames_Alogrithm[] algorithems = {bubbleSort.run, selectionSort.run, insertionSort.run, mergeSort.run, quickSort.run,};
        // in below code, it will run "runClass" and we can see all algorithem's name
        //run bubbleSort,selectionSort,insertionSort,mergeSort,quickSort
        new runClass(Arrays.asList(algorithems));
    } // e end of class static void main
} // end of class mainClass
 