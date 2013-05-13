package cn.edu.dhu.score.analyze.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * interface EtlService
 *
 */
public interface EtlService {
	
	/**
	 * 
	 * 得到distinct sid值的集合,大数据表中需要进行分页查询。
	 *   
	 * @param tableName   表名字
	 * @param fieldName   sid字段名字
	 * @return
	 */
	public List<String> getSidList(String tableName, String fieldName);
	
	/**
	 * 
	 * 得到 同一个sid 的成绩的集合，做平均算
	 * 
	 * @param tableName  表名字
	 * @param itemIdName 检索的字段名字
	 * @param sid        sid的值
	 * @param sidFieldName  sid的字段名字
	 * @return
	 */
	public List<String> getScoreCluster(String tableName, String itemIdName, String sid,String sidFieldName);
	
	/**
	 * 插入新表，平均成绩
	 * @param tableName 表名字
	 * @param sidFieldName sid的字段名字    
	 * @param sid     sid的值
	 * @param score   分数值
	 * @return boolean  是否成功
	 */
	public boolean insertIntoScore(String tableName, String sidFieldName, String sid, String score);
	
	/**
	 * 
	 * @param tableName 表名字
	 * @param fieldName sid的字段名字
	 * @param sid       sid的值
	 * @return 单条记录，九个字段SID,USERTYPE,GENDER, BIRTHDAY, PLACECODE, PLACE, COUNTRY, COLLEGE, MARJOR 
	 */
	public List<String> getSingleRecord(String tableName, final String fieldName, String sid);
	/**
	 * SCORE表专用、、返回一定数量的 Map集合。目前map中包含地域，生日（将会转成星座），学院
	 * @param tableName 表单名字
	 * @param pageCount 每页数量
	 * @param curPage   第几页
	 * @return
	 */
	public List<Map<String,String>> getItems(String tableName, int pageCount, long curPage);
	public String getTest();
}
