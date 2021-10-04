package id.ten.springbatchbasic.configuration.processor;


import id.ten.springbatchbasic.dto.EmployeeDto;
import id.ten.springbatchbasic.model.Company;
import id.ten.springbatchbasic.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class EmployeeItemProcessor implements ItemProcessor<EmployeeDto, EmployeeDto>
{
    private static final Logger logger = LoggerFactory.getLogger(EmployeeItemProcessor.class);

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public EmployeeDto process (EmployeeDto employeeDto) throws Exception
    {
        if(validateCompany(employeeDto))
        {
            return employeeDto;
        }

        logger.debug("Not a valid company, can't save the employee");
        return null;
    }

    private boolean validateCompany (EmployeeDto employeeDto)
    {
        Optional<Company> company = companyRepository.findById(employeeDto.getCompanyId());
        if(company.isPresent())
        {
            return true;
        }
        return false;
    }
}