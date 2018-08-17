package com.capgemini.service;

import java.util.List;

import com.capgemini.types.ContractTO;

public interface ContractService {
	List<ContractTO> findAll();

	ContractTO findOne(Long id);
}
