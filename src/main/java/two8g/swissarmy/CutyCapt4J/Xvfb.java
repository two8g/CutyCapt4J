package two8g.swissarmy.CutyCapt4J;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;

/**
 * Created by two8g on 16-6-3.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Xvfb {
    private File xvfb;

    public int run(File xvfb, XvfbArgs xvfbArgs) throws IOException {
        if (xvfbArgs.getExecutable() == null && xvfb.exists()) {
            xvfbArgs = xvfbArgs.withExecutable(xvfb);
        }
        String[] commands = xvfbArgs.getXvfbCommand();
        Process p = Runtime.getRuntime().exec(commands);

        try {
            p.waitFor();
            return p.exitValue();
        } catch (InterruptedException ie) {
            throw new IOException("An error occured while waiting for Xvfb to exit", ie);
        }
    }

    public int run(File xvfb, XvfbArgs xvfbArgs, String[] commands) throws IOException {
        if (xvfbArgs.getExecutable() == null && xvfb.exists()) {
            xvfbArgs = xvfbArgs.withExecutable(xvfb);
        }
        if (xvfbArgs.getCommands() == null && commands != null && commands.length > 0) {
            xvfbArgs = xvfbArgs.withCommands(commands);
        }
        String[] xvfbCommands = xvfbArgs.getXvfbCommand();
        Process p = Runtime.getRuntime().exec(xvfbCommands);

        try {
            p.waitFor();
            return p.exitValue();
        } catch (InterruptedException ie) {
            throw new IOException("An error occured while waiting for Xvfb to exit", ie);
        }
    }

}
