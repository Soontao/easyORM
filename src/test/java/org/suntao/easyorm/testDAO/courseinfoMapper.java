package org.suntao.easyorm.testDAO;

import java.util.List;

import org.suntao.easyorm.annotation.SQL;
import org.suntao.easyorm.fulltest.courseinfo;

public interface courseinfoMapper {
	@SQL(value = "select * from courseinfo")
	public List<courseinfo> selectAll();

	@SQL(value = "select * from courseinfo where courseid = ?")
	public courseinfo selectOne(int id);

	@SQL(value = "select * from courseinfo")
	public int count();

	@SQL(value = "UPDATE `courseinfo` set course = '微积分3' where score = 6.0")
	public int update();
}
