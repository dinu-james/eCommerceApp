package payment.microservice.model;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentEntity {

	@Id
	private Integer id;
	private String status;
	private Boolean isRollback;
	private String reason;

	// private String orderID;

	@Embedded
	private MonetaryAmount amount;

	@Embedded
	private TransactionId txnId;

	private Date timeStamp;
	ModeOfPayment mop;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getIsRollback() {
		return isRollback;
	}

	public void setIsRollback(Boolean isRollback) {
		this.isRollback = isRollback;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public MonetaryAmount getAmount() {
		return amount;
	}

	public void setAmount(MonetaryAmount amount) {
		this.amount = amount;
	}

	public TransactionId getTxnId() {
		return txnId;
	}

	public void setTxnId(TransactionId txnId) {
		this.txnId = txnId;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public ModeOfPayment getMop() {
		return mop;
	}

	public void setMop(ModeOfPayment mop) {
		this.mop = mop;
	}

}
