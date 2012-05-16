package com.vegaasen.htpasswd.server.dao;

import com.vegaasen.htpasswd.server.entity.DummyEntity;

/**
 * Plain DAO which provides only {@link com.vegaasen.htpasswd.server.dao.impl.GenericHibernateDAOImpl} methods
 */
public interface DummyDAO extends GenericDAO<DummyEntity, Long> {
}
