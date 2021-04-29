package com.sgca.bo;

import java.util.*;
import com.sgca.dao.ApplicationDAO;
import com.sgca.exception.SGCAException;
import com.sgca.model.Application;

/**
 * This class contains all the business logic regarding application handling and
 * ranking
 * 
 * @author Alwin Mathew
 * @version 1.0
 */

public class ApplicationBO {
    int totalitems = 0;

    /**
     * This method is used to get a list of user data in a lilmit
     * 
     * @param argCourse  name of the course
     * @param argPageNo  the page number to view
     * @param rowPerPage number of rows each page should have
     * @return returns an arraylist of type application containing user details
     */
    public ArrayList<Application> getValue(String argCourse, int argPageNo,
                int rowPerPage) {
        ArrayList<Application> applications = null;
        ApplicationDAO dao = new ApplicationDAO();
        try {
            applications = dao.getApplications(argCourse, argPageNo, rowPerPage);
        } catch (SGCAException e) {
            applications = null;
        }
        totalitems = dao.rowNumber;
        return applications;
    }

    /**
     * Used to get total number of users for a given course
     * 
     * @return number of users
     */
    public int getApplicationNumber() {
        return totalitems;
    }

    /**
     * Used to search for an applicant with matching details
     * 
     * @param argMguNo  Mahatma Gandhi University number
     * @param argAdmnNo Admission for the application
     * @param name      Name of the applicant
     * @return Application object with user details or null if the user dosen't
     *         exist
     */
    public List<Application> searchApplicant(String argMguNo, String argAdmnNo,
        String name) {
        return new ApplicationDAO().searchApplications(argMguNo, argAdmnNo,
            name);
    }

    /**
     * Used to get a single applicant details
     * 
     * @param argId the id of the applicant entry in the database
     * @return Application object with user details or null if the user dosent
     *         exist
     */
    public Application viewApplicant(int argId) {
        return new ApplicationDAO().getApplicant(argId);
    }

    /**
     * Function to accept an applicant
     * 
     * @param argId         id of the application stored in the database
     * @param argApproverId the id of adminstration staff who approved the
     *                      application
     * @return true if the process is a success else false
     */
    public boolean acceptApplicant(int argId, int argApproverId) {
        return new ApplicationDAO().acceptApplication(argId, argApproverId);
    }

    /**
     * Function to reject an applicant
     * 
     * @param argId      id of the applicant stored in the database
     * @param argAdmnNo  admission number of the applicant
     * @param argMessage reason for rejection of the application
     * @return true if the process is a success else false
     */
    public boolean rejectApplicant(int argId, int argAdmnNo,
        String argMessage) {
        return new ApplicationDAO().rejectApplicaton(argId, argAdmnNo,
            argMessage);
    }

    /**
     * To start the process of rank creation
     * 
     * @param argUsername the username of administration staff who started the
     *                    ranking process
     * @return true if ranking process started else false
     */
    public boolean createRanks(String argUsername) {
        boolean status = false;
        System.out.println("outside blocking check");
        RankingBO state = new RankingBO();
        if (state.rankingCheck()) {
            RankThread threadObj = new RankThread();
            threadObj.setUsername(argUsername);
            Thread rankMaker = new Thread(threadObj);
            System.out.println("near threadrun");
            rankMaker.run();
            status = true;
        }
        return status;

    }

}
