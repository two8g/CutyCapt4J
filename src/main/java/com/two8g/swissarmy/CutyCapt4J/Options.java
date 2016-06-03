package com.two8g.swissarmy.CutyCapt4J;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by two8g on 16-5-31.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Options {
	@Wither
	private File executable;
	@Wither
	private URL url;
	@Wither
	private File out;
	private Format outFormat;

	private Integer minWidth;//Minimal width for the image (default: 800)
	private Integer minHeight;//Minimal height for the image (default: 600)
	private Integer maxWait;//Don't wait more than (default: 90000, inf: 0)
	private Integer delay;//After successful load, wait (default: 0)

	private Method requestMethod;//Specifies the request method (default: get)
	private String userStylePath;
	private String userStyleString;
	private String head;
	private String bodyString;
	private String bodyBase64;

	private String appName;
	private String appVersion;
	private String userAgent;

	private Boolean javascript;
	private Boolean java;
	private Boolean plugins;
	private Boolean privateBrowsing;
	private Boolean autoLoadImages;
	private Boolean jsCanOpenWindows;
	private Boolean jsCanAccessClipboard;
	private Boolean printBackgrounds;
	private Float zoomFactor;
	private Boolean zoomTextOnly;

	private URL httpProxy;

	public String[] getCutyCaptCommand() {
		List<String> commandSegments = new ArrayList();
		commandSegments.add(executable.getAbsolutePath());

		commandSegments.add(getURL(url, "--url"));
		commandSegments.add(getFile(out, "--out"));
		commandSegments.add(getFormat(outFormat, "--out-format"));
		commandSegments.add(getInteger(minWidth, "--min-width"));
		commandSegments.add(getInteger(minHeight, "--min-height"));
		commandSegments.add(getInteger(maxWait, "--max-wait"));
		commandSegments.add(getInteger(delay, "--delay"));

		commandSegments.add(getMethod(requestMethod, "--method"));
		commandSegments.add(getString(userStylePath, "--user-style-path"));
		commandSegments.add(getString(userStyleString, "--user-style-string"));
		commandSegments.add(getString(head, "--head"));
		commandSegments.add(getString(bodyString, "--body-string"));
		commandSegments.add(getString(bodyBase64, "--body-base64"));
		commandSegments.add(getString(appName, "--app-name"));
		commandSegments.add(getString(appVersion, "--app-version"));
		commandSegments.add(getString(userAgent, "--user-agent"));

		commandSegments.add(getBoolean(javascript, "--javascript"));
		commandSegments.add(getBoolean(java, "--java"));
		commandSegments.add(getBoolean(plugins, "--plugins"));
		commandSegments.add(getBoolean(privateBrowsing, "--private-browsing"));
		commandSegments.add(getBoolean(autoLoadImages, "--auto-load-images"));
		commandSegments.add(getBoolean(jsCanOpenWindows, "--js-can-open-windows"));
		commandSegments.add(getBoolean(jsCanAccessClipboard, "--js-can-access-clipboard"));
		commandSegments.add(getBoolean(printBackgrounds, "--print-backgrounds"));
		commandSegments.add(getFloat(zoomFactor, "--zoom-factor"));
		commandSegments.add(getBoolean(zoomTextOnly, "--zoom-text-only"));

		commandSegments.add(getURL(httpProxy, "--http-proxy"));

		Iterator<String> iter = commandSegments.iterator();
		while (iter.hasNext()) {
			if (StringUtils.isBlank(iter.next())) {
				iter.remove();
			}
		}

		String[] result = new String[commandSegments.size()];
		commandSegments.toArray(result);
		return result;
	}

	private String getFloat(Float zoomFactor, String name) {
		if (zoomFactor != null) {
			return name + "=" + zoomFactor;
		}
		return "";
	}

	private String getMethod(Method requestMethod, String name) {
		if (requestMethod != null) {
			return name + "=" + requestMethod.getMethod();
		}
		return "";
	}

	private String getFormat(Format outFormat, String name) {
		if (outFormat != null) {
			return name + "=" + outFormat.getFormat();
		}
		return "";
	}

	private String getBoolean(Boolean flag, String name) {
		if (flag != null) {
			return name + "=" + (flag ? "on" : "off");
		}
		return "";
	}

	private String getInteger(Integer value, String name) {
		if (value != null) {
			return name + "=" + value.toString();
		}
		return "";
	}

	private String getString(String value, String name) {
		if (!StringUtils.isBlank(value)) {
			return name + "=" + value;
		}
		return "";
	}

	private String getFile(File file, String name) {
		if (file != null) {
			return name + "=" + file.getAbsolutePath();
		}
		return "";
	}

	private String getURL(URL url, String name) {
		if (url != null) {
			return name + "=" + url.toString();
		}
		return "";
	}


}