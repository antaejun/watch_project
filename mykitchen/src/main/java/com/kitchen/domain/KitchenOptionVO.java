package com.kitchen.domain;

public class KitchenOptionVO {
	
	private int idx;
	private String kitchen_name;
	private String microwave_oven;
	private String gas_stove;
	private String induction;
	private String refrigerator;
	private String freezer_refrigerator;
	private String electric_water_heater;
	private String ice_making_machine;
	private String sink;
	private String exhaust_hood;
	private String pos;
	private String internet;
	private String telephone;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getKitchen_name() {
		return kitchen_name;
	}
	public void setKitchen_name(String kitchen_name) {
		this.kitchen_name = kitchen_name;
	}
	public String getMicrowave_oven() {
		return microwave_oven;
	}
	public void setMicrowave_oven(String microwave_oven) {
		this.microwave_oven = microwave_oven;
	}
	public String getGas_stove() {
		return gas_stove;
	}
	public void setGas_stove(String gas_stove) {
		this.gas_stove = gas_stove;
	}
	public String getInduction() {
		return induction;
	}
	public void setInduction(String induction) {
		this.induction = induction;
	}
	public String getRefrigerator() {
		return refrigerator;
	}
	public void setRefrigerator(String refrigerator) {
		this.refrigerator = refrigerator;
	}
	public String getFreezer_refrigerator() {
		return freezer_refrigerator;
	}
	public void setFreezer_refrigerator(String freezer_refrigerator) {
		this.freezer_refrigerator = freezer_refrigerator;
	}
	public String getElectric_water_heater() {
		return electric_water_heater;
	}
	public void setElectric_water_heater(String electric_water_heater) {
		this.electric_water_heater = electric_water_heater;
	}
	public String getIce_making_machine() {
		return ice_making_machine;
	}
	public void setIce_making_machine(String ice_making_machine) {
		this.ice_making_machine = ice_making_machine;
	}
	public String getSink() {
		return sink;
	}
	public void setSink(String sink) {
		this.sink = sink;
	}
	public String getExhaust_hood() {
		return exhaust_hood;
	}
	public void setExhaust_hood(String exhaust_hood) {
		this.exhaust_hood = exhaust_hood;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getInternet() {
		return internet;
	}
	public void setInternet(String internet) {
		this.internet = internet;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Override
	public String toString() {
		return "KitchenOptionVO [idx=" + idx + ", kitchen_name=" + kitchen_name + ", microwave_oven=" + microwave_oven
				+ ", gas_stove=" + gas_stove + ", induction=" + induction + ", refrigerator=" + refrigerator
				+ ", freezer_refrigerator=" + freezer_refrigerator + ", electric_water_heater=" + electric_water_heater
				+ ", ice_making_machine=" + ice_making_machine + ", sink=" + sink + ", exhaust_hood=" + exhaust_hood
				+ ", pos=" + pos + ", internet=" + internet + ", telephone=" + telephone + "]";
	}
	
	

}
