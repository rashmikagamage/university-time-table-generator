package Model;

public class sessionsModel {
	String id,lects,subject,code,tag,groupId,count,duration;

	public sessionsModel(String id, String lects, String subject, String code, String tag, String groupId, String count,
			String duration) {
		super();
		this.id = id;
		this.lects = lects;
		this.subject = subject;
		this.code = code;
		this.tag = tag;
		this.groupId = groupId;
		this.count = count;
		this.duration = duration;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLects() {
		return lects;
	}

	public void setLects(String lects) {
		this.lects = lects;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	

}
