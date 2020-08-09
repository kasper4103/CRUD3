/*
*
*Copyright (c) 2020, pcschool
*/

package tw.com.pcschool.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author  EricYang
 *  課程大綱:
 *
*/

@NamedQuery(name="testNamedQuery",query = "SELECT c FROM Customer c where c.id=?")
@Table(name = "JPA5_Customer")
@Entity
public class Customer {
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	@Column(name ="NAME" )
	
	private String lastName;
	private String email;
	private int age;
	
	
	public Customer(String lastName, int age) {
		super();
		this.lastName = lastName;
		this.age = age;
	}

	public Customer() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", lastName=" + lastName + ", email=" + email + ", age=" + age + "]";
	}
	
	
	
}
