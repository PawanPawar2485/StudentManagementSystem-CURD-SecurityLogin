package in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.entity.*;


public interface StudentRepo extends JpaRepository<Student, Integer>{

}