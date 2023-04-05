import algebra.TestVector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DoubleVector extends JFrame implements ActionListener {

    private JTextField inputField;
    private JLabel resultLabel1, resultLabel2, resultLabel3;

    public DoubleVector() {
        super("Double Vector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel inputLabel = new JLabel("Enter comma-separated values:");
        inputField = new JTextField(20);
        JButton calculateButton = new JButton("Calculate");
        resultLabel1 = new JLabel("Result 1:");
        resultLabel2 = new JLabel("Result 2:");
        resultLabel3 = new JLabel("Result 3:");

        calculateButton.addActionListener(this);

        c.add(inputLabel);
        c.add(inputField);
        c.add(calculateButton);
        c.add(resultLabel1);
        c.add(resultLabel2);
        c.add(resultLabel3);

        setVisible(true);
    }

    public static void main(String[] args) {
        new DoubleVector();
    }

    public void actionPerformed(ActionEvent e) {
        String[] inputValues = inputField.getText().split(",");
        double[] values = new double[inputValues.length];
        for (int i = 0; i < inputValues.length; i++) {
            values[i] = Double.parseDouble(inputValues[i]);
        }

        double sum = 0.0;
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
        for (double value : values) {
            sum += value;
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }

        resultLabel1.setText("Sum: " + sum);
        resultLabel2.setText("Max: " + max);
        resultLabel3.setText("Min: " + min);
    }
}