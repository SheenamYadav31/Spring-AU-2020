package question1_ParserSAX;

public class Hospital {
	private int id;
	private String location;
	private String hospitalName;
	private String state;
	private String district;
	private int pincode;
	private int stateId;
	private int districtId;
	
	public int getId() {
		return id;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getHospitalName() {
		return hospitalName;
	}
	
	public String getState() {
		return state;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public int getPincode() {
		return pincode;
	}
	
	public int getStateId() {
		return stateId;
	}
	
	public int getDistrictId() {
		return districtId;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	public void setState(String state ) {
		this.state = state;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public void setPincode(int pincode) {
		this.pincode=pincode;
	}
	
	public void setStateId(int stateId) {
		this.stateId=stateId;
	}
	
	public void setDistrictId(int districtId) {
		this.districtId=districtId;
	}

	@Override
	public String toString() {
		return "HOSPITAL : Id->"+this.id+"; Name->"+this.hospitalName+" State->"+this.state+" District->"+this.district+" Pincode->"+this.pincode+" State_Id->"+this.stateId+" District_Id->"+this.districtId;
	}

}

