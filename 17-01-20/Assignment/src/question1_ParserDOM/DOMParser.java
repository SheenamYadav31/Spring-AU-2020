package question1_ParserDOM;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*; 

public class DOMParser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//Build Document
		Document document = builder.parse(new File("hospitals.xml"));
		
		document.getDocumentElement().normalize();
		
		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());
		
		NodeList nList = document.getElementsByTagName("hospital");
		System.out.println("-------------------------");
		
		for(int index=0; index<nList.getLength(); index++) {
			Node node = nList.item(index);
			System.out.println(index+". ");
			if(node.getNodeType()==Node.ELEMENT_NODE)
			{
				Element hEle = (Element) node;
				System.out.println("Hospital id: "+ hEle.getAttribute("id"));
				System.out.println("Hospital Name: "+ hEle.getElementsByTagName("Hospital_Name").item(0).getTextContent());
				System.out.println("Location: "+ hEle.getElementsByTagName("Location").item(0).getTextContent());
				System.out.println("District: "+ hEle.getElementsByTagName("District").item(0).getTextContent());
				System.out.println("State: "+ hEle.getElementsByTagName("State").item(0).getTextContent());
				System.out.println("Pincode:  "+ hEle.getElementsByTagName("Pincode").item(0).getTextContent());
			}
			System.out.println(((root.getFirstChild().getNodeValue())));
		}

	}

}
