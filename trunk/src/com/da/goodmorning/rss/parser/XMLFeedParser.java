package com.da.goodmorning.rss.parser;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import com.da.goodmorning.rss.Feed;

public class XMLFeedParser {
	private static final String TITLE = "title";
	private static final String DESCRIPTION = "description";
	private static final String LINK = "link";
	private static final String PUB_DATE = "pubDate";
	private static final String GUID = "guid";
	private static final String ITEM = "item";
	
	private Document doc;
	
	public XMLFeedParser(String url) {
		// TODO Auto-generated constructor stub
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(getXmlFromUrl(url)));
            this.doc = db.parse(is);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Feed> getListFeeds() {
		List<Feed> listFeed = new ArrayList<Feed>();
        if (doc != null) {
        	NodeList nodeList = doc.getElementsByTagName(ITEM);
        	for (int i = 0; i < nodeList.getLength(); i++) {
    			Element item = (Element) nodeList.item(i);
    			listFeed.add(fetchData(item));
    		}
        }
		return listFeed;
	}
	
	private Feed fetchData(Element item) {
		Feed f = new Feed();
		NodeList nodeList = item.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node attrNode = nodeList.item(i);
			if(attrNode.getNodeName().equals(TITLE)) {
				f.setTitle(attrNode.getTextContent());
			} else if (attrNode.getNodeName().equals(DESCRIPTION)) {
				f.setDescription(attrNode.getTextContent());
			} else if (attrNode.getNodeName().equals(PUB_DATE)) {
				f.setPubDate(attrNode.getTextContent());
			} else if (attrNode.getNodeName().equals(LINK)) {
				f.setLink(attrNode.getTextContent());
			} else if (attrNode.getNodeName().equals(GUID)) {
				f.setGuid(attrNode.getTextContent());
			} 
		}
		return f;
	}
	
	private String getXmlFromUrl(String urlString) {
		String xml = "";
        try {
        	DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(urlString);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
			xml = EntityUtils.toString(httpEntity);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xml;
	}
}
