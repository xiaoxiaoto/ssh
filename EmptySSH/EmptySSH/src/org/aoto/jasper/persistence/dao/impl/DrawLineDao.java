package org.aoto.jasper.persistence.dao.impl;

import java.util.List;

import org.aoto.jasper.persistence.dao.IDrawLineDao;
import org.aoto.jasper.persistence.pojo.DrawLinePo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class DrawLineDao implements IDrawLineDao {
private SessionFactory sessionFactory;
	@Override
	public List queryAll() {
		Session session = sessionFactory.getCurrentSession();
		String hql="from DrawLinePo  order by eventid";
		Query query = session.createQuery(hql);
		List<DrawLinePo> list =(List<DrawLinePo>) query.list();
		return list;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
