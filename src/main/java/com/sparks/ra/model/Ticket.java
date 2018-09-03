package com.sparks.ra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name= "TICKET")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name ="TICKET_ID")
    private String ticketId;
    @Column(name = "TICKET_DISCRIPTION")
    private String description;
    @Column(name = "TICKET_STATUS")
    private String status;
    @Column(name = "TICKET_BUSINESS_OWNER")
    private String businessOwner;
    
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "RELEASE_ID")
    private long releaseID;
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBusinessOwner() {
		return businessOwner;
	}
	public void setBusinessOwner(String businessOwner) {
		this.businessOwner = businessOwner;
	}
	public long getReleaseID() {
		return releaseID;
	}
	public void setReleaseID(long releaseID) {
		this.releaseID = releaseID;
	}
	
	
}
