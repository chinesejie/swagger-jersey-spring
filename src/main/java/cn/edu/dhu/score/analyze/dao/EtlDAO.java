package cn.edu.dhu.score.analyze.dao;

import java.util.List;
import java.util.Map;

public interface EtlDAO {
	
	public List<String> getSidList(String tableName, String fieldName);
	public List<String> getScoreCluster(String tableName, String itemIdName, String sid,String sidFieldName);
	public boolean insertIntoScore(String tableName, String sidFieldName, String sid, String score);
	public List<String> getSingleRecord(String tableName, final String fieldName, String sid);

	public List<Map<String,String>> getItems(String tableName, int pageCount, long curPage);
	public String getTest();
}