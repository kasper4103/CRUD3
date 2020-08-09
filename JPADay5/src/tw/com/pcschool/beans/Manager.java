/*
*
*Copyright (c) 2020, pcschool
*/

package tw.com.pcschool.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author EricYang 課程大綱:
 *
 */

@Table(name = "JPA5_Manager")
@Entity
public class Manager {
	@GeneratedValue
	@Id
	private Integer id;
	@Column(name="MGR_NAME")
	private String mgrName;
	
	@OneToOne(mappedBy ="mgr" ,fetch = FetchType.EAGER)
	private Department dept;

	public Manager() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMgrName() {
		return mgrName;
	}

	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

}
