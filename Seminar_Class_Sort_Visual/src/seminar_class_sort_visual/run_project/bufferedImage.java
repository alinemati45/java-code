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
import java.awt.image.*;
import java.awt.*;
class bufferedImage extends Canvas { // class bufferedImage with exptends of Canvas
    private BufferedImage buffer; // a private buffer
    private Graphics bufferGrafic;//  a private bufferGrafic
/* https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html
A class contains constructors that are invoked to create objects from the class blueprint. 
    Constructor declarations look like method declarations—except that they use the name of the class and have no return type.
    */
    public bufferedImage(int size) {
        this(size, size); } // will end bufferedImage
        public Graphics getBufferGraphics() {
        return bufferGrafic; // will return grafic
    }// ending getBufferGraphics
    int syn;  //create Field synchronizer as integer
    public void paint(Graphics g) { // it would call AWT
        //but not called by use code
        syn = syn;
        g.drawImage(buffer, 0, 0, this);
  }// end of paint
    public bufferedImage(int wid, int hei) { // image buffer height and width
        if ((wid <= 0) || (hei <= 0)) { // width is smaller and equal 0 ;
            //OR height smaller and equal 0 
            throw new IllegalArgumentException(); // run this exception
        }// end of bufferedImage
        this.setSize(wid, hei);// set size by width and height
        buffer = new BufferedImage(wid, hei, BufferedImage.TYPE_INT_BGR); 
        bufferGrafic = buffer.getGraphics();
    } //bufferedImage will end
    public void update(Graphics graph) {
        paint(graph); // should update image and end update
    }}
