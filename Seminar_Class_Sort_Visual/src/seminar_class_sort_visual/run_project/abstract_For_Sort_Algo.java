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

import java.util.Objects;

public abstract class abstract_For_Sort_Algo implements sortNames_Alogrithm {
        private String name;
        public String getName() { return name; // in this method, will return name of algorithm
    }
    /*
    A class contains constructors that are invoked to create objects from the class blueprint. 
    Constructor declarations look like method declarations—except that they use the name of the class and have no return type.
    https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html
    */
    protected abstract_For_Sort_Algo(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }// end of protected abstract_For_Sort_Algo(String name)
}//end of  public abstract class abstract_For_Sort_Algo implements sortNames_Alogrithm
