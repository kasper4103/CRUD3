/*
*
*Copyright (c) 2020, pcschool
*/

package tw.com.pcschool.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author EricYang 課程大綱:
 *
 */
@Table(name = "JPA5_Departement")
@Entity
public class Departement {
	@GeneratedValue
	@Id
	private Integer id;
	private String depName;
	@JoinColumn(name="MGR_ID",unique = true)
	@OneToOne
	private Manager mgr;

	public Departement() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Manager getMgr() {
		return mgr;
	}

	public void setMgr(Manager mgr) {
		this.mgr = mgr;
	}

}
