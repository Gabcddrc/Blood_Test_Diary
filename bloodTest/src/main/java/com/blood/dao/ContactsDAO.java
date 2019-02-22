package com.blood.dao;

import com.blood.pojo.Contacts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Swapnil
 * Date: 21/02/2019
 */

@Repository
public interface ContactsDAO extends JpaRepository<Contacts, Long>{
    Contacts findById(int id);
    Contacts findByPantient(int idPatient);

}