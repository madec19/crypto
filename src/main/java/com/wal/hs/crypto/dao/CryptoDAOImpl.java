package com.wal.hs.crypto.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wal.hs.crypto.dao.mapper.CryptoMapper;

@Service
public class CryptoDAOImpl implements CryptoDAO {

	@Autowired
	private CryptoMapper cryptoMapper;
	
	public void insertAcc(String accountNo) {
		cryptoMapper.insertAcc(accountNo);
	}

}
