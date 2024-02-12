package com.company.repository;

import com.company.entity.Souvenir;
import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SouvenirRepository extends JpaRepository<Souvenir,Integer> {
}
