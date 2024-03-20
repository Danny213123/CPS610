package com.health_care.java_healthcare_database;

public class Operation {
	
	private OperationType operationType;
	private Integer recordId;
	private Integer transactionId;
    private Integer value;
	
	/**
	 * Constructor for read
	 * @param transactionId the transaction identifier
	 * @param operationType operation type
	 * @param record record
	 */
	public Operation(Integer transactionId, OperationType operationType, Integer recordId){
		this.transactionId = transactionId;
		this.operationType = operationType;
		this.recordId = recordId;
        this.value = null;
	}


	/*
	 * Constructor for write
	 * @param transactionId the transaction identifier
	 * @param operationType operation type
	 * @param record record
	 * @param value value
	 * 
	 */
    public Operation(Integer transactionId, OperationType operationType, Integer recordId, Integer value){
		this.transactionId = transactionId;
		this.operationType = operationType;
		this.recordId = recordId;
        this.value = value;
	}

	/*
	 * Constructor for commit
	 * @param transactionId the transaction identifier
	 * @param operationType operation type
	 * 
	 */
    public Operation(Integer transactionId, OperationType operationType) {
        this.transactionId = transactionId;
        this.operationType = operationType;
        this.value = null;
    }

	/**
	 * @return the operation type
	 */
	public OperationType getOperationType() {
		return operationType;
	}

	/**
	 * @param operationType the operation type to set
	 */
	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	/**
	 * @return the record
	 */
	public Integer getRecord() {
		return this.recordId;
	}

    /**
	 * @return the record
	 */
	public Integer getValue() {
		return this.value;
	}

	/**
	 * @return the transaction id
	 */
	public Integer getTransactionId() {
		return this.transactionId;
	}

	/**
	 * @param transactionId the transaction id to set
	 */
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	
	
}