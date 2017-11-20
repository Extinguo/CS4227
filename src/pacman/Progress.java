package pacman;



import javax.swing.*;
import java.awt.*;

public class Progress extends JFrame{
    private JLabel jLabel;
    public Progress()
    {
        jLabel=new JLabel();
        jLabel.setIcon(new ImageIcon("Ressources/back.gif"));
        setVisible(true);
        setSize(400,320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(jLabel,BorderLayout.NORTH);

    }


}
