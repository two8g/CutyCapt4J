package com.two8g.swissarmy.CutyCapt4J;

/**
 * Created by two8g on 16-5-31.
 */
public enum Format {
    PNG("png"),
    PDF("pdf"),
    PS("ps"),
    SVG("svg"),
    JPEG("jpeg"),
    ITEXT("itext"),
    HTML("html"),
    RTREE("rtree"),
    MNG("mng"),
    TIFF("tiff"),
    GIF("gif"),
    BMP("bmp"),
    PPM("ppm"),
    XBM("xbm"),
    XPM("xpm");
    String format;

    private Format(String format) {
        setFormat(format);
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
