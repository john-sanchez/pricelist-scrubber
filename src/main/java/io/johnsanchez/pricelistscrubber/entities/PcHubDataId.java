package io.johnsanchez.pricelistscrubber.entities;

import java.io.Serializable;
import java.util.Date;

public class PcHubDataId implements Serializable {
	private static final long serialVersionUID = 3609446219775906923L;
	private String sku;
	private Date recordedDate;
	
	public PcHubDataId() {
		
	}
	
	public PcHubDataId(String sku, Date recordedDate) {
		this.sku = sku;
		this.recordedDate = recordedDate;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Date getRecordedDate() {
		return recordedDate;
	}

	public void setRecordedDate(Date recordedDate) {
		this.recordedDate = recordedDate;
	}
}