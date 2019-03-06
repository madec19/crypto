package com.wal.hs.crypto.service.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CryptoResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String encryptedValue;

	public String getEncryptedValue() {
		return encryptedValue;
	}

	public void setEncryptedValue(String encryptedValue) {
		this.encryptedValue = encryptedValue;
	}

}
