package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Home {
	
	@Id
	private String name;
	private String streetNumber;
	private String streetName;
	private String city;
	private String region;
	private String zip;
	private String country;
	
	public Home(String name, String streetNumber, String streetName, String city, String region, String zip,
			String country) {
		super();
		this.name = name;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.region = region;
		this.zip = zip;
		this.country = country;
	}

	public Home() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((streetName == null) ? 0 : streetName.hashCode());
		result = prime * result + ((streetNumber == null) ? 0 : streetNumber.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Home)) {
			return false;
		}
		Home other = (Home) obj;
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!country.equals(other.country)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (region == null) {
			if (other.region != null) {
				return false;
			}
		} else if (!region.equals(other.region)) {
			return false;
		}
		if (streetName == null) {
			if (other.streetName != null) {
				return false;
			}
		} else if (!streetName.equals(other.streetName)) {
			return false;
		}
		if (streetNumber == null) {
			if (other.streetNumber != null) {
				return false;
			}
		} else if (!streetNumber.equals(other.streetNumber)) {
			return false;
		}
		if (zip == null) {
			if (other.zip != null) {
				return false;
			}
		} else if (!zip.equals(other.zip)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Home [name=" + name + ", streetNumber=" + streetNumber + ", streetName=" + streetName + ", city=" + city
				+ ", region=" + region + ", zip=" + zip + ", country=" + country + "]";
	}
	


}
