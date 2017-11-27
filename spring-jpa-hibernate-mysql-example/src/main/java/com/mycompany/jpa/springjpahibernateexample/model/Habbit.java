package com.mycompany.jpa.springjpahibernateexample.model;

import lombok.Data;

@Data
public class Habbit {

	private String type;
	private Integer intensity;

	public String getType() {
		return type;
	}

	public Habbit setType(String type) {
		this.type = type;
		return this;
	}

	public Integer getIntensity() {
		return intensity;
	}

	public Habbit setIntensity(Integer intensity) {
		this.intensity = intensity;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((intensity == null) ? 0 : intensity.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Habbit other = (Habbit) obj;
		if (intensity == null) {
			if (other.intensity != null)
				return false;
		} else if (!intensity.equals(other.intensity))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}



}
