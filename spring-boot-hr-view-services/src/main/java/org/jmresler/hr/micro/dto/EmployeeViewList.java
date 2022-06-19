package org.jmresler.hr.micro.dto;

import lombok.Data;
import org.jmresler.hr.micro.domain.VEmployee;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement
public class EmployeeViewList {
    private List<VEmployee> employeeViewList;
}
