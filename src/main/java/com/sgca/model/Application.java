package com.sgca.model;
/**
 * This is the model class for Application table in database every coloumn is 
 * represented here by using properties and they all have getters and setters
 * 
 * @author Alwin Mathew
 * @version 1.0
 */

public class Application {
	//based on db columns
	private int id;
	private String applicationNo;
	private String applicationStatus;
	private int phase;
	private String subject;
	private String mguNumber;
	private String studName;
	private String sex;
	private String maritalStatus;
	private String handicapped;
	private String address;
	private int pincode;
	private String phno;
	private String email;
	//sslc
	private String dateOfBirth;
	private String sslcRegisNo;
	private String sslcDate;
	private String sslcBoard;
	private String sslcSchool;
	private int sslcPercentage;
	//hse
	private String plusTwoCat;
	private String plusTwoDate;
	private String plusTwoRegNo;
	private String plusTwoSchool;
	private String plusTwoBoard;
	private int plusTwoPercentage;
	//lastcourse
	private String lastCourseAttended;
	private String lastCourseName;
	private String lastCourseSchoolName;
	private String tcDate;
	private int tcNumber;
	//religion
	private String religionCaste;
	private String regType;
	//about family
	private int annualIncome;
	private String parentName;
	private String parentJob;
	private String relGuardian;
	//extra curricular activities
	private String nccNss;
	private String sportsGames;
	private String literaryCultural;
	
	//my columns that need to be done by me
	private String rejectComments;
	private String decisionTime;
	private int approverId;
	private int aggregateMarks;
	private int StudentRank;
	
	
	//Getters and setters for all the model properties
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public int getPhase() {
		return phase;
	}
	public void setPhase(int phase) {
		this.phase = phase;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMguNumber() {
		return mguNumber;
	}
	public void setMguNumber(String mguNumber) {
		this.mguNumber = mguNumber;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getHandicapped() {
		return handicapped;
	}
	public void setHandicapped(String handicapped) {
		this.handicapped = handicapped;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getSslcRegisNo() {
		return sslcRegisNo;
	}
	public void setSslcRegisNo(String sslcRegisNo) {
		this.sslcRegisNo = sslcRegisNo;
	}
	public String getSslcDate() {
		return sslcDate;
	}
	public void setSslcDate(String sslcDate) {
		this.sslcDate = sslcDate;
	}
	public String getSslcBoard() {
		return sslcBoard;
	}
	public void setSslcBoard(String sslcBoard) {
		this.sslcBoard = sslcBoard;
	}
	public String getSslcSchool() {
		return sslcSchool;
	}
	public void setSslcSchool(String sslcSchool) {
		this.sslcSchool = sslcSchool;
	}
	public int getSslcPercentage() {
		return sslcPercentage;
	}
	public void setSslcPercentage(int sslcPercentage) {
		this.sslcPercentage = sslcPercentage;
	}
	public String getPlusTwoCat() {
		return plusTwoCat;
	}
	public void setPlusTwoCat(String plusTwoCat) {
		this.plusTwoCat = plusTwoCat;
	}
	public String getPlusTwoDate() {
		return plusTwoDate;
	}
	public void setPlusTwoDate(String plusTwoDate) {
		this.plusTwoDate = plusTwoDate;
	}
	public String getPlusTwoRegNo() {
		return plusTwoRegNo;
	}
	public void setPlusTwoRegNo(String plusTwoRegNo) {
		this.plusTwoRegNo = plusTwoRegNo;
	}
	public String getPlusTwoSchool() {
		return plusTwoSchool;
	}
	public void setPlusTwoSchool(String plusTwoSchool) {
		this.plusTwoSchool = plusTwoSchool;
	}
	public String getPlusTwoBoard() {
		return plusTwoBoard;
	}
	public void setPlusTwoBoard(String plusTwoBoard) {
		this.plusTwoBoard = plusTwoBoard;
	}
	public int getPlusTwoPercentage() {
		return plusTwoPercentage;
	}
	public void setPlusTwoPercentage(int plusTwoPercentage) {
		this.plusTwoPercentage = plusTwoPercentage;
	}
	public String getLastCourseAttended() {
		return lastCourseAttended;
	}
	public void setLastCourseAttended(String lastCourseAttended) {
		this.lastCourseAttended = lastCourseAttended;
	}
	public String getLastCourseName() {
		return lastCourseName;
	}
	public void setLastCourseName(String lastCourseName) {
		this.lastCourseName = lastCourseName;
	}
	public String getLastCourseSchoolName() {
		return lastCourseSchoolName;
	}
	public void setLastCourseSchoolName(String lastCourseSchoolName) {
		this.lastCourseSchoolName = lastCourseSchoolName;
	}
	public String getTcDate() {
		return tcDate;
	}
	public void setTcDate(String tcDate) {
		this.tcDate = tcDate;
	}
	public int getTcNumber() {
		return tcNumber;
	}
	public void setTcNumber(int tcNumber) {
		this.tcNumber = tcNumber;
	}
	public String getReligionCaste() {
		return religionCaste;
	}
	public void setReligionCaste(String religionCaste) {
		this.religionCaste = religionCaste;
	}
	public String getRegType() {
		return regType;
	}
	public void setRegType(String regType) {
		this.regType = regType;
	}
	public int getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(int annualIncome) {
		this.annualIncome = annualIncome;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getParentJob() {
		return parentJob;
	}
	public void setParentJob(String parentJob) {
		this.parentJob = parentJob;
	}
	public String getRelGuardian() {
		return relGuardian;
	}
	public void setRelGuardian(String relGuardian) {
		this.relGuardian = relGuardian;
	}
	public String getNccNss() {
		return nccNss;
	}
	public void setNccNss(String nccNss) {
		this.nccNss = nccNss;
	}
	public String getSportsGames() {
		return sportsGames;
	}
	public void setSportsGames(String sportsGames) {
		this.sportsGames = sportsGames;
	}
	public String getLiteraryCultural() {
		return literaryCultural;
	}
	public void setLiteraryCultural(String literaryCultural) {
		this.literaryCultural = literaryCultural;
	}
	public String getRejectComments() {
		return rejectComments;
	}
	public void setRejectComments(String rejectComments) {
		this.rejectComments = rejectComments;
	}
	public String getDecisionTime() {
		return decisionTime;
	}
	public void setDecisionTime(String decisionTime) {
		this.decisionTime = decisionTime;
	}
	public int getApproverId() {
		return approverId;
	}
	public void setApproverId(int approverId) {
		this.approverId = approverId;
	}
	public int getStudentRank() {
		return StudentRank;
	}
	public void setStudentRank(int studentRank) {
		StudentRank = studentRank;
	}
    public int getAggregateMarks() {
        return aggregateMarks;
    }
    public void setAggregateMarks(int aggregateMarks) {
        this.aggregateMarks = aggregateMarks;
    }
}
