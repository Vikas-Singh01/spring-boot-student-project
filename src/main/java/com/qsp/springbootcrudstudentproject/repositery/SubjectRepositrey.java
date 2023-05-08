package com.qsp.springbootcrudstudentproject.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springbootcrudstudentproject.dto.Subjects;

public interface SubjectRepositrey  extends JpaRepository<Subjects, Integer>{

}
