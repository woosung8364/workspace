package ezen.jdbc;

/**
 * employees 테이블을 추상화
 * @author i7C- 송우성
 * ORM 클래스
 */
public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate; // private Date hireDate;
	private String jobId;
	private double salary;
	private double commisionPct;
	private int managerId;
	private int departmentId;
	
	
	
	public Employee() {}



	public Employee(int employeeId, String firstName, String lastName, String email, String phoneNumber,
			String hireDate, String jobId, double salary, double commisionPct, int managerId, int departmentId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
		this.commisionPct = commisionPct;
		this.managerId = managerId;
		this.departmentId = departmentId;
	}



	public int getEmployeeId() {
		return employeeId;
	}



	public String getFirstName() {
		return firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public String getEmail() {
		return email;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public String getHireDate() {
		return hireDate;
	}



	public String getJobId() {
		return jobId;
	}



	public double getSalary() {
		return salary;
	}



	public double getCommisionPct() {
		return commisionPct;
	}



	public int getManagerId() {
		return managerId;
	}



	public int getDepartmentId() {
		return departmentId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}



	public void setJobId(String jobId) {
		this.jobId = jobId;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	public void setCommisionPct(double commisionPct) {
		this.commisionPct = commisionPct;
	}



	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}



	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}



	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary="
				+ salary + ", commisionPct=" + commisionPct + ", managerId=" + managerId + ", departmentId="
				+ departmentId + "]";
	}
	
	
	
	
	
}
