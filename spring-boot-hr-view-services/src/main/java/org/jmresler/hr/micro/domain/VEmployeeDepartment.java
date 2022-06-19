package org.jmresler.hr.micro.domain;

import lombok.Data;
import org.jmresler.hr.micro.util.ObjectToJSONStringSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "vEmployeeDepartment", schema = "HumanResources")
@XmlRootElement
public class VEmployeeDepartment implements Serializable, ObjectToJSONStringSerializer {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @Column(name = "Title")
    private String title;
    @Basic(optional = false)
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "MiddleName")
    private String middleName;
    @Basic(optional = false)
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Suffix")
    private String suffix;
    @Basic(optional = false)
    @Column(name = "JobTitle")
    private String jobTitle;
    @Basic(optional = false)
    @Column(name = "Department")
    private String department;
    @Basic(optional = false)
    @Column(name = "GroupName")
    private String groupName;
    @Basic(optional = false)
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Transient
    public static final VEmployeeDepartment EMPTY_V_EMPLOYEE_DEPARTMENT = new VEmployeeDepartment();
}
