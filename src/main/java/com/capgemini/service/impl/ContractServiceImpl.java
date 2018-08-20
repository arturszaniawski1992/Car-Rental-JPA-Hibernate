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
	ContractMapper contractMapper;

	@Autowired
	public ContractServiceImpl(ContractDao contractRepository) {
		this.contractRepository = contractRepository;

	}

	@Override
	public List<ContractTO> findAll() {
		List<ContractEntity> allContracts = contractRepository.findAll();
		return contractMapper.map2TOs(allContracts);
	}

	@Override
	public ContractTO findOne(Long id) {
		return contractMapper.toContractTO(contractRepository.findOne(id));
	}

	@Override
	public ContractTO add(ContractTO contractTO) {
		ContractEntity contractEntity = contractRepository.save(contractMapper.toContractEntity(contractTO));
		return contractMapper.toContractTO(contractEntity);
	}

	@Override
	public ContractTO update(ContractTO contractTO) {
		ContractEntity contractEntity = contractRepository.update(contractMapper.toContractEntity(contractTO));
		return contractMapper.toContractTO(contractEntity);
	}

	@Override
	public void remove(Long id) {
		contractRepository.delete(id);

	}

	@Override
	public void deleteAll() {
		contractRepository.deleteAll();
		
	}

}
