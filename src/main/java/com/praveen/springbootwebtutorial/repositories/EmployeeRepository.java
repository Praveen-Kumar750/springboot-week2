package com.praveen.springbootwebtutorial.repositories;

import com.praveen.springbootwebtutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}
