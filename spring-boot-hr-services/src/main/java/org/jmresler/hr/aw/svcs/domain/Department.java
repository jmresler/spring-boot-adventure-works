package org.jmresler.hr.aw.svcs.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

/**
 * @author jmres
 */
@Data
@Entity
@Table(name = "Department",  schema = "HumanResources")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartmentID", nullable = false)
    private Short departmentID;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "GroupName", nullable = false, length = 50)
    private String groupName;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.EAGER)
    private Collection<EmployeeDepartmentHistory> employeeDepartmentHistoryCollection;

    @Transient
    public static final Department EMPTY_DEPARTMENT = new Department();
}
