package genModel;

public class workDaysModel {
	String wID,wdhType,wdhNoDays,wMonday,wTuesday,wWednesday,wThursday,wFriday;

	public workDaysModel(String wID, String wdhType, String wdhNoDays, String wMonday, String wTuesday,
			String wWednesday, String wThursday, String wFriday) {
		super();
		this.wID = wID;
		this.wdhType = wdhType;
		this.wdhNoDays = wdhNoDays;
		this.wMonday = wMonday;
		this.wTuesday = wTuesday;
		this.wWednesday = wWednesday;
		this.wThursday = wThursday;
		this.wFriday = wFriday;
	}

	public String getwID() {
		return wID;
	}

	public void setwID(String wID) {
		this.wID = wID;
	}

	public String getWdhType() {
		return wdhType;
	}

	public void setWdhType(String wdhType) {
		this.wdhType = wdhType;
	}

	public String getWdhNoDays() {
		return wdhNoDays;
	}

	public void setWdhNoDays(String wdhNoDays) {
		this.wdhNoDays = wdhNoDays;
	}

	public String getwMonday() {
		return wMonday;
	}

	public void setwMonday(String wMonday) {
		this.wMonday = wMonday;
	}

	public String getwTuesday() {
		return wTuesday;
	}

	public void setwTuesday(String wTuesday) {
		this.wTuesday = wTuesday;
	}

	public String getwWednesday() {
		return wWednesday;
	}

	public void setwWednesday(String wWednesday) {
		this.wWednesday = wWednesday;
	}

	public String getwThursday() {
		return wThursday;
	}

	public void setwThursday(String wThursday) {
		this.wThursday = wThursday;
	}

	public String getwFriday() {
		return wFriday;
	}

	public void setwFriday(String wFriday) {
		this.wFriday = wFriday;
	}
	
	

}
