package org.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Plant {
	final static String KEY_ID = "id";
	final static String KEY_GENUS = "genus";
	final static String KEY_SPECIES = "species";
	final static String KEY_CULTIVAR = "cultivar";
	final static String KEY_COMMON = "common";



	@SerializedName("id")
	@Expose
	private int id;
	@SerializedName("genus")
	@Expose
	private String genus;
	@SerializedName("species")
	@Expose
	private String species;
	@SerializedName("cultivar")
	@Expose
	private String cultivar;
	@SerializedName("common")
	@Expose
	private String common;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenus() {
		return genus;
	}
	public void setGenus(String genus) {
		this.genus = genus;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getCultivar() {
		return cultivar;
	}
	public void setCultivar(String cultivar) {
		this.cultivar = cultivar;
	}
	public String getCommon() {
		return common;
	}
	public void setCommon(String common) {
		this.common = common;
	}

	@Override
	public String toString() {
		return "Plant{" +
				"id=" + id +
				", genus='" + genus + '\'' +
				", species='" + species + '\'' +
				", cultivar='" + cultivar + '\'' +
				", common='" + common + '\'' +
				'}';
	}
}
