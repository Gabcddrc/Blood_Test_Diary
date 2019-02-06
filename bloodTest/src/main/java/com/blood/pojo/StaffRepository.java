package com.blood.pojo;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Long>{

}