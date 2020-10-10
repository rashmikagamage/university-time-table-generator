package genModel;

public class SessionRoomModel {
	String id,session,room;

	public SessionRoomModel(String id, String session, String room) {
		super();
		this.id = id;
		this.session = session;
		this.room = room;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
	

}
