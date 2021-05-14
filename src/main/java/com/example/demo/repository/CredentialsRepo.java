package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CredentialsBean;

public interface CredentialsRepo extends JpaRepository<CredentialsBean , Integer>{

}
