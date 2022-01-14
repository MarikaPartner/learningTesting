/**
 * Java 1. Homework 8
 *
 * @author Marina Dumcheva
 * @version 02.12.2021
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Homework_8 {
    public static void main(String[] args) {
        new CounterApp(0);
    }
}

class CounterApp extends JFrame {
    private int value;
    CounterApp(int originalValue) {
        // Creating a window
        setBounds(500, 500, 400, 120);
        setTitle("My counter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Setting the font of window elemens 
        Font font = new Font("Arial", Font.BOLD, 36);

        // Creating a label in the center of the window
        JLabel counterValueView = new JLabel();
        counterValueView.setFont(font);
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
        add(counterValueView, BorderLayout.CENTER);

        value = originalValue;
        counterValueView.setText(String.valueOf(value));

        // Creating the decrement button in the left
        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        add(decrementButton, BorderLayout.WEST);

        // Creating the increment button in the right
        JButton incrementButton = new JButton(">");
        incrementButton.setFont(font);
        add(incrementButton, BorderLayout.EAST);

        // Adding the reaction to the decrement button pressing
        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value--;
                counterValueView.setText(String.valueOf(value));
                }
        });

        // Adding the reaction to the increment button pressing
        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value++;
                counterValueView.setText(String.valueOf(value));
            }
        });

        setVisible(true);
    }
}

