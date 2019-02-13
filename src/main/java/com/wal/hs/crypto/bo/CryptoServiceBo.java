package com.wal.hs.crypto.bo;

import com.wal.hs.crypto.service.request.CryptoRequest;
import com.wal.hs.crypto.service.request.DecryptRequest;
import com.wal.hs.crypto.service.response.CryptoResponse;
import com.wal.hs.crypto.service.response.DecryptResponse;

public interface CryptoServiceBo {

	CryptoResponse encrypt(CryptoRequest request);
	DecryptResponse decrypt(DecryptRequest request);

}
