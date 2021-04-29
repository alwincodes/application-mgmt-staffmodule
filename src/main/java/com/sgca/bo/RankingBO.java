package com.sgca.bo;

import java.util.List;

import com.sgca.dao.RankDAO;
import com.sgca.model.Rank;

/**
 * This class deals with all the ranking business logic
 * 
 * @author Alwin Mathew
 * @version 1.0
 */
public class RankingBO {
	/**
	 * Method to get the last 10 ranking logs
	 * 
	 * @return a list of recent ranking activity
	 */
	public List<Rank> getRankLogs() {
		return new RankDAO().getRankingLog();
	}

	/**
	 * Method to check if the ranking process is currently on going
	 * 
	 * @return true if the ranking proccess is currently not running else false
	 */
	public boolean rankingCheck() {
		return RankDAO.checkRankStatus();
	}
}
