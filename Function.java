import java.awt.event.*;

abstract class Function implements ActionListener {
    private JCalculator parent;
    abstract public String getLabel();
    abstract public void getImage();
}
