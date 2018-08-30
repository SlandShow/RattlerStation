package com.slandshow.DAO;

import org.springframework.stereotype.Repository;

import java.util.List;

/*
 *  Impl only one DAO for all sub DAO's
 *  with common methods:
 *  add, update, delete, getAll, getById
 *
 *  Apply CRUD
 *
 */

@Repository
public interface GenericDAO<E> {

    void add(E entity);

    void update(E entity);

    void delete(E entity);

    List<E> getAll();

    E getById(Long id);
}
