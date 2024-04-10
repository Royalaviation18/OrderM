package com.royalaviation.OrderM.service;

import com.royalaviation.OrderM.entity.Company;
import com.royalaviation.OrderM.entity.CompanyEntity;
import com.royalaviation.OrderM.repository.CompanyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;
    @Override
    public String createCompany(Company company) {
        CompanyEntity companyEntity = new CompanyEntity();
        // from to
        BeanUtils.copyProperties(company, companyEntity);
        companyRepository.save(companyEntity);
        // orders.add(order);
        return "Saved Successfully";
    }

    @Override
    public List<Company> readCompanies() {
        List<CompanyEntity> companiesList = companyRepository.findAll();
        List<Company> companies = new ArrayList<>();
        for (CompanyEntity companyEntity : companiesList) {
            Company comp = new Company();
            comp.setId(companyEntity.getId());
            comp.setCompanyName(companyEntity.getCompanyName());
            comp.setCompanyAddress(companyEntity.getCompanyAddress());
            comp.setCompanyEmail(companyEntity.getCompanyEmail());
            companies.add(comp);
        }
        return companies;
    }

    @Override
    public boolean deleteCompany(Long id) {
        CompanyEntity com = companyRepository.findById(id).get();
        companyRepository.delete(com);
        return true;
    }

    @Override
    public String updateCompany(Long id, Company company) {
        CompanyEntity existingCompany = companyRepository.findById(id).get();
        existingCompany.setCompanyName(company.getCompanyName());
        existingCompany.setCompanyAddress(company.getCompanyAddress());
        existingCompany.setCompanyEmail(company.getCompanyEmail());
        companyRepository.save(existingCompany);
        return "Update Successfully";
    }


}
