package com.two8g.swissarmy.CutyCapt4J;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

/**
 * Created by two8g on 16-5-31.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Option {
	@Wither
	private String url;
	@Wither
	private String out;
	private Format outFormat;

	private Integer minWidth;//Minimal width for the image (default: 800)
	private Integer minHeight;//Minimal height for the image (default: 600)
	private Integer maxWait;//Don't wait more than (default: 90000, inf: 0)
	private Integer delay;//After successful load, wait (default: 0)

	private Method method;
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
	private Boolean zoomFactor;
	private Boolean zoomTextOnly;

	private String httpProxy;

	public String[] getCutyCaptCommand(){
		return null;
	}

}
