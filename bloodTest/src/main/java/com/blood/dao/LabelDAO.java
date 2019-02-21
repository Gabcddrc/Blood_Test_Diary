package com.blood.dao;

import com.blood.pojo.Label;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Swapnil
 * Date: 21/02/2019
 */

@Repository
public interface LabelDAO extends JpaRepository<Label, Long>{
    Label findByName(String labelName);
    Label findById(int id);
    Label findByColor(String color);
}