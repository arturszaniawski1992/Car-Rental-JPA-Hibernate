package com.capgemini.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.types.ContractTO;
import com.capgemini.types.ContractTO.ContractTOBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=hsql")
@Transactional
public class ContractTest {

	@Autowired
	private ContractService contractService;

	@Before
	public void setUp() {
		contractService.deleteAll();
	}

	@Test
	public void shouldAddContract() {
		// given

		LocalDate rentDate = LocalDate.now();
		LocalDate returnDate = LocalDate.now();

		ContractTO contractTO = new ContractTOBuilder().withRentDate(rentDate).withReturnDate(returnDate).build();

		ContractTO savedContract = contractService.add(contractTO);

		// when
		ContractTO selectedContract = contractService.findOne(savedContract.getId());

		// then
		assertThat(selectedContract.getId()).isEqualTo(savedContract.getId());
	}

	@Test
	public void shouldDeleteAllContractsFromRepository() {
		// given
		LocalDate rentDate = LocalDate.now();
		LocalDate returnDate = LocalDate.now();
		ContractTO contractTO1 = new ContractTOBuilder().withRentDate(rentDate).withReturnDate(returnDate).build();
		ContractTO contractTO2 = new ContractTOBuilder().withRentDate(rentDate).withReturnDate(returnDate).build();
		contractService.add(contractTO1);
		contractService.add(contractTO2);

		// when
		contractService.deleteAll();
		List<ContractTO> contracts = contractService.findAll();

		// then
		assertThat(contracts).isEmpty();
	}
}
