package com.revature.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Listing implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(unique = true)
	@NotNull
	int userId;
	
	@NotNull
	String address;
	
	@Digits(integer=7, fraction=2)
	BigDecimal rentPrice;
	
	String descripton;
	
	@NotNull
	boolean isActive;
	
	String pictureUrl;

	public Listing() {
		super();
	}

	public Listing(int id, int userId, String address, BigDecimal rentPrice, String descripton, boolean isActive) {
		super();
		this.id = id;
		this.userId = userId;
		this.address = address;
		this.rentPrice = rentPrice;
		this.descripton = descripton;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(BigDecimal rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getDescripton() {
		return descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((descripton == null) ? 0 : descripton.hashCode());
		result = prime * result + id;
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((pictureUrl == null) ? 0 : pictureUrl.hashCode());
		result = prime * result + ((rentPrice == null) ? 0 : rentPrice.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Listing other = (Listing) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (descripton == null) {
			if (other.descripton != null)
				return false;
		} else if (!descripton.equals(other.descripton))
			return false;
		if (id != other.id)
			return false;
		if (isActive != other.isActive)
			return false;
		if (pictureUrl == null) {
			if (other.pictureUrl != null)
				return false;
		} else if (!pictureUrl.equals(other.pictureUrl))
			return false;
		if (rentPrice == null) {
			if (other.rentPrice != null)
				return false;
		} else if (!rentPrice.equals(other.rentPrice))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Listing [id=" + id + ", userId=" + userId + ", address=" + address + ", rentPrice=" + rentPrice
				+ ", descripton=" + descripton + ", isActive=" + isActive + ", pictureUrl=" + pictureUrl + "]";
	}


}
