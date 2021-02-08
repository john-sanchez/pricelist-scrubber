package io.johnsanchez.pricelistscrubber.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table
@IdClass(PcHubDataId.class)
public class PcHubData {
	
	@Id
	private String sku; // 0
	
	private String category; // 1
	
	private String properties; // 2
	
	private String brand; // 3
	
	private String unknownField1; // 4
	
	private String description; // 5
	
	private BigDecimal cashPrice; // 6
	
	private BigDecimal cardPrice; // 7
	
	private BigDecimal shippingPriceLbc; // 8
	
	private String warrantyNotes; // 9
	
	private String url; // 10
	
	private String unknownField2; // 11
	
	private BigDecimal shippingJTMetroManila; // 12
	
	private BigDecimal shippingJTProvincial; // 13
	
	private String unknownField3; // 14
	
	private String imageUrl; // 15
	
	private String unknownField4; // 16
	
	private String unknownField5; // 17
	
	private String unknownField6; // 18
	
	private String unknownField7; // 19
	
	private String availability; // 20
	
	@Id
	private Date recordedDate;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getUnknownField1() {
		return unknownField1;
	}

	public void setUnknownField1(String unknownField1) {
		this.unknownField1 = unknownField1;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getCashPrice() {
		return cashPrice;
	}

	public void setCashPrice(BigDecimal cashPrice) {
		this.cashPrice = cashPrice;
	}

	public BigDecimal getCardPrice() {
		return cardPrice;
	}

	public void setCardPrice(BigDecimal cardPrice) {
		this.cardPrice = cardPrice;
	}

	public BigDecimal getShippingPriceLbc() {
		return shippingPriceLbc;
	}

	public void setShippingPriceLbc(BigDecimal shippingPriceLbc) {
		this.shippingPriceLbc = shippingPriceLbc;
	}

	public String getWarrantyNotes() {
		return warrantyNotes;
	}

	public void setWarrantyNotes(String warrantyNotes) {
		this.warrantyNotes = warrantyNotes;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUnknownField2() {
		return unknownField2;
	}

	public void setUnknownField2(String unknownField2) {
		this.unknownField2 = unknownField2;
	}

	public BigDecimal getShippingJTMetroManila() {
		return shippingJTMetroManila;
	}

	public void setShippingJTMetroManila(BigDecimal shippingJTMetroManila) {
		this.shippingJTMetroManila = shippingJTMetroManila;
	}

	public BigDecimal getShippingJTProvincial() {
		return shippingJTProvincial;
	}

	public void setShippingJTProvincial(BigDecimal shippingJTProvincial) {
		this.shippingJTProvincial = shippingJTProvincial;
	}

	public String getUnknownField3() {
		return unknownField3;
	}

	public void setUnknownField3(String unknownField3) {
		this.unknownField3 = unknownField3;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getUnknownField4() {
		return unknownField4;
	}

	public void setUnknownField4(String unknownField4) {
		this.unknownField4 = unknownField4;
	}

	public String getUnknownField5() {
		return unknownField5;
	}

	public void setUnknownField5(String unknownField5) {
		this.unknownField5 = unknownField5;
	}

	public String getUnknownField6() {
		return unknownField6;
	}

	public void setUnknownField6(String unknownField6) {
		this.unknownField6 = unknownField6;
	}

	public String getUnknownField7() {
		return unknownField7;
	}

	public void setUnknownField7(String unknownField7) {
		this.unknownField7 = unknownField7;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Date getRecordedDate() {
		return recordedDate;
	}

	public void setRecordedDate(Date recordedDate) {
		this.recordedDate = recordedDate;
	}

}
