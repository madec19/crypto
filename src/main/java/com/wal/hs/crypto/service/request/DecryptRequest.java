package com.wal.hs.crypto.service.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DecryptRequest {

	private String decryptValue;

	public String getDecryptValue() {
		return decryptValue;
	}

	public void setDecryptValue(String decryptValue) {
		this.decryptValue = decryptValue;
	}

	
	
	
}
