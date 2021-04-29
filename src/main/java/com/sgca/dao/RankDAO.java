package com.sgca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sgca.model.Rank;
/**
 * 
 * @author alwin
 *@version 1.0
 *
 *This class contains all the methods and properties needed to interact with the
 *database for ranking needs
 */
public class RankDAO {
    /**
     * 
     * @return a list object of type Rank containing last 10 ranking logs
     */
    public List<Rank> getRankingLog() {
        List<Rank> rankingLog = null;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(
                "select * from ranking order by id DESC limit 0,10 ");
            ResultSet rs = pst.executeQuery();
            rankingLog = new ArrayList<Rank>();
            while (rs.next()) {

                Rank obj = new Rank();
                obj.setId(rs.getInt("id"));
                obj.setProcess_status(rs.getString("process_status"));
                obj.setTime(rs.getTimestamp("time").toLocalDateTime());
                obj.setUser(rs.getString("user"));
                obj.setRankId(rs.getInt("processid"));
                rankingLog.add(obj);
            }
            return rankingLog;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rankingLog;
        }
    }
    /**
     * This method is for updating rank status when an admin starts ranking p
     * process
     * @param argStatus the status which should be updated either started or 
     *        stopped
     * @param argUser the admin staff who started the ranking process
     */
    public void rankStatusUpdate(String argStatus, String argUser, int argRankId) {
        try {
            java.util.Date date = new Date();
            Timestamp formattedDate = new java.sql.Timestamp(date.getTime());
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(
                "INSERT INTO `application`.`ranking` "
                        + "(`process_status`, `user`, `time`,`processid`) VALUES (?,?,?,?);");
            pst.setString(1, argStatus);
            pst.setString(2, argUser);
            pst.setTimestamp(3, formattedDate);
            pst.setInt(4, argRankId);
            pst.execute();
        } catch (Exception e) {
            System.out.println("error in rank update");
            System.out.println(e.getMessage());
        }
    }
    /**
     * This method is for checking if a ranking process is currently active 
     * @return true if process is currently not ongoing else false 
     */
    public static boolean checkRankStatus() {
        boolean status = true;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn
                .prepareStatement("select * from ranking order by id desc");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("checking for existing process");
                String processStatus = rs.getString("process_status");
                if (processStatus.equals("Started")) {
                    status = false;
                }
            }
            return status;
        } catch (Exception e) {
            System.out.println("error in rank status checker");
            System.out.println(e.getMessage());
            return status;
        }
    }
}
