package com.wal.hs.crypto.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wal.hs.crypto.bo.CryptoServiceBo;
import com.wal.hs.crypto.service.request.CryptoRequest;
import com.wal.hs.crypto.service.request.DecryptRequest;
import com.wal.hs.crypto.service.response.CryptoResponse;
import com.wal.hs.crypto.service.response.DecryptResponse;


@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class CryptoServiceImpl implements CryptoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CryptoServiceImpl.class);
	@Autowired
	private CryptoServiceBo cryptoServiceBo;

	@POST
	@Path("/encrypt")
	@Override
	public Response encrypt(CryptoRequest request) {

		LOGGER.info("Account Number received is {}", request.getAccountNo());
		CryptoResponse response = null;

		response = cryptoServiceBo.encrypt(request);
		LOGGER.debug("Encrypted value is : {}", response.getEncryptedValue());
		return Response.status(Status.OK).entity(response).build();
	}

	@Override
	@Path("/decrypt")
	@POST
	public Response decrypt(DecryptRequest request) {

		DecryptResponse response = null;

		response = cryptoServiceBo.decrypt(request);
		return Response.status(Status.OK).entity(response).build();

	}
}
