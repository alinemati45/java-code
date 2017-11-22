package seminar_class_sort_visual.run_project;

/**
 * Class that implements abstract array
 *
 * @author Ali Nemati
 * @author Nursultan Irgaliyev
 *
 * Visualization of sorting techqniues Ali Nemati 1750210 , Nursultan Irgaliyev
 * 1753142 Professor: Dr. Mohamad Ali Date: 11/22/17 Seminar Class / TCSS 598 :
 * Visualizing of How Sorting Techniques Work Goal: Create a comprehensive
 * visual representation of your implemented code. Show how different sorting
 * techniques preform given a set of data by creating a video that records the
 * sorting process. We submit our video online in YouTube.
 *
 **************************************
 ************************************​
 */
import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

final class runClass extends Frame implements ActionListener {

    private List<sortNames_Alogrithm> algorithms;
    private TextField arraySizeInput;
    private Choice algorithmInput;
    private Button run_Project;
    private Button exitButton;

    public runClass(List<sortNames_Alogrithm> algos) {
        // Set window title and closing action
        super("Visualization Sorts");

        Objects.requireNonNull(algos);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        GridBagLayout GridBagLayout1 = new GridBagLayout();
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        this.setLayout(GridBagLayout1);
        gridBagConstraints1.anchor = GridBagConstraints.WEST;
        gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints1.weightx = 1;
        gridBagConstraints1.ipadx = 0;
        gridBagConstraints1.weighty = 0;
        gridBagConstraints1.insets = new Insets(4, 4, 4, 4);
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.ipady = 0;
        Label label_text = new Label("Please Select One Sort Algorithm:");
        gridBagConstraints1.gridy = 0;
        GridBagLayout1.setConstraints(label_text, gridBagConstraints1);
        this.add(label_text);
        label_text = new Label("Add Array size or Leave it by:");
        gridBagConstraints1.gridy = 1;
        GridBagLayout1.setConstraints(label_text, gridBagConstraints1);
        this.add(label_text);
        label_text = new Label("velocity of this above algorithm is");
        gridBagConstraints1.gridy = 2;
        GridBagLayout1.setConstraints(label_text, gridBagConstraints1);
        this.add(label_text);
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 2;
        label_text = new Label("4000");
        GridBagLayout1.setConstraints(label_text, gridBagConstraints1);
        this.add(label_text);
        label_text = new Label("By: Ali Nemati & Nursultan Irgaliyev");
        gridBagConstraints1.gridy = 3;
        gridBagConstraints1.gridx = 0;
        // gridBagConstraints1.set
        GridBagLayout1.setConstraints(label_text, gridBagConstraints1);
        this.add(label_text);
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.weightx = 2;
        algorithms = new ArrayList<>(algos);
        algorithmInput = new Choice();
        for (sortNames_Alogrithm algo : algos) {
            algorithmInput.add(algo.getName());
        }
        gridBagConstraints1.gridy = 0;
        GridBagLayout1.setConstraints(algorithmInput, gridBagConstraints1);
        this.add(algorithmInput);
        arraySizeInput = new TextField("3800");
        arraySizeInput.addActionListener(this);
        gridBagConstraints1.gridy = 1;
        GridBagLayout1.setConstraints(arraySizeInput, gridBagConstraints1);
        this.add(arraySizeInput);
        run_Project = new Button("Run");
        run_Project.addActionListener(this);
        gridBagConstraints1.anchor = GridBagConstraints.NORTH;
        gridBagConstraints1.fill = GridBagConstraints.NONE;
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.gridy = 3;
        gridBagConstraints1.gridwidth = 2;
        gridBagConstraints1.weighty = 1;
        GridBagLayout1.setConstraints(run_Project, gridBagConstraints1);
        this.add(run_Project);
        exitButton = new Button("Exit!");
        this.add(exitButton);
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 3;
        gridBagConstraints1.gridwidth = 2;
        gridBagConstraints1.weighty = 1;
        GridBagLayout1.setConstraints(exitButton, gridBagConstraints1);
        exitButton.addActionListener(new exitApp());
        this.pack();
        Rectangle rectangle1 = getGraphicsConfiguration().getBounds();
        this.setLocation((rectangle1.width - this.getWidth()) / 7, (rectangle1.height - this.getHeight()) / 3);
        this.setVisible(true);
    }

    static class exitApp implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public void actionPerformed(ActionEvent ev) {
        int size;
        double speed = 3000;
        try {
            size = Integer.parseInt(arraySizeInput.getText());
        } catch (NumberFormatException e) {
            return;
        }
        if (size <= 0 || Double.isInfinite(speed) || Double.isNaN(speed)) {
            return;
        }

        // Initialize objects and worker thread
        final visualSortArray array = new visualSortArray(size, 1, speed);
        final sortNames_Alogrithm algorithm = algorithms.get(algorithmInput.getSelectedIndex());
        final int startDelay = 1; // In milliseconds
        new Thread() {
            public Thread thread = this;

            public void run() {
                initFrame();
                doSort();
            }

            private void initFrame() {
                // Do component layout
                final Frame sortFrame = new Frame(algorithm.getName());
                sortFrame.add(array.canvas);
                sortFrame.setResizable(false);
                sortFrame.pack();
                sortFrame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        thread.interrupt();
                        sortFrame.dispose();
                    }
                });

                // Set window position and show
                Rectangle rect = getGraphicsConfiguration().getBounds();
                sortFrame.setLocation((rect.width - sortFrame.getWidth()) - 80,
                        (rect.height - sortFrame.getHeight()) - 80);
                sortFrame.setVisible(true);

            }

            private void doSort() {
                try {
                    Thread.sleep(startDelay);
                    algorithm.sort(array);
                } catch (ErrorMessage | InterruptedException e) {
                    return;
                }

                synchronized (System.err) {
                    String st = "Done";
                    JOptionPane.showMessageDialog(null, st);

                }
            }
        }.start();
    }

}

final class ErrorMessage extends RuntimeException {

    public ErrorMessage() {
        //System.out.println("Make an Error");
    }

}
