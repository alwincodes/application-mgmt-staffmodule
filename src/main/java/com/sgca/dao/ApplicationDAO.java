package com.sgca.dao;

import java.util.*;
import java.util.Date;
import java.sql.*;

import com.sgca.exception.SGCAException;
import com.sgca.model.Application;

/**
 * This is the class used for all the database interaction done for application
 * processing and management
 * 
 * @author Alwin Mathew
 * @version 1.0
 */
public class ApplicationDAO {
    // this property stores the number of total entries for a specific subject
    public int rowNumber = 0;

    /**
     * 
     * @param argCourse  contains what course the user needs to see
     * @param argPageNo  contains the page which user wants to see
     * @param rowPerPage stores the number of row items per a page
     * @return an array list of applications satisfying the above constraints
     */
    public ArrayList<Application> getApplications(String argCourse,
        int argPageNo, int rowPerPage) throws SGCAException {
        ArrayList<Application> applications = new ArrayList<Application>();
        int startLimit = (int) ((argPageNo - 1) * rowPerPage);
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM studentreg WHERE Application_status='submitted' "
                    + "AND sub=?   ORDER BY studentrank ASC LIMIT ?,?;");
            ps.setString(1, argCourse);
            ps.setInt(2, startLimit);
            ps.setInt(3, rowPerPage);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Application temp = new Application();
                temp.setId(rs.getInt("id"));
                temp.setApplicationNo(rs.getString("appno"));
                temp.setSubject(rs.getString("sub"));
                temp.setMguNumber(rs.getString("mguno"));
                temp.setPlusTwoCat(rs.getString("pluscat"));
                temp.setStudName(rs.getString("nameOfStudent"));
                temp.setStudentRank(rs.getInt("studentrank"));
                applications.add(temp);
            }
            getNumberOfRows(argCourse);
            return applications;
        } catch (Exception e) {
            System.out.println("Error in appplication dao");
            System.out.println(e.getMessage());
            throw new SGCAException(e);
        }
    }

    // this private method gets the number of entries for a specified course and
    // stores it.
    private void getNumberOfRows(String argCourse) {
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM studentreg where Application_status='submitted'"
                    + " and sub='" + argCourse + "';");
            while (rs.next()) {
                rowNumber = rs.getRow();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method gets all the details of an applicant from database and
     * returns it
     * 
     * @param id the id of the applicant whose data should be fetched
     * @return an Application object containing all the user details
     */
    public Application getApplicant(int id) {
        Application individual = null;
        try {
            Connection conn = DBConnection.getConnection();
            System.out.println(id);
            PreparedStatement stmt = conn
                .prepareStatement("SELECT * FROM studentreg WHERE id = ?;");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // storing all the user value in the object
                individual = new Application();
                individual.setId(rs.getInt("id"));
                individual.setApplicationNo(rs.getString("appno"));
                individual
                    .setApplicationStatus(rs.getString("application_status"));
                individual.setSubject(rs.getString("sub"));
                individual.setMguNumber(rs.getString("mguno"));
                individual.setStudName(rs.getString("nameOfStudent"));
                individual.setSex(rs.getString("sex"));
                individual.setMaritalStatus(rs.getString("maritalStatus"));
                individual.setHandicapped(rs.getString("handicapped"));
                individual.setAddress(rs.getString("address"));
                individual.setPincode(rs.getInt("pincode"));
                individual.setPhno(rs.getString("phno"));
                individual.setEmail(rs.getString("email"));
                individual.setDateOfBirth(rs.getDate("dob") == null ? "nil"
                  : rs.getDate("dob").toString()); // date
                individual.setSslcRegisNo(rs.getString("regnosslc"));
                individual
                  .setSslcDate(rs.getDate("sslcyearmonth") == null ? "nil"
                        : rs.getDate("sslcyearmonth").toString()); // date
                individual.setSslcBoard(rs.getString("sslcboard"));
                individual.setSslcSchool(rs.getString("sslcschool"));
                individual.setSslcPercentage(rs.getInt("sslc_percentage"));
                individual.setPlusTwoCat(rs.getString("pluscat"));
                individual
                    .setPlusTwoDate(rs.getDate("plusyearmonth") == null ? "nil"
                        : rs.getDate("plusyearmonth").toString()); // date
                individual.setPlusTwoRegNo(rs.getString("plusregno"));
                individual.setPlusTwoSchool(rs.getString("plusschool"));
                individual.setPlusTwoBoard(rs.getString("plusboard"));
                individual
                    .setPlusTwoPercentage(rs.getInt("plustwo_percentage"));
//                individual
//                    .setLastCourseAttended(rs.getString("lastcourseattend"));
//                individual.setLastCourseName(rs.getString("lastcoursename"));
//                individual.setLastCourseSchoolName(
//                    rs.getString("lastcoursesccolname"));
//                individual.setTcDate(rs.getDate("tcdate") == null ? "nil"
//                    : rs.getDate("tcdate").toString()); // date
//                individual.setTcNumber(rs.getInt("tcnumber"));
                individual.setReligionCaste(rs.getString("religioncaste"));
                individual.setRegType(rs.getString("regtype"));
                individual.setAnnualIncome(rs.getInt("annualincome"));
                individual.setParentName(rs.getString("nameparent"));
                individual.setParentJob(rs.getString("parentoccupation"));
                individual.setRelGuardian(rs.getString("relguardian"));
                individual.setNccNss(rs.getString("nccnss"));
                individual.setSportsGames(rs.getString("sportsgames"));
                individual
                    .setLiteraryCultural(rs.getString("literarycultural"));
                individual.setStudentRank(rs.getInt("studentrank"));

            }
            return individual;
        } catch (Exception e) {
            System.out.println("Error in appplication dao");
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This function is to search for an applicant base on the given parameters
     * 
     * @param argMguNo specifies the MGU number
     * @param argAdmNo specifies the admission number
     * @param argName  specifies the name of the applicant
     * @return the full details of the applicant or null if no applicant exists
     */
    public List<Application> searchApplications(String argMguNo, String argAdmNo,
            String argName) {
        List<Application> searchResults = new ArrayList<Application>();
       
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM studentreg WHERE appno = ? or mguno=?"
                    + " OR nameOfStudent LIKE  ? ;");
            stmt.setString(1, argAdmNo);
            stmt.setString(2, argMguNo);
            stmt.setString(3, argName);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Application individual = null;
                individual = new Application();
                individual.setId(rs.getInt("id"));
                individual.setApplicationNo(rs.getString("appno"));
                individual.setApplicationStatus("application_status");
                individual.setSubject(rs.getString("sub"));
                individual.setMguNumber(rs.getString("mguno"));
                individual.setStudName(rs.getString("nameOfStudent"));
                individual.setSex(rs.getString("sex"));
                individual.setMaritalStatus(rs.getString("maritalStatus"));
                individual.setHandicapped(rs.getString("handicapped"));
                individual.setAddress(rs.getString("address"));
                individual.setPincode(rs.getInt("pincode"));
                individual.setPhno(rs.getString("phno"));
                individual.setEmail(rs.getString("email"));
                individual.setDateOfBirth(rs.getDate("dob") == null ? "nil"
                    : rs.getDate("dob").toString()); // date
                individual.setSslcRegisNo(rs.getString("regnosslc"));
                individual
                    .setSslcDate(rs.getDate("sslcyearmonth") == null ? "nil"
                        : rs.getDate("sslcyearmonth").toString()); // date
                individual.setSslcBoard(rs.getString("sslcboard"));
                individual.setSslcSchool(rs.getString("sslcschool"));
                individual.setSslcPercentage(rs.getInt("sslc_percentage"));
                individual.setPlusTwoCat(rs.getString("pluscat"));
                individual
                   .setPlusTwoDate(rs.getDate("plusyearmonth") == null ? "nil"
                       : rs.getDate("plusyearmonth").toString());// date
                individual.setPlusTwoRegNo(rs.getString("plusregno"));
                individual.setPlusTwoSchool(rs.getString("plusschool"));
                individual.setPlusTwoBoard(rs.getString("plusboard"));
                individual
                    .setPlusTwoPercentage(rs.getInt("plustwo_percentage"));
//                individual
//                    .setLastCourseAttended(rs.getString("lastcourseattend"));
//                individual.setLastCourseName(rs.getString("lastcoursename"));
//                individual.setLastCourseSchoolName(
//                    rs.getString("lastcoursesccolname"));
//                //individual.setTcDate(rs.getDate("tcdate") == null ? "nil"
//                   // : rs.getDate("tcdate").toString());// date
//                individual.setTcNumber(rs.getInt("tcnumber"));
                individual.setReligionCaste(rs.getString("religioncaste"));
                individual.setRegType(rs.getString("regtype"));
                individual.setAnnualIncome(rs.getInt("annualincome"));
                individual.setParentName(rs.getString("nameparent"));
                individual.setParentJob(rs.getString("parentoccupation"));
                individual.setRelGuardian(rs.getString("relguardian"));
                individual.setNccNss(rs.getString("nccnss"));
                individual.setSportsGames(rs.getString("sportsgames"));
                individual
                    .setLiteraryCultural(rs.getString("literarycultural"));
                searchResults.add(individual);
                individual.setStudentRank(rs.getInt("studentrank"));
            }
            return searchResults;
        } catch (Exception e) {
            System.out.println("Error in appplication search dao");
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This method is to accept an applicant based on the given parameters
     * 
     * @param argId         id of the applicant to be accepted
     * @param argApproverId id of the approver who accepted the applicant
     * @return true if applicant is accepted else false
     */
    public boolean acceptApplication(int argId, int argApproverId) {
        boolean status = false;
        try {
            java.util.Date date = new Date();
            Timestamp formattedDate = new java.sql.Timestamp(date.getTime());
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                "UPDATE studentreg SET application_status='accepted',"
                    + " approverid=?, decisiontime=? WHERE id=?;");
            stmt.setInt(1, argApproverId);
            stmt.setTimestamp(2, formattedDate);
            stmt.setInt(3, argId);
            stmt.execute();
            status = true;
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
    }

    /**
     * This method is to reject and applicant based on the given parameters
     * 
     * @param argId         the id of the applicant to be rejected
     * @param argApproverId id of the approver who rejected the applicant
     * @param argMessage    reason for rejecting the applicant
     * @return true if rejection is completed else false
     */
    public boolean rejectApplicaton(int argId, int argApproverId,
            String argMessage) {
        boolean status = false;
        try {
            java.util.Date date = new Date();
            Timestamp formattedDate = new java.sql.Timestamp(date.getTime());
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                "UPDATE studentreg SET application_status='rejected',"
                    + "rejectcomment=?, approverid=?, decisiontime=? where id=?;");
            stmt.setString(1, argMessage);
            stmt.setInt(2, argApproverId);
            stmt.setTimestamp(3, formattedDate);
            stmt.setInt(4, argId);
            stmt.execute();
            status = true;
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
    }

    /**
     * This function is to get the details of all applicant for the ranking
     * process
     * 
     * @return an arraylist of all applicant details
     */
    public ArrayList<Application> getAllApplications() {
        ArrayList<Application> applications = new ArrayList<Application>();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM studentreg WHERE "
                + "Application_status='submitted' ORDER BY 'studentaggregate';");

            while (rs.next()) {
                Application temp = new Application();
                temp.setId(rs.getInt("id"));
                temp.setApplicationNo(rs.getString("appno"));
                temp.setSubject(rs.getString("sub"));
                temp.setMguNumber(rs.getString("mguno"));
                temp.setStudName(rs.getString("nameOfStudent"));
                temp.setPlusTwoCat(rs.getString("pluscat"));
                temp.setPlusTwoPercentage(rs.getInt("plustwo_percentage"));
                applications.add(temp);
            }
            return applications;
        } catch (Exception e) {
            System.out.println("Error in appplication all function dao");
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * This function is to set the rank of applicants based on the given
     * parameters
     * 
     * @param argRank the new rank of the student to set
     * @param argId   id of the applicant
     * @return return true if ranking is done else false
     */
    public boolean setAggregate(int argTotalMarks, int argId) {
        try {
            System.out.println(argTotalMarks);
            System.out.println('h');
            // getting the connection variable
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                "UPDATE studentreg SET studentaggregate = ? WHERE id = ?;");
            stmt.setInt(1, argTotalMarks);
            stmt.setInt(2, argId);
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error in appplication rank set function dao");
            System.out.println(e.getMessage());
            return false;
        }
    }
    /**
     * This method is for setting rank based on aggregate marks
     * @param argRank
     * @param argId
     * @return
     */
    public boolean setRank(int argRank, int argId) {
        try {
            // getting the connection variable
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                "UPDATE studentreg SET studentrank = ? WHERE id = ?;");
            stmt.setInt(1, argRank);
            stmt.setInt(2, argId);
            stmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error in appplication rank set function dao");
            System.out.println(e.getMessage());
            return false;
        }
    }
}
