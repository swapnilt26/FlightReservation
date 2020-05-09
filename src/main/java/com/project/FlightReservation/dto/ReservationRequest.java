package com.project.FlightReservation.dto;

public class ReservationRequest {

	private long flightId;
	private String passengerfirstName;
	private String passengerlastName;
	private String passengerEmail;
	private String passengerMobile;
	private String nameOnCard;
	private String cardNumber;
	private String cardExpiry;
	private String secCode;

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public String getPassengerfirstName() {
		return passengerfirstName;
	}

	public void setPassengerfirstName(String passengerfirstName) {
		this.passengerfirstName = passengerfirstName;
	}

	public String getPassengerlastName() {
		return passengerlastName;
	}

	public void setPassengerlastName(String passengerlastName) {
		this.passengerlastName = passengerlastName;
	}

	public String getPassengerEmail() {
		return passengerEmail;
	}

	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	public String getPassengerMobile() {
		return passengerMobile;
	}

	public void setPassengerMobile(String passengerMobile) {
		this.passengerMobile = passengerMobile;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public String getSecCode() {
		return secCode;
	}

	public void setSecCode(String secCode) {
		this.secCode = secCode;
	}

	@Override
	public String toString() {
		return "ReservationRequest [flightId=" + flightId + ", passengerfirstName=" + passengerfirstName
				+ ", passengerlastName=" + passengerlastName + ", passengerEmail=" + passengerEmail
				+ ", passengerMobile=" + passengerMobile + ", nameOnCard=" + nameOnCard + ", cardNumber=" + cardNumber
				+ ", cardExpiry=" + cardExpiry + ", secCode=" + secCode + "]";
	}

}
