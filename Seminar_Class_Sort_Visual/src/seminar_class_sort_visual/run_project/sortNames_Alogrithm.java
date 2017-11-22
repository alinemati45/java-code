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
package seminar_class_sort_visual.run_project; // name of package that we are working on it.

public interface sortNames_Alogrithm { // create a Sortname. 
/*
    Type inference is a feature of Java 
    which provides ability to compiler to look at
    each method invocation and corresponding declaration 
    to determine the type of arguments.
    //https://www.javatpoint.com/java-8-type-inference
    */
    /* Sorts the given array using this algorithm. The array is not null.
   * should not be null*/
    public void sort(sortArray array); //the method will use those 5 algo 
    public String getName();// this method will return name of those 5 algo
    // should not be null
}
