package question1_ParserSAX;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import question1_ParserSAX.Hospital;
import question1_ParserSAX.MyHandler;


public class XMLParserSAX {
	
	public static void main(String[] args) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	    try {
	        SAXParser saxParser = saxParserFactory.newSAXParser();
	        MyHandler handler = new MyHandler();
	        saxParser.parse(new File("hospitals.xml"), handler);
	        List<Hospital> hospitalList = handler.getHospitalList();
	        for(Hospital hos : hospitalList)
	            System.out.println(hos);
	    } catch (ParserConfigurationException | SAXException | IOException e) {
	        e.printStackTrace();
	    	}
	    }
	}

