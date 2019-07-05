package com.davepdev.testdome;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * 
 * @author davepdev
 * score: 33% - test reports wrong answer on: 
 *        - All folder names start with starting letter (seems like this does work)
 *        - Complicated folder structure
 * 
 * Implement a function folderNames, which accepts a string containing an 
 * XML file that specifies folder structure and returns all folder names that 
 * start with startingLetter.
 *
 */

public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
    	List<String> folders= new ArrayList<String>();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = (Document) db.parse(new InputSource(new StringReader(xml)));
		
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();


		String exp = "//folder[starts-with(@name, 'u')]";
		NodeList nodeList = (NodeList) xpath.compile(exp).evaluate(document, XPathConstants.NODESET);
		Node node = null;
		for (int i = 0; i < nodeList.getLength(); i++ ) {
			if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
				node = nodeList.item(i);
				folders.add(node.getAttributes().getNamedItem("name").getTextContent());
			}
		}
		System.out.println(folders);
		    	
    	return folders;
    	
    }
    
    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<folder name=\"c\">" +
                    "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                    "</folder>" +
                    "<folder name=\"users\" />" +
                "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
    }
}
