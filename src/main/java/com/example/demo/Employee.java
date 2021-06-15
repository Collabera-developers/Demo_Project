package com.example.demo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends AuditModel implements Serializable {

	private static final long serialVersionUID = 4106806749008688900L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eid;
	private String name;
	private Boolean SalaryPaid;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="laptop_id", referencedColumnName = "lid")
	private Laptop laptop;

	@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name="phone_id", referencedColumnName = "pid")
	private Set<Phone> ph = new HashSet<>();
	

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}


	public Set<Phone> getPh() {
		return ph;
	}

	public void setPh(Set<Phone> ph) {
		this.ph = ph;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSalaryPaid() {
		return SalaryPaid;
	}

	public void setSalaryPaid(Boolean salaryPaid) {
		SalaryPaid = salaryPaid;
	}

}
