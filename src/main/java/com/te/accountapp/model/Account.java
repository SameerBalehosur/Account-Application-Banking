package com.te.accountapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "User_Account_Details")
@Valid
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Account_Id")
	@NotNull(message = "Id should not be null")
	private Long accountId;
	@Column(name = "Name_of_Account_Holder")
	@NotNull(message = "Username field is required")
	private String accountHolderName;
	public enum gender {
		MALE, FEMALE, OTHERS;
	}
	@NotNull(message = "Choose any option")
	@Column(name = "Gender")
	@Enumerated(EnumType.STRING)
	private gender gender;
	@Column(name = "Address")
	@NotNull(message = "Address should not be null")
	private String address;
	@Column(name = "Account_Nominee")
	@NotNull(message = "Nominee fields required")
	private String nominee;
	@Column(name = "Current_Account_Balance ")
	@DecimalMin(value = "0.0", message = "It should not be negativel")
	private double currentAmount;
	public enum accountStatus{
		ACTIVE,INACTIVE;
	}
	@Column(name = "Account_Status")
	@NotNull(message ="Value should be Active or Inactive")
	@Enumerated(EnumType.STRING)
	private  accountStatus accountStatus ;

	/*
	 * public Account(@NotNull(message = "Id should not be null") Long accountId,
	 * 
	 * @NotNull(message = "Username field is required") String accountHolderName,
	 * com.te.accountapp.model.Account.@NotNull(message = "Choose any option")
	 * gender gender,
	 * 
	 * @NotNull(message = "Address should not be null") String address,
	 * 
	 * @NotNull(message = "Nominee fields required") String nominee,
	 * 
	 * @DecimalMin(value = "0.0", message = "It should not be negativel") double
	 * currentAmount, com.te.accountapp.model.Account.@NotNull(message =
	 * "Value should be Active or Inactive") accountStatus accountStatus) { super();
	 * this.accountId = accountId; this.accountHolderName = accountHolderName;
	 * this.gender = gender; this.address = address; this.nominee = nominee;
	 * this.currentAmount = currentAmount; this.accountStatus = accountStatus; }
	 * public Account() { super(); }
	 */
}
