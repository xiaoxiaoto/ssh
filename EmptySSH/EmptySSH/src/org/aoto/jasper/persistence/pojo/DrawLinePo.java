package org.aoto.jasper.persistence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DRAWLINE")
public class DrawLinePo {
	 private String eventid;
	 private String modelname;
	 private String modelid;
	 
	 @Id
	 @Column(length=255,unique=true,nullable=false)
	public String getEventid() {
		return eventid;
	}
	public void setEventid(String eventid) {
		this.eventid = eventid;
	}
	@Column(length=255,nullable=false)
	public String getModelname() {
		return modelname;
	}
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	@Column(length=255,nullable=false)
	public String getModelid() {
		return modelid;
	}
	public void setModelid(String modelid) {
		this.modelid = modelid;
	}
	public DrawLinePo(String eventid, String modelname, String modelid) {
		super();
		this.eventid = eventid;
		this.modelname = modelname;
		this.modelid = modelid;
	}
	public DrawLinePo() {
		super();
	}
	@Override
	public String toString() {
		return "drawLinePo [eventid=" + eventid + ", modelname=" + modelname
				+ ", modelid=" + modelid + "]";
	}
}
