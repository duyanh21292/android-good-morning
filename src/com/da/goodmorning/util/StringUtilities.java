package com.da.goodmorning.util;

public class StringUtilities {
	
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
}
