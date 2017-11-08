package org.aoto.tools.jdbc.persistence.vo;


public class DrawLineVo extends BaseVo {
	private String eventid;
	private String modelname;
	private String modelid;

	public String getEventid() {
		return eventid;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public String getModelid() {
		return modelid;
	}

	public void setModelid(String modelid) {
		this.modelid = modelid;
	}

	public DrawLineVo(String eventid, String modelname, String modelid) {
		super();
		this.eventid = eventid;
		this.modelname = modelname;
		this.modelid = modelid;
	}

	public DrawLineVo() {
		super();
	}

	@Override
	public String toString() {
		return "drawLinePo [eventid=" + eventid + ", modelname=" + modelname
				+ ", modelid=" + modelid + "]";
	}

}
