package com.royalaviation.OrderM.repository;

import com.royalaviation.OrderM.entity.OrderEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    public List<OrderEntity> findByCustomerEntityCustomerName(String customerName);
    public List<OrderEntity> findByCompanyEntityId(Long companyId);
    // public List<OrderEntity> findByCompanyEntityIdAndCreatedAtGreaterThanEqual(Long companyId, Date date);
}
