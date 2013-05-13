package cn.edu.dhu.score.analyze.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 
 * @version <b>1.0</b>
 */
public class ElementGroup implements Serializable {
	private String id;
	private String no;
	private String name;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	


	/**
	 * 
	 * <br>------------------------------<br>
	 * @param id
	 * @param name
	 * @param age
	 */
	public ElementGroup(String id, String name, String no) {
		this.id=id;
		this.name=name;
		this.no=no;
	}

	
}