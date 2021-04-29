package com.sgca.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sgca.bo.*;
import com.sgca.model.Application;
import com.sgca.model.Rank;

/**
 * This class is a servlet which handles all the request's to the website
 * 
 * @author Alwin Mathew
 * @version 1.0
 */
public class DisplayApplications extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * this function which handles all the get and post requeset's
     * 
     * @param request  An object which is given by tomcat and contains all the
     *                 data passed from client side
     * @param response An object which is given by tomcat to return the data
     *                 after processing
     * @throws ServletException An exception thrown when something bad happends
     *                          with the servlet
     * @throws IOException      An exception thrown when I-O error occours
     */
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String nextPage = "view.jsp";
        
        /* These if else conditions are to differentiate different types of
          request from different pages */
        if (action == null) {
            boolean status = prepareTheListPage(request, response);
            if (status) {
                nextPage = "view.jsp";
            }

        } else if (action.equals("viewdetails")) {
            boolean status = prepareViewPage(request, response);
            if (status) {
                nextPage = "viewapplication.jsp";
            }
        } else if (action.equals("search")) {
            // search page
            boolean status = prepareSearchPage(request, response);
            if (status) {
                nextPage = "search.jsp";
            } else {
                nextPage = "search.jsp";
            }
        } else if (action.equals("accept")) {
            // accept student
            if (acceptApplicant(request, response)) {
                nextPage = "view.jsp";
            }

        } else if (action.equals("reject")) {
            // reject student
            if (rejectApplicant(request, response)) {
                nextPage = "rejectconfirmation.jsp";
            }
        } else if (action.equals("ranklog")) {
            if (viewRankLog(request, response)) {
                nextPage = "responsetable.jsp";
            }
        } else if (action.equals("makerank")) {
            // rank students
            System.out.println(action);
            if (rankMaker()) {
                nextPage = "viewranklog.jsp";
                System.out.println("rank created");
            } else {
                System.out.println("rank not created");
            }
        }

        // forwarding to view with the data after processing the request
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);
    }
    
    /**
     * This methods is for preparing the application view page with list view
     * of application details
     * @param request contains web request information
     * @param response contains information to be sent from the server
     * @return false in case of error else true
     */
    private boolean prepareTheListPage(HttpServletRequest request,
                                                 HttpServletResponse response) {
        boolean status = false;
        // course from post request
        if (request.getParameter("course") != null
            && request.getParameter("course") != "") {
            courseSet(request.getParameter("course"), request);
        }

        // number of rows per page post request
        if (request.getParameter("rownumber") != null
            && request.getParameter("rownumber") != "") {
            rowSet(Integer.parseInt(request.getParameter("rownumber")),
                request);
        }

        int noOfApplications = 0;
        ArrayList<Application> list = null;
        HttpSession session = request.getSession();
        
        // page will only display something if course and row is not null
        if ((session.getAttribute("course") != null)
            && (session.getAttribute("row") != null)) {

            int pageNo;
            if (request.getParameter("page") == null) {
                pageNo = 1;
            } else {
                pageNo = Integer.parseInt(request.getParameter("page"));
            }

            // rows to be displayed per page
            int rowsPerPage = (Integer) session.getAttribute("row");

            // getting rows and total number of rows
            ApplicationBO getApplications = new ApplicationBO();
            String course = (String) session.getAttribute("course");
            list = getApplications.getValue(course, pageNo, rowsPerPage);
            noOfApplications = (int) Math.ceil(
                (getApplications.getApplicationNumber() / (float) rowsPerPage));
            // sending values to view
            request.setAttribute("listofapplication", list);
            request.setAttribute("applicationnumber", noOfApplications);
            status = true;
        }
        return status;
    }
    
    /**
     * prepares a page with an individual users information
     * @param request contains web request information
     * @param response contains information to be sent from the server
     * @return false in case of error else true
     */
    private boolean prepareViewPage(HttpServletRequest request,
                                                 HttpServletResponse response) {
        boolean status = false;
        try {
            int viewId = Integer.parseInt(request.getParameter("viewid"));
            Application individualDetails = new ApplicationBO()
                .viewApplicant(viewId);
            request.setAttribute("individualdetails", individualDetails);
            status = true;
        } catch (Exception e) {
            status = false;
        }
        return status;
    }
    
    /**
     * This method handles the searching page
     * @param request contains web request information
     * @param response contains information to be sent from the server
     * @return false in case of error else true
     */
    private boolean prepareSearchPage(HttpServletRequest request,
        HttpServletResponse response) {
        boolean status = false;
        String searchTerm = "";

        if (request.getParameter("searchoption") != null
                               && request.getParameter("searchquery") != null) {
            int searchOption = Integer
                .parseInt(request.getParameter("searchoption"));
            String searchQuery = request.getParameter("searchquery");
            switch (searchOption) {
            case 1:
                searchTerm = searchQuery;
                break;

            case 2:
                searchTerm = searchQuery;
                break;

            case 3:
                searchTerm = searchQuery;
            }
            ApplicationBO applicationBo = new ApplicationBO();
            List <Application> applicants = applicationBo.searchApplicant(searchTerm,
                                                      searchTerm, searchTerm);
            if (applicants != null) {
                request.setAttribute("individualdetails", applicants);
            }
            status = true;
        }
        return status;
    }
    
    /**
     * This function is for accepting an applicant
     * @param request contains web request information
     * @param response contains information to be sent from the server
     * @return false in case of error else true
     */
    private boolean acceptApplicant(HttpServletRequest request,
        HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("acceptid"));
        int approverId = 5;// need to get this from session
        request.setAttribute("message", "Student has been accepted");
        return new ApplicationBO().acceptApplicant(id, approverId);
    }
    
    /**
     * This method is used for rejecting an applicant with a reason
     * @param request contains web request information
     * @param response contains information to be sent from the server
     * @return false in case of error else true
     */
    public boolean rejectApplicant(HttpServletRequest request,
                                                 HttpServletResponse response) {
        boolean status = false;
        if (request.getParameter("rejectid") != null
            && request.getParameter("rejectreason") == null) {
            int rejectId = Integer.parseInt(request.getParameter("rejectid"));
            Application individualDetails = new ApplicationBO()
                .viewApplicant(rejectId);
            request.setAttribute("rejectDetails", individualDetails);
            status = true;
        }

        if (request.getParameter("rejectreason") != null) {
            String rejectReason = "";
            int rejectId = 0;
            int rejecterId = 5;// need to get from session

            rejectReason = request.getParameter("rejectreason");
            rejectId = Integer.parseInt(request.getParameter("rid"));
            new ApplicationBO().rejectApplicant(rejectId, rejecterId,
                rejectReason);
            request.setAttribute("message", "Student has been rejected");
            status = false;
        }
        return status;
    }

    /**
     * This method starts the ranking process
     * @return false if an error occurred else true
     */
    private boolean rankMaker() {
        return new ApplicationBO().createRanks("alwin007");
    }
    
    /**
     * Displays the ranking logs in order and the admin who started it
     * @param request contains web request information
     * @param response contains information to be sent from the server
     * @return false in case of error else true
     */
    private boolean viewRankLog(HttpServletRequest request,
        HttpServletResponse response) {
        boolean status = false;
        List<Rank> log = new RankingBO().getRankLogs();
        if (log != null) {
            request.setAttribute("rankLogs", log);
            status = true;
        }
        return status;
    }
    
    /*This function is used to set course to session so that it persists in the
    next http request*/
    private void courseSet(String course, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("course", course);
    }
    
    /*This function is used to set course to session so that it persists in the
    next http request*/
    private void rowSet(int row, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("row", row);
    }
}