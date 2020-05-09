package com.project.FlightReservation.dto;

public class ReservationUpdateRequest {

	private Long id;
	private Boolean checkedIn;
	private int numberOfBags;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNumberOfBags() {
		return numberOfBags;
	}

	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}

	@Override
	public String toString() {
		return "ReservationUpdateRequest [id=" + id + ", checkedIn=" + checkedIn + ", numberOfBags=" + numberOfBags
				+ "]";
	}

}
