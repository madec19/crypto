package com.wal.hs.crypto.service;

import javax.ws.rs.core.Response;

import com.wal.hs.crypto.service.request.CryptoRequest;
import com.wal.hs.crypto.service.request.DecryptRequest;

public interface CryptoService {

	Response encrypt(CryptoRequest request);
	Response decrypt(DecryptRequest request);
}
