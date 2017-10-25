package Interceptor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by viola on 2017/10/20.
 */
public class Logger {

    public void logEatBeans(I_Context context) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter("EatBeans.log", true));
        bw.write(context.getDescription());
        bw.newLine();
        bw.close();

    }
}
