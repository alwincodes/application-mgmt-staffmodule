package com.sgca.bo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.sgca.dao.ApplicationDAO;
import com.sgca.dao.RankDAO;
import com.sgca.model.Application;
import com.sgca.utility.Constants;

/**
 * Thread for doing the ranking process in the background
 * 
 * @author Alwin Mathew
 * @version 1.0
 */
public class RankThread implements Runnable {
    private String username;

    /**
     * To set the username of administrative staff who started ranking process
     * 
     * @param argUsername username of the staff
     */
    public void setUsername(String argUsername) {
        this.username = argUsername;
    }

    /**
     * Method to rank all applicant
     */
    public void run() {
        //creating an id for the ranking process
        Random rand = new Random();
        // Generate random integers in range 0 to 9999
        int rand_int = rand.nextInt(10000);
        RankDAO database = new RankDAO();
        database.rankStatusUpdate(Constants.RANKING_START, username, rand_int);
        System.out.println("thread start");
        //giving aggregate marks
        ApplicationDAO applicationdao = new ApplicationDAO();
        ArrayList<Application> totalApplications = applicationdao
            .getAllApplications();
        Iterator<Application> ite = totalApplications.iterator();
        while (ite.hasNext()) {
            Application temp = ite.next();
            String category = temp.getPlusTwoCat();
            if (category.equals(Constants.HSE_SCIENCE)) {
                System.out.println("in science block");
                int newRank = scienceRank(temp.getPlusTwoPercentage(),
                    temp.getSubject());
                if (applicationdao.setAggregate(newRank, temp.getId())) {
                }
            } else if (category.equals(Constants.HSE_COMMERCE)) {
                System.out.println("in commerce block");
                int newRank = commerceRank(temp.getPlusTwoPercentage(),
                    temp.getSubject());
                if (applicationdao.setAggregate(newRank, temp.getId())) {
                }
            } else if (category.equals(Constants.HSE_HUMANITIES)) {
                System.out.println("in humanities block");
                int newRank = humanitiesRank(temp.getPlusTwoPercentage(),
                    temp.getSubject());
                if (applicationdao.setAggregate(newRank, temp.getId())) {
                }
            }
        }
        System.out.println("Ranking now");
        //ranking now
        ArrayList<Application> totalApplicationsToRank = applicationdao
            .getAllApplications();
        Iterator<Application> iter = totalApplicationsToRank.iterator();
        int rankCount = 1;
        while (iter.hasNext()) {
            Application temp = iter.next();
            applicationdao.setRank(rankCount, temp.getId());
            rankCount++;
        }
        database.rankStatusUpdate(Constants.RANKING_END, username, rand_int);
        System.out.println("thread end");
    }

    // helper functions
    private int scienceRank(int argPlusTwoPercentage, String argDegree) {
        if (argDegree.equals(Constants.COLL_BSC_PHYSICS)
            || argDegree.equals(Constants.COLL_BSC_CHEMESTRY)
            || argDegree.equals(Constants.COLL_BSC_MATHEMATICS)
            || argDegree.equals(Constants.COLL_BSC_BOTANY)
            || argDegree.equals(Constants.COLL_COMPUTER_APPLICATIONS)
            || argDegree.equals(Constants.COLL_BVOC_FOOD)) {
            return (argPlusTwoPercentage + 10);
        }
        return (argPlusTwoPercentage - 10);
    }

    private int commerceRank(int argPlusTwoPercentage, String argDegree) {
        if (argDegree.equals(Constants.COLL_BCOM_TAXATION)
            || argDegree.equals(Constants.COLL_BCOM_TAXATION)
            || argDegree.equals(Constants.COLL_BCOM_COOPERATION)
            || argDegree.equals(Constants.COLL_BCOM_OFFICEMANAGEMENT)
            || argDegree.equals(Constants.COLL_BVOC_FOOD)) {
            return (argPlusTwoPercentage + 10);
        }
        return (argPlusTwoPercentage - 10);
    }

    private int humanitiesRank(int argPlusTwoPercentage, String argDegree) {
        if (argDegree.equals(Constants.COLL_BA_ENGLISH)
            || argDegree.equals(Constants.COLL_BA_ECONOMICS)
            || argDegree.equals(Constants.COLL_BA_POLITICS)
            || argDegree.equals(Constants.COLL_BA_MASSCOMMUNICATION)) {
            return (argPlusTwoPercentage + 10);
        }
        return (argPlusTwoPercentage - 10);
    }

}
