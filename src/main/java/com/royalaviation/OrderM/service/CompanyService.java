package com.royalaviation.OrderM.service;

import com.royalaviation.OrderM.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    String createCompany(Company company);

    List<Company> readCompanies();

    boolean deleteCompany(Long id);

    String updateCompany(Long id, Company company);
}
