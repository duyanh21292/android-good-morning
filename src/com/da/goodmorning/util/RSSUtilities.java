package com.da.goodmorning.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class RSSUtilities {
	
	public static String getImgSrc(String html){
        if (!html.toLowerCase().contains("<img") || !html.toLowerCase().contains("src="))
            return "";
        
        String src = "";
        String imgString = html.substring(html.toLowerCase().indexOf("<img"));
        String srcString = imgString.substring(imgString.toLowerCase().indexOf("src=")+4,imgString.toLowerCase().indexOf(">"));
        if (srcString.contains("'"))
            src = srcString.split("'")[1];
        else if (srcString.contains("\""))
            src = srcString.split("\"")[1];
        
        return src;
    }
	
	public static InputStream loadImageFromURL(String url) {
		InputStream is = null;
		try {
			URL myFileURL = new URL(url);
			HttpsURLConnection conn = (HttpsURLConnection) myFileURL.openConnection();
			conn.setDoInput(true);
			conn.connect();
			is = conn.getInputStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return is;
	}
}
