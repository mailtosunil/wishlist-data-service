package com.wishlist.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WISHLIST_TELEVISION_INFO")
public class Television implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="WISHLIST_TELEVISION_SEQ", strategy=GenerationType.SEQUENCE)
	@Column(name="ITEM_ID")
	private Integer id;
	@Column(name="ITEM_NAME")
	private String name;
	@Column(name="ITEM_DESC")
	private String desc;
	@Column(name="ITEM_PRICE")
	private Double price;
	public Television() {
		super();
	}
	public Television(Integer id, String name, String desc, Double price) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
