package com.capgemini.service;

import java.util.List;

import com.capgemini.types.ContractTO;

public interface ContractService {

	/**
	 * This is the method which find all contracts.
	 * 
	 * 
	 * @return List of contracts.
	 */
	List<ContractTO> findAll();

	/**
	 * This is the method which find contract in collection.
	 * 
	 * @param Long
	 *            id of a contract.
	 * 
	 * @return Contract Transfer Object.
	 */
	ContractTO findOne(Long id);
}
