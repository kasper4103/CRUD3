/*
*
*Copyright (c) 2020, pcschool
*/

package tw.com.pcschool.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author  EricYang
 *  課程大綱:
 *
*/
@Table(name="JPA5_Item")
@Entity
public class Item {
	@GeneratedValue
	@Id
	private Integer id;
	@Column(name="ITEM_Name")
	private String itemName;
	
	@JoinTable(name="ITEM_CATEGORY",
			joinColumns ={@JoinColumn(name="ITEM_ID",referencedColumnName = "ID")},
			inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID",referencedColumnName = "ID")})
	@ManyToMany
	private Set<Category> categorys=new HashSet<Category>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Set<Category> getCategorys() {
		return categorys;
	}
	public void setCategorys(Set<Category> categorys) {
		this.categorys = categorys;
	}
	
}
