/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerplayer;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import player.Player;


/**
 *
 * @author Magd
 */
public class RegisterPlayer {
    
    private JDialog dialog;
    private JPanel panel;
    private List<Row> rows;
    private String[] playerOptions;

    /**
     * Creates a frame which allows the user to specify the number of players and
     * individualize the players. It creates one row with default values.
     * @param playerOptions An Array containing the possible playermodes. Note: The object in the array has to override toString()
     */
    public RegisterPlayer(String[] playerOptions, JFrame parent) {
        this.playerOptions = playerOptions;
        
        dialog = new JDialog(parent, "Register Users", true);
        panel = new JPanel();
        rows = new ArrayList<>();
        
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
           
        panel.add(createHeaderPanel());
        addNewDefaultRow();
        
        dialog.add(panel);
        dialog.setSize(600, 150);
        dialog.setLocationRelativeTo(null);
        dialog.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
        System.out.println("Modal: " + dialog.isModal());
    }
    
    
    
    
    /**
     * This method creates a panel, which contains titles to. It will be shown 
     * above the normal rows and cannot be deleted.
     * It also contains the button to add and remove rows.
     * @return The Panel, which contains a all the headers/titles and buttons
     */
    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER, 52, 5));
        header.add(new JLabel("Name"));
        header.add(new JLabel("Color"));
        header.add(new JLabel("The Control Buttons"));
        header.add(new JLabel("Playertype"));
        header.add(new JLabel("Lifes"));
        
        JButton addButton = new JButton("+");
        addButton.addActionListener((evt)-> addNewDefaultRow() );
        
        JButton deleteButton = new JButton("-");
        deleteButton.addActionListener((evt)-> deleteRow());
        
        header.add(addButton);
        header.add(deleteButton);
        return header;
    }
    
    /**
     * Adds a new row with default values to the paneö
     */
    private void addNewDefaultRow() {
        Row row = new Row(rows.size(), "Bob", Color.YELLOW,
                'w', 'a', 's', 'd',
                playerOptions);
        rows.add(row);
        
        panel.add(row);
        dialog.setSize(dialog.getWidth(), dialog.getHeight()+50);
    }
    
    /**
     * Deletes a row from the panel. 
     * Note: This method asks the user to specify which row and then calls deleteRow(givenIndex)
     * Before doing this it makes sure, that the index is bigger or equal to 0 and that the index is within the size of the rows.
     */
    private void deleteRow() {
        int index = -1;
        try {
            index = Integer.parseInt(JOptionPane.showInputDialog(dialog, "Which playerID do you want to delete?", "-1"));
        } catch(Exception e) {
            Logger.getLogger(RegisterPlayer.class.getName()).log(Level.INFO, "NaN");
        }
        
        if(index >= 0 && index < rows.size()) {
            deleteRow(index);
        }
    }
    
    /**
     * Deletes the row with the given index
     * @param index The index of the row, which will be deleted
     */
    private void deleteRow(int index) {
        Row toRemove = rows.get(index);
        panel.remove(toRemove);
        rows.remove(toRemove);

        for (int i = 0; i < rows.size(); i++) {
            Row r = rows.get(i);
            r.setPlayerID(i);
        }
        dialog.setSize(dialog.getWidth(), dialog.getHeight() - 50);
    }
    
    public void setVisible(boolean status) {
        dialog.setVisible(status);
    }
    
    /**
     * This method creates an arraylist with all player that were specified by the user.
     * @return An ArrayList<Player> containing all players.
     */
    public ArrayList<Player> createPlayers() throws ClassNotFoundException {
        ArrayList<Player> players = new ArrayList<>();
        
//        Player playerWithSpeed = PlayerFactory.createNewPlayerWithSpeed("bob", 4, 4, xx * BLOCKSIZE + 3, yy * BLOCKSIZE + 3, BLOCKSIZE - 8, BLOCKSIZE - 8);
//        playerWithSpeed.accept(themeVisitor);
//
//        ((Speed) (playerWithSpeed)).setWallCollision(new WallCollisionDetection(this));
//        ((Speed) (playerWithSpeed)).setBeanCollision(new BeanCollisionDetection(this));
//        playerWithSpeed.setNum(count++);
        
        String name = "";
        Color color = null;
        char upCommandKey = ' ';
        char downCommandKey = ' ';
        char leftCommandKey = ' ';
        char rightCommandKey = ' ';
        String playerTyp = "";
        int lifes = -1;      
        
        for(Row r : rows) {
            name = r.getPlayername();
            color = r.getColor();
            upCommandKey = r.getUpChar();
            downCommandKey = r.getDownChar();
            leftCommandKey = r.getLeftChar();
            rightCommandKey = r.getRightChar();
            playerTyp = r.getPlayerType();
            lifes = r.getLifes();
        }
        return players;
    }
}
