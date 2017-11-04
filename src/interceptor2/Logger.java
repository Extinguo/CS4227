package interceptor2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.logging.Level;

/**
 * Created by viola on 2017/10/20.
 */
public class Logger {

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
