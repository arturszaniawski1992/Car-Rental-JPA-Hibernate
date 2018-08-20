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

	/**
	 * This is the method which add contract to collection.
	 * 
	 * @param Contract
	 *            Transfer Object.
	 * 
	 */
	ContractTO add(ContractTO contractTO);

	/**
	 * This is the method which update contract in collection.
	 * 
	 * @param Contract
	 *            Transfer Object.
	 * 
	 */
	ContractTO update(ContractTO departmentTO);

	/**
	 * This is the method which remove contract by its id.
	 * 
	 * @param Long
	 *            id of a contract.
	 * 
	 */
	void remove(Long id);

	/**
	 * This is the method which remove all contracts.
	 * 
	 * 
	 */
	void deleteAll();
}
