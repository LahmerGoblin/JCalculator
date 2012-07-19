import java.awt.event.*;
public class Multiplikation extends Function {
    // each function has to know its parent
   private JCalculator parent;
   public Multiplikation(JCalculator parent) {
       this.parent = parent;
    }
 public void actionPerformed(ActionEvent e) {
    getImage();
 }
 public void getImage() {
    int i =  Integer.parseInt(parent.firstField.getText()) *
            Integer.parseInt(parent.secondField.getText());
    parent.firstField.setText("" + i);
    parent.secondField.setText("");
 }
 public String getLabel() {
     return "*";
 }
}
