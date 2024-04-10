package com.royalaviation.OrderM.controller;


import com.royalaviation.OrderM.entity.Company;
import com.royalaviation.OrderM.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("companies")
    public List<Company> getAllCompany(){
        return companyService.readCompanies();
    }

    @PostMapping("companies")
    public String postMethodName(@RequestBody Company company){
        return companyService.createCompany(company);
    }

    @DeleteMapping("companies/{id}")
    public String deleteCompany(@PathVariable Long id) {
        if (companyService.deleteCompany(id))
            return "Deleted Successfully";
        return "Not found";
    }

    @PutMapping("companies/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Company company) {
        return companyService.updateCompany(id, company);
    }
    
}
