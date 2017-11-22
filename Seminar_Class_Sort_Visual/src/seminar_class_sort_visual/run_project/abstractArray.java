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
package seminar_class_sort_visual.run_project; // abstractArray is in seminar_class_sort_visual.run_project
import java.util.Random; // import random  value to make

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
* Reaching to this video in below address:
* https://youtu.be/F8l6z4MX59Q
**************************************
************************************​
 */

// useing abstract class will help to work with array
// in this class we implements sortArray
public abstract class abstractArray implements sortArray {

    public static Random random = new Random();// this code to make a random
    // create vlaue array

    public boolean compareAndSwap(int x, int y) { //  compare and swapping 
        if (compare(y, x) < 0) { // if (y, x) < 0, so, do below commade line
            swap(x, y); // if (y, x) < 0, so, do below commade line
            return true; // then return ture
        } else { // else  if (y, x) >= 0, so, do below commade line
            return false; // return false
        }
    }
    public void shuffle() { // create void shuffle
        int x; // create x
        for (x = length() - 1; x > 0; x--) {
            // for to movement from length -1 untill x>0
            swap(x, random.nextInt(x + 1));
            // swapping x randommly
        }
    }
    public void setElement(int index, sortArray.STATUS state) {
        // make set element include index and Event state
    }
    public void setRange(int start, int end, sortArray.STATUS state) {
        // make a set rage with end, start and Event state 
    }
        int[] values;
    public int compare(int x, int y) { // doing compare x , y
        if ((y < 0 || y >= values.length) // for this condition
                || (x >= values.length || x < 0)) // for this condition
        // do below code
        {
            throw new IndexOutOfBoundsException();
        }
        return Integer.compare(values[x], values[y]); // then retund infront command line
    }
    

    
        // create a construction ; 
    // Constructor in java is a special type of method that is used to initialize the object.
    //Java constructor is invoked at the time of object creation. 
    //It constructs the values i.e. provides data for the object that is why it is known as constructor. 
    public abstractArray(int size) {
        if (size < 0) {
            throw new IllegalArgumentException();
        }

        values = new int[size];
         int x;// create x value
        for (x = 0; x < values.length; x++) { // create value by order from 0 to index -1
            values[x] = x;// equal value index x by x
        }
    }
      public int length() { // length with integer value
        return values.length; // will return values.length
    }
      
              // public abstract class implement with SortArray
    public void swap(int x, int y) { // doing swapping
        if ((y < 0 || y >= values.length)
                || (x < 0 || x >= values.length)) {
            throw new IndexOutOfBoundsException();
        } // then ,do below command
        int temp = values[x]; // usage: z = swap(a, a=b, b=c, ... y=z);
        values[x] = values[y];
        values[y] = temp;
    }
}
