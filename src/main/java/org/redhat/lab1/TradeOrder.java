package org.redhat.lab1;

import java.io.Serializable;

public class TradeOrder implements Serializable {

	private static final long serialVersionUID = -2812468154835390309L;
	String name;
	String custId;
	Integer vip;
	String stockId;
	Integer shares;
	Double cost;

		public Integer getVip() {return vip;}
		public void setVip(Integer vip) {this.vip = vip;}
		public String getStockId() {return stockId;}
		public void setStockId(String stockId) {this.stockId =stockId;}
		public Integer getShares() {return shares;}
		public void setShares(Integer shares) {this.shares = shares;}
		public Double getCost() {return cost;}
		public void setCost(Double cost) {this.cost = cost;}
		public static long getSerialversionuid() {
		return serialVersionUID;
		}
		public String toString(){
		return "name:["+name+"] custId:["+custId+"] vip:["+vip+"] stockId:["+stockId+"] shares["+shares+"]";
		}
	}
