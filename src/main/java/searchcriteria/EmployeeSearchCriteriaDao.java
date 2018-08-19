package searchcriteria;

import java.util.List;

import com.capgemini.domain.EmployeeEntity;

public interface EmployeeSearchCriteriaDao {

	List<EmployeeEntity> findEmployeesBySearchCriteria(EmployeeSearchCriteria employeeSearchCriteria);

}
