package com.two8g.swissarmy.CutyCapt4J;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by two8g on 16-6-3.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class XvfbArgs {
	@Wither
	private File executable;
	@Wither
	private String[] commands;

	private Boolean autoServerNum;
	private String serverArgs;

	private Integer serverNum;
	private Boolean listenTcp;
	private String xauthProtocol;

	private File errorFile;
	private File authFile;


	public String[] getXvfbCommand() {
		List<String> commandSegments = new ArrayList();
		commandSegments.add(executable.getAbsolutePath());

		if (autoServerNum != null && autoServerNum) {
			commandSegments.add("-a");
		}

		if (errorFile != null) {
			commandSegments.add("-e " + errorFile.getAbsolutePath());
		}

		if (authFile != null) {
			commandSegments.add("-f " + authFile.getAbsolutePath());
		}

		if (serverNum != null) {
			commandSegments.add("-n " + serverNum);
		}

		if (listenTcp != null && listenTcp) {
			commandSegments.add("-l");
		}

		if (xauthProtocol != null && !StringUtils.isBlank(xauthProtocol)) {
			commandSegments.add("-p " + xauthProtocol);
		}

		if (serverArgs != null && !StringUtils.isBlank(serverArgs)) {
			commandSegments.add("-s " + serverArgs);
		}

		Iterator<String> iter = commandSegments.iterator();
		while (iter.hasNext()) {
			if (StringUtils.isBlank(iter.next())) {
				iter.remove();
			}
		}

		String[] result = new String[commandSegments.size()];
		commandSegments.toArray(result);

		if (commands != null && commands.length > 0) {
			result = ArrayUtils.addAll(result, commands);
		}

		return result;
	}
}
