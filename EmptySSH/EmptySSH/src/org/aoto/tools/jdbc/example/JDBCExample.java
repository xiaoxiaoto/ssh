package org.aoto.tools.jdbc.example;

import java.util.List;

import javax.annotation.Resource;

import org.aoto.tools.jdbc.business.IJDBCBaseSerives;
import org.aoto.tools.jdbc.persistence.dao.impl.EntityRowMapper;
import org.aoto.tools.jdbc.persistence.dao.impl.ListRowMapper;
import org.aoto.tools.jdbc.persistence.dao.impl.TitleRowMapper;
import org.aoto.tools.jdbc.persistence.vo.DrawLineVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/jdbc")
public class JDBCExample {

	@Resource(name = "jdbcBaseServices")
	private IJDBCBaseSerives jdbcBaseSerives;
	
	@RequestMapping(value = "/queryTitle")
	public void queryTitle() {
		String sql = "select eventid,modelname,modelid from DRAWLINE";
		List<Object> titile = jdbcBaseSerives.queryTitle(sql,
				new TitleRowMapper());
		System.out.println(titile);
	}
	@RequestMapping(value = "/queryList")
	public void queryList() {
		String sql = "select eventid,modelname,modelid from DRAWLINE";
		List<Object> rows = jdbcBaseSerives.queryAll(sql, new ListRowMapper());
		System.out.println(rows);
	}
	@RequestMapping(value = "/queryEntity")
	public void queryEntity() {
		String sql = "select eventid,modelname,modelid from DRAWLINE";
		List<Object> entitys = jdbcBaseSerives.queryAll(sql, new EntityRowMapper(DrawLineVo.class));
		System.out.println(entitys);
	}

}
