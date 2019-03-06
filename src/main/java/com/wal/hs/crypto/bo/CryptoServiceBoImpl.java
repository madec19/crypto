package com.wal.hs.crypto.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.wal.hs.crypto.dao.CryptoDAO;
import com.wal.hs.crypto.service.request.CryptoRequest;
import com.wal.hs.crypto.service.request.DecryptRequest;
import com.wal.hs.crypto.service.response.CryptoResponse;
import com.wal.hs.crypto.service.response.DecryptResponse;
import com.wal.hs.crypto.utils.CryptoUtils;

@Component
public class CryptoServiceBoImpl implements CryptoServiceBo {

	@Autowired
	private CryptoDAO cryptoDAO;
	
	@Override
	@Cacheable("encrypt")
	public CryptoResponse encrypt(CryptoRequest request) {
		cryptoDAO.insertAcc(request.getAccountNo());
		CryptoResponse response = new CryptoResponse();
		slowLookupOperation();
		String encryptedValue = CryptoUtils.encrypt(request.getAccountNo(), "manoj");
		response.setEncryptedValue(encryptedValue);
		return response;
	}

	public void slowLookupOperation(){
        try {
               long time = 1000L;
               Thread.sleep(time);
           } catch (InterruptedException e) {
               throw new IllegalStateException(e);
          }
   }

	@Override
	public DecryptResponse decrypt(DecryptRequest request) {
		DecryptResponse response = new DecryptResponse();
		String originalValue = CryptoUtils.decrypt(request.getDecryptValue(), "manoj");
		response.setOriginalValue(originalValue);
		return response;
	}
}
