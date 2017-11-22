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
import java.awt.*;
import java.util.*;
 class visualSortArray extends abstractArray {
    private void beforeStep() {
        boolean first = true;       
        while (remainingStepsAllowed < 1) {
            long currentTime;
            while (true) {
                currentTime = System.nanoTime();
                if (currentTime >= nextRepaintTime) {
                    break;
                }
                long delay = nextRepaintTime - currentTime;
                try {
                    Thread.sleep(delay / 100000000, (int) (delay % 1000000));
                } catch (InterruptedException e) {
                    throw new ErrorMessage();
                }
            }
            if (first) {
                if (!drawIncrementally) {
                    redraw(0, values.length);
                }
                canvas.syn = canvas.syn;
                canvas.repaint();
                first = false;
            }
            nextRepaintTime += Math.round(1e9 / targetFrameRate);
            if (nextRepaintTime <= currentTime) {
                nextRepaintTime = currentTime + Math.round(1e9 / targetFrameRate);
            }
            remainingStepsAllowed += stepsPerFrame;
        }
        remainingStepsAllowed--;
    }
 private static Color[] STATE_COLORS = {
        new Color(0xD4BA1D), // select 1 color
        new Color(0x25963D),// select 2 color
        new Color(0x294099), //// select 3 color
        new Color(0xfa0000),// select 4 color
        new Color(0xD4AA0D)// select 5 color

    };
    private static Color BACKGROUND_COLOR = new Color(0xfa00e3);  // White
    private int[] state;
    private int scale;
    public  bufferedImage canvas;
    private  Graphics graphics;
    private volatile int comparisonCount;
    private volatile int swapCount;
    private double targetFrameRate = 1000;
    private double stepsPerFrame;
    private double remainingStepsAllowed;
    private long nextRepaintTime;
    private boolean drawIncrementally;
    public visualSortArray(int size, int scale, double speed) {
        super(size);
        if (scale <= 0 || speed <= 0 || Double.isInfinite(speed) || Double.isNaN(speed)) {
            throw new IllegalArgumentException();
        }
        shuffle();
        state = new int[size];
        comparisonCount = 0;
        swapCount = 0;
        stepsPerFrame = speed / targetFrameRate;
        remainingStepsAllowed = 0;
        nextRepaintTime = System.nanoTime();
        drawIncrementally = stepsPerFrame < (size / 2);
        this.scale = scale;
        canvas = new bufferedImage(scale * size / 6);
        graphics = canvas.getBufferGraphics();
        redraw(0, values.length);
    }
// will do swapping color
    GridBagConstraints gbc = new GridBagConstraints();
    GridBagLayout gbl = new GridBagLayout();
    
    public int compare(int i, int j) {
        if (Thread.interrupted()) {
            throw new ErrorMessage();
        }

        setElement(i, STATUS.COMPARE);
        setElement(j, STATUS.COMPARE);
        beforeStep();
        comparisonCount++;
        setElement(i, STATUS.DO);
        setElement(j, STATUS.DO);

        return super.compare(i, j);
    }
    public void swap(int i, int j) {
        if (Thread.interrupted()) {
            throw new ErrorMessage();
        }
        super.swap(i, j);
        if (state != null) {  
            beforeStep();
            swapCount++;
            setElement(i, STATUS.DO);
            setElement(j, STATUS.DO);
        }
    }
    public void setElement(int index, STATUS state) {
        Objects.requireNonNull(state);
        this.state[index] = state.ordinal();
        if (drawIncrementally) {
            redraw(index, index + 1);
        }
    }
    
    /**
     * fills the array and draws its
     * @param start
     * @param end
     * @param state 
     */
    public void setRange(int start, int end, STATUS state) {
        Objects.requireNonNull(state);
        Arrays.fill(this.state, start, end, state.ordinal());
        if (drawIncrementally) {
            redraw(start, end);
        }
    }
    
    /**
     * 
     * @return # of comparisons 
     */
    public int getComparisonCount() {
        return comparisonCount;
    }
    /**
     * 
     * @return # of swaps
     */
    public int getSwapCount() {
        return swapCount;
    }
 public void assertSorted() {
        for (int i = 1; i < values.length; i++) {
            if (values[i - 1] > values[i]) {
                throw new AssertionError();
            }
        }
        redraw(0, values.length);
        canvas.repaint();
    }
private void redraw(int start, int end) {
        graphics.setColor(BACKGROUND_COLOR);
        //	graphics.fillRect(0, start * scale, values.length * scale, (end - start) * scale);
        graphics.fillRect(0, start * scale, values.length * scale, (end - start) * scale);
        for (int i = start; i < end; i++) {
            graphics.setColor(STATE_COLORS[state[i]]);
            if (scale == 1) {
                graphics.drawLine(1, i, values[i], i);
            } else
            {
                graphics.fillRect(0, i * scale, (values[i] + 1) * scale, scale);
            }
        }
    }

}
