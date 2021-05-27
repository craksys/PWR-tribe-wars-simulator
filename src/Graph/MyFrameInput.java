package Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class MyFrameInput extends JFrame implements ActionListener {
    JTextField textField;
    JTextField textField2;
    JTextField textField3;
    JTextField textwood;
    JTextField textiron;
    JTextField textfood;
    JTextField textstone;
    JTextField textrefresh;
    public int rounds,quantity,speed,refresh;
    public int food,wood,stone,iron;
    private final JButton button1;
    public boolean buttonclicked;

    public MyFrameInput() {
        super("Wprowadź dane");
        setSize(300, 100);
        setLocation(700, 300);
        JPanel panel = new MyPanelInput();
        textField = new JTextField(10);
        textField.setBounds(150,50,150,30);
        textField2 = new JTextField(10);
        textField2.setBounds(150,90,150,30);
        textField3 = new JTextField(10);
        textField3.setBounds(150,130,150,30);
        textfood = new JTextField(10);
        textfood.setBounds(150,170,150,30);
        textwood = new JTextField(10);
        textwood.setBounds(150,210,150,30);
        textstone = new JTextField(10);
        textstone.setBounds(150,250,150,30);
        textiron = new JTextField(10);
        textiron.setBounds(150,290,150,30);
        textrefresh = new JTextField(10);
        textrefresh.setBounds(150,330,150,30);
        //textField.setFont(textField.getFont().deriveFont(25f));
        button1 = new JButton("ok");
        button1.setBounds(172,390,56,30);
        panel.setLayout(null);
        button1.addActionListener(this);
        panel.add(textField);
        panel.add(textField2);
        panel.add(textField3);
        panel.add(textwood);
        panel.add(textfood);
        panel.add(textstone);
        panel.add(textiron);
        panel.add(button1);
        panel.add(textrefresh);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(panel);
        pack();
        //System.out.println(parseInt(textField.getText()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JComponent comp = (JComponent) e.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);

        if(source == button1){
            speed = parseInt(textField.getText());
            quantity = parseInt(textField2.getText());
            rounds = parseInt(textField3.getText());
            food = parseInt(textfood.getText());
            wood = parseInt(textwood.getText());
            stone = parseInt(textstone.getText());
            iron = parseInt(textiron.getText());
            refresh = parseInt(textrefresh.getText());
            buttonclicked=true;
            win.dispose();
        }
        else{
            buttonclicked=false;
        }

    }
}