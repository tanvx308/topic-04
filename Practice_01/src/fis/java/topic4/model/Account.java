package fis.java.topic4.model;

public class Account {
	// thuộc tính
	private Integer id;
	private String accountNumber;
	private String accountName;
	private Double balance;
	private Integer status;

	public Account() {
	}

	public Account(Integer id, String accountNumber, String accountName, Double balance, Integer status) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balance = balance;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", accountName=" + accountName + ", balance="
				+ balance + ", status=" + status + "]";
	}

	
}
