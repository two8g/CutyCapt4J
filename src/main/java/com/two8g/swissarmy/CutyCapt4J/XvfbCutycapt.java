package com.two8g.swissarmy.CutyCapt4J;

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
public class XvfbCutycapt {
	private File xvfbFile;
	private File cutycaptFile;

	public int run(Options options, XvfbArgs xvfbArgs) throws IOException {
		if (options == null) {
			throw new RuntimeException("curycapt options is illegal, can't be null.");
		}
		if (options.getExecutable() == null) {
			options = options.withExecutable(cutycaptFile);
		}

		options.verify();

		if (xvfbArgs != null && xvfbArgs.getExecutable() == null) {
			xvfbArgs = xvfbArgs.withExecutable(xvfbFile);
		}
		xvfbArgs = xvfbArgs.withCommands(options.getCutyCaptCommand());

		String[] command = xvfbArgs.getXvfbCommand();
		Process p = Runtime.getRuntime().exec(command);

		try {
			p.waitFor();
			return p.exitValue();
		} catch (InterruptedException ie) {
			throw new IOException("An error occured while waiting for Cutycapt to exit", ie);
		}
	}
}
