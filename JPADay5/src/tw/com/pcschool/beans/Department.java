/*
*
*Copyright (c) 2020, pcschool 
*/

package tw.com.pcschool.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
*
*@author Lee
* 課程大綱:
*/
@Table(name="JPA5_Department")
@Entity
public class Department {
	@GeneratedValue
	@Id
	private Integer Id;
	private String deptName;
	@JoinColumn(name="MGR_ID",unique = true)
	@OneToOne
	private Manager mgr;
	public Department() {
		super();
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Manager getMgr() {
		return mgr;
	}
	public void setMgr(Manager mgr) {
		this.mgr = mgr;
	}
	
	
}
