package com.eazybytes.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "account_transactions")
public class AccountTransactions {
	
	@Id
	@Column(name = "transaction_id")
	private String transactionId;
	
	@Column(name = "account_number")
	private Long accountNumber;
	
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "transaction_dt")
	private Date transactionDt;
	
	@Column(name = "transaction_summary")
	private String transactionSummary;
	
	@Column(name = "transaction_type")
	private String transactionType;
	
	@Column(name = "transaction_amt")
	private int transactionAmt;
	
	@Column(name = "closing_balance")
	private int closingBalance;
	
	@Column(name = "create_dt")
	private Date createDt;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getTransactionDt() {
		return transactionDt;
	}

	public void setTransactionDt(Date transactionDt) {
		this.transactionDt = transactionDt;
	}

	public String getTransactionSummary() {
		return transactionSummary;
	}

	public void setTransactionSummary(String transactionSummary) {
		this.transactionSummary = transactionSummary;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getTransactionAmt() {
		return transactionAmt;
	}

	public void setTransactionAmt(int transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	public int getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(int closingBalance) {
		this.closingBalance = closingBalance;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Override
	public String toString() {
		return "AccountTransactions [transactionId=" + transactionId + ", accountNumber=" + accountNumber
				+ ", customerId=" + customerId + ", transactionDt=" + transactionDt + ", transactionSummary="
				+ transactionSummary + ", transactionType=" + transactionType + ", transactionAmt=" + transactionAmt
				+ ", closingBalance=" + closingBalance + ", createDt=" + createDt + "]";
	}
}
