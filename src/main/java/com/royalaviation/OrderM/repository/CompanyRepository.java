package com.royalaviation.OrderM.repository;

import com.royalaviation.OrderM.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository <CompanyEntity,Long> {
}
