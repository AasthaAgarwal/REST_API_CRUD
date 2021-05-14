package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ProfileBean;

public interface ProfileRepo extends JpaRepository<ProfileBean , Integer>{

}

