package model;

import java.time.LocalDate;

public class FirDetails {
	private int firId;
	private LocalDate firDate;
	private int firComplaintId;
	private String firComplaintUserId;
	private String firComplaintType;
	private String firFullComplaint;
	private LocalDate firComplaintDate;
	private String firComplaintUserEmail;
	private long firComplaintUserContact;
	private String firComplaintUserAddress;
	public int getFirId() {
		return firId;
	}
	public void setFirId(int firId) {
		this.firId = firId;
	}
	public LocalDate getFirDate() {
		return firDate;
	}
	public void setFirDate(LocalDate firDate) {
		this.firDate = firDate;
	}
	public int getFirComplaintId() {
		return firComplaintId;
	}
	public void setFirComplaintId(int firComplaintId) {
		this.firComplaintId = firComplaintId;
	}
	public String getFirComplaintUserId() {
		return firComplaintUserId;
	}
	public void setFirComplaintUserId(String firComplaintUserId) {
		this.firComplaintUserId = firComplaintUserId;
	}
	public String getFirComplaintType() {
		return firComplaintType;
	}
	public void setFirComplaintType(String firComplaintType) {
		this.firComplaintType = firComplaintType;
	}
	public String getFirFullComplaint() {
		return firFullComplaint;
	}
	public void setFirFullComplaint(String firFullComplaint) {
		this.firFullComplaint = firFullComplaint;
	}
	public LocalDate getFirComplaintDate() {
		return firComplaintDate;
	}
	public void setFirComplaintDate(LocalDate firComplaintDate) {
		this.firComplaintDate = firComplaintDate;
	}
	public String getFirComplaintUserEmail() {
		return firComplaintUserEmail;
	}
	public void setFirComplaintUserEmail(String firComplaintUserEmail) {
		this.firComplaintUserEmail = firComplaintUserEmail;
	}
	public long getFirComplaintUserContact() {
		return firComplaintUserContact;
	}
	public void setFirComplaintUserContact(long firComplaintUserContact) {
		this.firComplaintUserContact = firComplaintUserContact;
	}
	public String getFirComplaintUserAddress() {
		return firComplaintUserAddress;
	}
	public void setFirComplaintUserAddress(String firComplaintUserAddress) {
		this.firComplaintUserAddress = firComplaintUserAddress;
	}
	public FirDetails(int firId, int firComplaintId, LocalDate firDate, String firComplaintUserId,
			String firComplaintType, String firFullComplaint, LocalDate firComplaintDate, String firComplaintUserEmail,
			long firComplaintUserContact, String firComplaintUserAddress) {
		
		this.firId = firId;
		this.firComplaintId = firComplaintId;
		this.firDate = firDate;		
		this.firComplaintUserId = firComplaintUserId;
		this.firComplaintType = firComplaintType;
		this.firFullComplaint = firFullComplaint;
		this.firComplaintDate = firComplaintDate;
		this.firComplaintUserEmail = firComplaintUserEmail;
		this.firComplaintUserContact = firComplaintUserContact;
		this.firComplaintUserAddress = firComplaintUserAddress;
	}
}
