package com.capgemini.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.ContractDao;
import com.capgemini.domain.ContractEntity;

@Repository
public class ContractDaoImpl extends AbstractDao<ContractEntity, Long> implements ContractDao {

}
