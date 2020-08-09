/*
*
*Copyright (c) 2020, pcschool
*/

package tw.com.pcschool.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author EricYang 課程大綱:
 *
 */
@Table(name = "JPA5_Category")
@Entity
public class Category {
	@GeneratedValue
	@Id
	private Integer id;
	private String CategoryName;
	@ManyToMany(mappedBy ="categorys")
	private Set<Item> items = new HashSet<Item>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

}
