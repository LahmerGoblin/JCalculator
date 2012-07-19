import javax.swing.*;
import java.awt.*;

public class JCalculator extends JComponent {
    /**
     * JCalculator's inputfields
     */
    public JTextField firstField, secondField; 
    /**
     * miscellaneous buttons provided by each function
     */
    private Function[] functions;
    
    public JCalculator() {
        functions = new Function[0];
        firstField = new JTextField("1");
        secondField= new JTextField("2");
        firstField.setSize(180,20);
        secondField.setSize(180,20);
        this.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setSize(180,40);
        panel.add(firstField,BorderLayout.NORTH);
        panel.add(secondField,BorderLayout.SOUTH);
        this.add(panel,BorderLayout.NORTH);
    }
    /**
     * Functions are added on-the-fly to JCalculator
     */
    public void addFunction(Function f) {
            Function[] bufferFunction = new Function[functions.length+1];
            for (int i = 0;i<functions.length;i++) {
                 bufferFunction[i] = functions[i];
        }
            bufferFunction[bufferFunction.length-1] = f;
            functions = bufferFunction;
    }
    /**
     * assembling Functions into buttons
     */
    public void updateGUI() {
        JPanel jpanel = new JPanel();
        for (int i = 0;i<functions.length;i++) {
            Function f = functions[i];
            JButton button = new JButton(f.getLabel());
            button.setSize(30,30);
            button.addActionListener(f);
            // which functions are added?
            System.out.println(f.getLabel());
            jpanel.add(button);
        }
        this.add(jpanel,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        JCalculator calc = new JCalculator();
        calc.addFunction(new Addition(calc));
        calc.addFunction(new Subtraktion(calc));
        calc.addFunction(new Division(calc));
        calc.addFunction(new Multiplikation(calc));
        calc.updateGUI();
        frame.add(calc);
        frame.setTitle("JCalculator");
        frame.setSize(200,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

