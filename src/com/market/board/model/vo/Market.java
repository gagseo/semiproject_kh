package com.market.board.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Market implements Serializable {

	private static final long serialVersionUID = -3760688660128740571L;
	
	private String nameCity;
	private String nameBrand;
	private String nameBusiness;
	private String adresRoad;
	private String adresNum;
	private String tell;
	private String zipcode;
	private String latitude;
	private String longitude;
	private Date dataUpdate;

	public Market() {
		super();
	}

	public Market(String nameCity, String nameBrand, String nameBusiness, String adresRoad, String adresNum,
			String tell, String zipcode, String latitude, String longitude, Date dataUpdate) {
		super();
		this.nameCity = nameCity;
		this.nameBrand = nameBrand;
		this.nameBusiness = nameBusiness;
		this.adresRoad = adresRoad;
		this.adresNum = adresNum;
		this.tell = tell;
		this.zipcode = zipcode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.dataUpdate = dataUpdate;
	}

	public String getNameCity() {
		return nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

	public String getNameBrand() {
		return nameBrand;
	}

	public void setNameBrand(String nameBrand) {
		this.nameBrand = nameBrand;
	}

	public String getNameBusiness() {
		return nameBusiness;
	}

	public void setNameBusiness(String nameBusiness) {
		this.nameBusiness = nameBusiness;
	}

	public String getAdresRoad() {
		return adresRoad;
	}

	public void setAdresRoad(String adresRoad) {
		this.adresRoad = adresRoad;
	}

	public String getAdresNum() {
		return adresNum;
	}

	public void setAdresNum(String adresNum) {
		this.adresNum = adresNum;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Date getDataUpdate() {
		return dataUpdate;
	}

	public void setDataUpdate(Date dataUpdate) {
		this.dataUpdate = dataUpdate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
