package org.jmresler.hr.aw.views.svcs.dto;

import lombok.Data;
import org.jmresler.hr.aw.views.svcs.domain.VEmployee;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement
public class EmployeeViewList {
    private List<VEmployee> employeeViewList;
}
