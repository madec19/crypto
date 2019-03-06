package com.wal.hs.crypto.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wal.hs.crypto.dao.mapper.CryptoMapper;

@Service
public class CryptoDAOImpl implements CryptoDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(CryptoDAOImpl.class);
	@Autowired
	private CryptoMapper cryptoMapper;
	
	public void insertAcc(String accountNo) {
		LOGGER.info("Inserting account into DB");
		cryptoMapper.insertAcc(accountNo);
	}

}
