package interceptor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.logging.Level;


public class Logger {
    /**
     *
     * Record the action of the player eating beans to "EatBeans.log" file
     * @param context a context object provide method to access the framework's internal state
     * @throws if find/create the "EatBeans.log" file then throw a Exception
     */
    public void logEatBeans(I_Context context) throws IOException {
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("EatBeans.log", true))) {
            bw.write(context.getDescription());
            bw.newLine();
        } catch(IOException e) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).
                    log(Level.WARNING, "Fail: BufferedWriter", e);
        }
    }
}
