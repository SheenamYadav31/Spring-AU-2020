package question1_ParserSAX;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {
	
	private List<Hospital> hospitalList = null;
	private Hospital hos = null;
	private StringBuilder data = null;
	
	public List<Hospital> getHospitalList(){
		return hospitalList;
	}
	
	boolean b_location =false;
	boolean b_hospitalName=false;
	boolean b_state=false;
	boolean b_district=false;
	boolean b_pincode=false;
	boolean b_stateId=false;
	boolean b_districtId=false;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		if(qName.equalsIgnoreCase("hospital")) {
			String id = attributes.getValue("id");
			Hospital hos = new Hospital();
			hos.setId(Integer.parseInt(id));
			if(hospitalList==null) hospitalList = new ArrayList<>();
			else if (qName.equalsIgnoreCase("Location")) {
				b_location = true;
			}
			else if (qName.equalsIgnoreCase("Hospital_Name")) {
				b_hospitalName = true;
			}
			else if (qName.equalsIgnoreCase("State")) {
				b_state = true;
			}
			else if (qName.equalsIgnoreCase("District")) {
				b_district = true;
			}
			else if (qName.equalsIgnoreCase("Pincode")) {
				b_pincode = true;
			}
			else if (qName.equalsIgnoreCase("State_ID")) {
				b_stateId = true;
			}
			else if (qName.equalsIgnoreCase("District_ID")) {
				b_districtId = true;
			}
			data = new StringBuilder();
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException{
		data.append(new String (ch, start, length));
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(b_location) {
			hos.setLocation(data.toString());
		}
		else if(b_hospitalName) {
			hos.setHospitalName(data.toString());
		}
		else if(b_state) {
			hos.setState(data.toString());
		}
		else if(b_district) {
			hos.setDistrict(data.toString());
		}
		else if(b_pincode) {
			hos.setPincode(Integer.parseInt(data.toString()));
		}
		else if(b_stateId) {
			hos.setStateId(Integer.parseInt(data.toString()));
		}
		else if(b_districtId) {
			hos.setDistrictId(Integer.parseInt(data.toString()));;
		}
	}
	
	
}
