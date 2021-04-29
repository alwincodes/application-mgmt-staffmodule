package com.sgca.model;

import java.time.LocalDateTime;
/**
 * This model object stores all the rank details in the rank coloumn as 
 * properties in this class
 * 
 * @author Alwin Mathew
 * @version 1.0
 *
 */
public class Rank {
	private int id;
	private String process_status;
	private String user;
	private LocalDateTime time;
	private int rankId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProcess_status() {
		return process_status;
	}
	public void setProcess_status(String process_status) {
		this.process_status = process_status;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
    public int getRankId() {
        return rankId;
    }
    public void setRankId(int rankId) {
        this.rankId = rankId;
    }
}
