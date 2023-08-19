package org.jmresler.hr.aw.svcs.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@Embeddable
public class EmployeePayHistoryPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "BusinessEntityID", nullable = false)
    private int businessEntityID;
    @Column(name = "RateChangeDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date rateChangeDate;

}
