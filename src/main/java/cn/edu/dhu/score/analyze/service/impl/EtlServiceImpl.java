package cn.edu.dhu.score.analyze.service.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import cn.edu.dhu.score.analyze.dao.EtlDAO;
import cn.edu.dhu.score.analyze.model.KaasItem;
import cn.edu.dhu.score.analyze.service.EtlService;


/**
 * Hello world!
 *
 */
public class EtlServiceImpl implements EtlService {

	public EtlDAO etlDAO;

	public EtlDAO getEtlDAO() {
		return etlDAO;
	}

	public void setEtlDAO(EtlDAO transformerDAO) {
		this.etlDAO = transformerDAO;
	}

	public List<String> getSidList(String tableName, String fieldName) {
		return etlDAO.getSidList(tableName, fieldName);
	}

	public List<String> getScoreCluster(String tableName, String itemIdName, String sid,String sidFieldName) {
		
		return etlDAO.getScoreCluster(tableName, itemIdName, sid, sidFieldName);
	}

	public boolean insertIntoScore(String tableName, String sidFieldName, String sid, String score) {
		return etlDAO.insertIntoScore(tableName, sidFieldName, sid, score);
		
	}

	public List<String> getSingleRecord(String tableName, String fieldName, String sid) {
		
		return etlDAO.getSingleRecord(tableName, fieldName, sid);
	}

	public List<Map<String, String>> getItems(String tableName, int pageCount, long curPage) {
		
		return etlDAO.getItems(tableName, pageCount, curPage);
	}

	public String getTest() {
		
		return etlDAO.getTest();
	}
	


}
