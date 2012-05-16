package com.vegaasen.htpasswd.server.dao.impl;

import org.springframework.stereotype.Repository;

import com.vegaasen.htpasswd.server.dao.DummyDAO;
import com.vegaasen.htpasswd.server.entity.DummyEntity;

/**
 * Plain DAO which provides only {@link com.vegaasen.htpasswd.server.dao.impl.GenericHibernateDAOImpl} methods
 */
@Repository
public class DummyDAOImpl extends GenericHibernateDAOImpl<DummyEntity, Long> implements DummyDAO {
    
}
