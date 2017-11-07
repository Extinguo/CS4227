/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerplayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Magd
 */
public class Row extends JPanel {

    JLabel idLabel;
    JTextField nameField;
    JButton colorChooserButton; 
    JColorChooser colorChooser;
    Color color;
    JButton upButton;
    JButton downButton;
    JButton rightButton;
    JButton leftButton;
    JComboBox playerMode;
    JSpinner lifeSpinner;

    /**
     * Creates a JPanel which contains a row. The row contains information about
     * a new player. E.g. The PlayerID, name, color, movement-commands It also
     * contains the information of how to remove/add players.
     *
     * @param playerID The playerID. It is the same as the index of the row /
     * rownumber.
     * @param defaultName The default name of a player
     * @param defaultColor The default color of a player
     * @param defaultUp The default up-command of a player
     * @param defaultDown The default down-command of a player
     * @param defaultLeft The default left-command of a player
     * @param defaultRight The default right-command of a player
     * @param playerOptions An Array containing the possible playermodes. Note: The object in the array has to override toString()
     */
    public Row(int playerID, String defaultName, Color defaultColor, 
            char defaultUp, char defaultDown, char defaultLeft, char defaultRight,
            String[] playerOptions) {

        initialiseMembervariables(playerID, defaultName, defaultColor, 
                defaultUp, defaultDown, defaultLeft, defaultRight, 
                playerOptions);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        this.add(idLabel);
        this.add(nameField);
        this.add(colorChooserButton);
        this.add(upButton);
        this.add(downButton);
        this.add(leftButton);
        this.add(rightButton);
        this.add(playerMode);
        this.add(lifeSpinner);
    }

    /**
     * 
     * @param playerID The playerID. It is the same as the index of the row /
     * rownumber.
     * @param name The players name
     * @param color His color
     * @param up The Key to let the player go up
     * @param down The Key to let the player go down
     * @param left The Key to let the player go left
     * @param right The Key to let the player go right
     * @param playerOptions An Array containing the possible playermodes. Note: The object in the array has to override toString()
     */
    private void initialiseMembervariables(int playerID, String name, Color color, 
            char up, char down, char left, char right,
            String[] playerOptions) {
        idLabel      = new JLabel(Integer.toString(playerID));
        nameField    = new JTextField(name);
        colorChooserButton = new JButton("Color");
        this.color   = color;
        colorChooser = new JColorChooser(color);
        upButton     = new JButton(Character.toString(up));
        downButton   = new JButton(Character.toString(down));
        leftButton   = new JButton(Character.toString(left));
        rightButton  = new JButton(Character.toString(right));
        playerMode   = new JComboBox(playerOptions);
        
        SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 99, 1);
        lifeSpinner  = new JSpinner(spinnerModel);
        
        nameField.setPreferredSize(new Dimension(75, 25));
        
        colorChooserButton.addActionListener((evt)->{
            this.color = JColorChooser.showDialog(colorChooser, "Pick a color", colorChooser.getColor());
            colorChooser.setColor(color);
        });
        
        upButton.addKeyListener(new CommandChangerListener());
        downButton.addKeyListener(new CommandChangerListener());
        leftButton.addKeyListener(new CommandChangerListener());
        rightButton.addKeyListener(new CommandChangerListener());
        
        JMenuItem item = new JMenuItem("+Speed");
        playerMode.add(item);
        
    }
    
    /**
     * This listener changes the text of the buttons which indicate, with which
     * button the player moves.
     */
    private class CommandChangerListener implements KeyListener {
        JButton source = null;

        @Override
        public void keyTyped(KeyEvent e) {
            /*
            No need to implement it since we want the listener to only do something,
            when a key is pressed. No different actions needed, when it is released.
             */
        }

        @Override
        public void keyPressed(KeyEvent e) {
            source = (JButton)e.getSource();
            char newCommand = e.getKeyChar();
            
            if(e.getKeyCode() != KeyEvent.VK_ESCAPE) {
                source.setText(Character.toString(newCommand));
                source.setFocusable(false);
                source.setFocusable(true);
            } else {
                source.setFocusable(false);
                source.setFocusable(true);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            /*
            No need to implement it since we want the listener to only do something,
            when a key is pressed. No different actions needed, when it is released.
            */
        }
        
    } // End of CommandChanger
    
    public String getPlayername() {
        return nameField.getText();
    }
    
    public Color getColor() {
        return color;
    }
    
    public char getUpChar() {
        return upButton.getText().charAt(0);
    }
    public char getDownChar() {
        return downButton.getText().charAt(0);
    }
    public char getLeftChar() {
        return leftButton.getText().charAt(0);
    }
    public char getRightChar() {
        return rightButton.getText().charAt(0);
    }
    
    public String getPlayerType() {
        return (String)playerMode.getSelectedItem();
    }
    
    public int getLifes() {
        return (int) lifeSpinner.getValue();
    }
    
    public void setPlayerID(int id) {
        idLabel.setText(Integer.toString(id));
    }
}
