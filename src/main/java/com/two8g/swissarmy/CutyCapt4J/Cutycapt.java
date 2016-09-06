package com.two8g.swissarmy.CutyCapt4J;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by two8g on 16-6-3.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cutycapt {
    private File executable;

    public int run(Options options, URL url, File out) throws IOException {
        if (options.getExecutable() == null) {
            options = options.withExecutable(executable);
        }
        if (url != null) {
            options = options.withUrl(url);
        }

        if (out != null) {
            options = options.withOut(out);
        }

        options.verify();

        String[] command = options.getCutyCaptCommand();
        Process p = Runtime.getRuntime().exec(command);


        try {
            p.waitFor();
            return p.exitValue();
        } catch (InterruptedException ie) {
            throw new IOException("An error occured while waiting for Cutycapt to exit", ie);
        }
    }

}
