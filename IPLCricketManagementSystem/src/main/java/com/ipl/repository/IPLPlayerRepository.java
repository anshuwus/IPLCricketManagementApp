package com.ipl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipl.entity.IPLPlayer;

public interface IPLPlayerRepository extends JpaRepository<IPLPlayer, Integer>{

}
