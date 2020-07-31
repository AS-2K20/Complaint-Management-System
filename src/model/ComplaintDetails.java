package model;

import java.time.LocalDate;

public class ComplaintDetails {
private int complaintId;
private String complaintUserId;
private String complaintType;
private String fullComplaint;
private String complaintStatus;
private LocalDate complaintDate;
private String complaintUserEmail;
private long complaintUserContact;
private String complaintUserAddress;

public String getComplaintUserAddress() {
	return complaintUserAddress;
}
public void setComplaintUserAddress(String complaintUserAddress) {
	this.complaintUserAddress = complaintUserAddress;
}
public int getComplaintId() {
	return complaintId;
}
public void setComplaintId(int complaintId) {
	this.complaintId = complaintId;
}
public String getComplaintUserId() {
	return complaintUserId;
}
public void setComplaintUserId(String complaintUserId) {
	this.complaintUserId = complaintUserId;
}
public String getComplaintType() {
	return complaintType;
}
public void setComplaintType(String complaintType) {
	this.complaintType = complaintType;
}
public String getFullComplaint() {
	return fullComplaint;
}
public void setFullComplaint(String fullComplaint) {
	this.fullComplaint = fullComplaint;
}
public String getComplaintStatus() {
	return complaintStatus;
}
public void setComplaintStatus(String complaintStatus) {
	this.complaintStatus = complaintStatus;
}
public LocalDate getComplaintDate() {
	return complaintDate;
}
public void setComplaintDate(LocalDate complaintDate) {
	this.complaintDate = complaintDate;
}
public String getComplaintUserEmail() {
	return complaintUserEmail;
}
public void setComplaintUserEmail(String complaintUserEmail) {
	this.complaintUserEmail = complaintUserEmail;
}
public long getComplaintUserContact() {
	return complaintUserContact;
}
public void setComplaintUserContact(long complaintUserContact) {
	this.complaintUserContact = complaintUserContact;
}
public ComplaintDetails(int complaintId, String complaintUserId, String complaintType, String fullComplaint,
		String complaintStatus, LocalDate complaintDate, String complaintUserEmail, long complaintUserContact, String complaintUserAddress) {
	
	this.complaintId = complaintId;
	this.complaintUserId = complaintUserId;
	this.complaintType = complaintType;
	this.fullComplaint = fullComplaint;
	this.complaintStatus = complaintStatus;
	this.complaintDate = complaintDate;
	this.complaintUserEmail = complaintUserEmail;
	this.complaintUserContact = complaintUserContact;
	this.complaintUserAddress = complaintUserAddress;
}
}
