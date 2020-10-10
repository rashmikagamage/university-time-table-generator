package Model;

public class timeSlots {

	String idTs,slotType,startHour,startMinte,endHour,endMinute,workHour,workMinute;

	public timeSlots(String idTs, String slotType, String startHour, String startMinte, String endHour,
			String endMinute, String workHour, String workMinute) {
		super();
		this.idTs = idTs;
		this.slotType = slotType;
		this.startHour = startHour;
		this.startMinte = startMinte;
		this.endHour = endHour;
		this.endMinute = endMinute;
		this.workHour = workHour;
		this.workMinute = workMinute;
	}

	public String getIdTs() {
		return idTs;
	}

	public void setIdTs(String idTs) {
		this.idTs = idTs;
	}

	public String getSlotType() {
		return slotType;
	}

	public void setSlotType(String slotType) {
		this.slotType = slotType;
	}

	public String getStartHour() {
		return startHour;
	}

	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}

	public String getStartMinte() {
		return startMinte;
	}

	public void setStartMinte(String startMinte) {
		this.startMinte = startMinte;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public String getEndMinute() {
		return endMinute;
	}

	public void setEndMinute(String endMinute) {
		this.endMinute = endMinute;
	}

	public String getWorkHour() {
		return workHour;
	}

	public void setWorkHour(String workHour) {
		this.workHour = workHour;
	}

	public String getWorkMinute() {
		return workMinute;
	}

	public void setWorkMinute(String workMinute) {
		this.workMinute = workMinute;
	}
	
	
}
