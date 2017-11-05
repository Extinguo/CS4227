/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memento;

import gui.Model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Caretaker for the Memento Pattern
 * Is responsible for the memento´s safekeeping
 * 
 * The Model class keeps all information, hence it is the Memento
 * Originator is the Controller class.
 * 
 * @author Magd
 */
public class Caretaker {
    
    private String latestFilename;

    public Caretaker() {
        latestFilename = "";
    }
    
    /**
     * Stores a memento to the given path/filename
     * @param newMemento The Memento that shall be stored. In this Case the memento is from type Model, because Model already contains all needed data.
     * @param filename The path/filename to that the memento will be stored.
     */
    public void storeMemento(Model newMemento, String filename) {
        
        try(FileOutputStream fileOut = new FileOutputStream(filename + ".ser"); 
                ObjectOutputStream out = new ObjectOutputStream(fileOut)
        ) {
            out.writeObject(newMemento);
            System.out.println("Serialized data is saved in " + filename + ".ser");
            latestFilename = filename;
        } catch (IOException i) {
            Logger.getLogger(Caretaker.class.getName()).log(Level.WARNING, "IOException", i);
            System.err.println(i);
        }
    }
    
    /**
     * Restores a Memento from a file on the harddisk. 
     * @param filename Path/filename from the File on the harddisk
     * @return The Memento
     */
    public Model getMomento(String filename) {
        System.out.println("Caretaker.getMemento(" + filename + ")");
        Model loadMemento = null;
        
        try( FileInputStream fileIn = new FileInputStream(filename + ".ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
        ) {
            loadMemento = (Model) in.readObject();
        } catch (IOException i) {
            System.err.println(i);
        } catch (ClassNotFoundException c) {
            Logger.getLogger(Caretaker.class.getName()).log(Level.WARNING, "Model class not found", c);
        }
        return loadMemento;
    }
    
    /**
     * Restores the latest created Memento.
     * Notice: This does not work if the application crashed.
     * @return The Memento if succesfull, otherwise null
     */
    public Model getLatestMemento() {
        if(latestFilename == null) {
            return null;
        }
        return getMomento(latestFilename);
    }
    
}
