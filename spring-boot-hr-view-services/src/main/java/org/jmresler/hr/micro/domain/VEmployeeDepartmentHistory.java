package org.jmresler.hr.micro.domain;

import lombok.Data;
import org.jmresler.hr.micro.util.ObjectToJSONStringSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "vEmployeeDepartmentHistory", schema = "HumanResources")
@XmlRootElement
public class VEmployeeDepartmentHistory implements Serializable, ObjectToJSONStringSerializer {

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
    @Column(name = "Shift")
    private String shift;
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
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
}
