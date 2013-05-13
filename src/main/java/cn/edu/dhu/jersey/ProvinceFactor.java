package cn.edu.dhu.jersey;

/**
 * 
 * @author Administrator
 * A -> 省份： 置信度、
 */
public class ProvinceFactor extends Po{
	private String grade;
	private String provinceName;
	private double percent;
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	
}
