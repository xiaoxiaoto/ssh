package org.aoto.jasper.business.impl;

import java.util.List;

import org.aoto.jasper.business.IDrawLineBiz;
import org.aoto.jasper.persistence.dao.IDrawLineDao;
import org.aoto.jasper.persistence.pojo.DrawLinePo;

public class DrawLineBiz implements IDrawLineBiz {
private IDrawLineDao drawLineDao;
	@Override
	public List<DrawLinePo> queryAll() {
		return (List<DrawLinePo>)drawLineDao.queryAll();
	}
	public void setDrawLineDao(IDrawLineDao drawLineDao) {
		this.drawLineDao = drawLineDao;
	}

}
