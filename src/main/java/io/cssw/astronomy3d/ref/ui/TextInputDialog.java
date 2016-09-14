package io.cssw.astronomy3d.ref.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Stephen McConnell on 9/14/16.
 */


public class TextInputDialog extends JDialog implements ActionListener {
    private String[] results = null;
    private JTextField[] inputFields = null;


    public TextInputDialog(String title, String[] labels, int minSize) {
        // Modal Dialog box.
        super(new JFrame(), title, true);

        this.getContentPane().setLayout(new BorderLayout(10, 10));
        JPanel buttonPanel = new JPanel();

        JButton button = new JButton("OK");
        button.addActionListener(this);
        buttonPanel.add(button);

        button = new JButton("Cancel");
        button.addActionListener(this);
        buttonPanel.add(button);

        this.getContentPane().add(buttonPanel, "South");

        JPanel inputPanel = new JPanel();
        inputFields = new JTextField[labels.length];
        inputPanel.setLayout(new GridLayout(labels.length, 2, 8, 10));
        for(int i = 0; i < labels.length; i++) {
            JLabel theLabel = new JLabel(labels[i]);
            inputPanel.add(theLabel);

            inputFields[i] = new JTextField(minSize);
            inputPanel.add(inputFields[i]);
        }
        this.getContentPane().add(inputPanel, "North");

        this.pack();


    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if("OK".equals(e.getActionCommand())) {
            results = new String[inputFields.length];
            for(int i = 0; i < inputFields.length; i++) {
                results[i] = inputFields[i].getText();
            }
        } else if("Cancel".equals(e.getActionCommand())) {
            results = null;
        }
        this.dispose();
    }


    public String[] getInputs() {
        this.setVisible(true);
        return results;
    }

    public static void main(String[] args) {
        String[] labels = new String[2];
        labels[0] = "First Label";
        labels[1] = "Second Label";

        TextInputDialog inputDialog = new TextInputDialog("Input Text", labels, 10);
        String[] inputs = inputDialog.getInputs();

        if(inputs == null) {
            System.out.println("The user cancled.");
        } else {
            for(int i = 0; i < labels.length; i++) {
                System.out.println("For \"" + labels[i] + "\" the user input was \"" + inputs[i] + "\"");
            }
        }
    }
}
