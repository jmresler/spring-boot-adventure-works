package org.jmresler.hr.aw.views.svcs.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jmresler.hr.aw.views.svcs.util.ObjectToJSONStringSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "View into an employee and their history within their department")
@Data
@Entity
@Table(name = "vEmployeeDepartmentHistory", schema = "HumanResources")
@XmlRootElement
public class VEmployeeDepartmentHistory implements Serializable, ObjectToJSONStringSerializer {

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
    @Column(name = "Shift")
    private String shift;
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
    @ApiModelProperty
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
}
