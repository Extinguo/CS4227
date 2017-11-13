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
 */
public class Caretaker {
    
    private String latestFilename;
    private Logger logger;

    public Caretaker() {
        latestFilename = "";
        logger = Logger.getLogger(Caretaker.class.getName());
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
            logger.log(Level.INFO, "Serialized data is saved in: {0}.ser", filename);
            latestFilename = filename;
        } catch (IOException i) {
            logger.log(Level.WARNING, "IOException", i);
        }
    }
    
    /**
     * Restores a Memento from a file on the harddisk. 
     * @param filename Path/filename from the File on the harddisk
     * @return The Memento
     */
    public Model getMomento(String filename) {
        Model loadMemento = null;
        
        try( FileInputStream fileIn = new FileInputStream(filename + ".ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
        ) {
            loadMemento = (Model) in.readObject();
        } catch (IOException i) {
            logger.log(Level.INFO, "Exception", i);
        } catch (ClassNotFoundException c) {
            logger.log(Level.WARNING, "Model class not found", c);
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
