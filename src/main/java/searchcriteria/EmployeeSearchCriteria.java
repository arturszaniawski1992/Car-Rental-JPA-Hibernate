package searchcriteria;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.DepartmentEntity;
import com.capgemini.domain.EmployeeEntity;

public class EmployeeSearchCriteria {
	private DepartmentEntity department;
	private CarEntity attendCar;
	private EmployeeEntity employee;

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public CarEntity getAttendCar() {
		return attendCar;
	}

	public void setAttendCar(CarEntity attendCar) {
		this.attendCar = attendCar;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

}
