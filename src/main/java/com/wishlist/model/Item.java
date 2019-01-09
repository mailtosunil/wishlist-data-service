package com.wishlist.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WISHLIST_ITEMS")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "WISHLIST_ITEM_SEQ", strategy = GenerationType.SEQUENCE)
	@Column(name = "ITEM_ID")
	private Integer id;
	@Column(name = "ITEM_TYPE")
	private String type;
	@Column(name = "ITEM_VALUE")
	private Double value;
	@Column(name = "ITEM_IMG_URL")
	private String imgUrl;
	@Column(name = "ITEM_DESC")
	private String desc;
	
	

	public Item() {
		super();
	}

	public Item(Integer id, String type, Double value, String imgUrl, String desc) {
		super();
		this.id = id;
		this.type = type;
		this.value = value;
		this.imgUrl = imgUrl;
		this.desc = desc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String toString() {
		return "[" + getId() + ", " + getType() + ", " + getDesc() + "]";
	}
}
