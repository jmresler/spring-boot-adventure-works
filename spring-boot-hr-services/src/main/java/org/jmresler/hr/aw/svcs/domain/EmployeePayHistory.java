package org.jmresler.hr.aw.svcs.domain;

import lombok.Data;
import org.jmresler.hr.aw.svcs.util.JsonSerializable;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@Entity
@Table(name = "EmployeePayHistory", schema = "HumanResources")
public class EmployeePayHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmployeePayHistoryPK employeePayHistoryPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Rate", nullable = false, precision = 19, scale = 4)
    private BigDecimal rate;
    @Column(name = "PayFrequency", nullable = false)
    private short payFrequency;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "BusinessEntityID", referencedColumnName = "BusinessEntityID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;
}
