package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.ContractDao;
import com.capgemini.domain.ContractEntity;
import com.capgemini.mappers.ContractMapper;
import com.capgemini.service.ContractService;
import com.capgemini.types.ContractTO;

@Service
@Transactional(readOnly = true)
public class ContractServiceImpl implements ContractService {

	private final ContractDao contractRepository;

	@Autowired
	public ContractServiceImpl(ContractDao contractRepository) {
		super();
		this.contractRepository = contractRepository;
	}

	@Override
	public List<ContractTO> findAll() {
		List<ContractEntity> allContracts = contractRepository.findAll();
		return ContractMapper.map2TOs(allContracts);
	}

	@Override
	public ContractTO findOne(Long id) {
		return ContractMapper.toContractTO(contractRepository.findOne(id));
	}

}
