package org.jmresler.hr.aw.views.svcs.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jmresler.hr.aw.views.svcs.util.ObjectToJSONStringSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "A comprehensive view into an employee and their related department")
@Data
@Entity
@Table(name = "vEmployeeDepartment", schema = "HumanResources")
@XmlRootElement
public class VEmployeeDepartment implements Serializable, ObjectToJSONStringSerializer {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty
    @Id
    @Basic(optional = false)
    @Column(name = "BusinessEntityID")
    private int businessEntityID;
    @ApiModelProperty
    @Column(name = "Title")
    private String title;
    @ApiModelProperty
    @Basic(optional = false)
    @Column(name = "FirstName")
    private String firstName;
    @ApiModelProperty
    @Column(name = "MiddleName")
    private String middleName;
    @ApiModelProperty
    @Basic(optional = false)
    @Column(name = "LastName")
    private String lastName;
    @ApiModelProperty
    @Column(name = "Suffix")
    private String suffix;
    @ApiModelProperty
    @Basic(optional = false)
    @Column(name = "JobTitle")
    private String jobTitle;
    @ApiModelProperty
    @Basic(optional = false)
    @Column(name = "Department")
    private String department;
    @ApiModelProperty
    @Basic(optional = false)
    @Column(name = "GroupName")
    private String groupName;
    @ApiModelProperty
    @Basic(optional = false)
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Transient
    public static final VEmployeeDepartment EMPTY_V_EMPLOYEE_DEPARTMENT = new VEmployeeDepartment();
}
