package id.ten.springbatchbasic.repository;

import id.ten.springbatchbasic.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}