/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jmresler.aw.entities.hr;

import lombok.Data;
import org.jmresler.aw.entities.util.JsonSerializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * @author jmres
 */
@Data
@XmlRootElement
@Entity
@Table(name = "Shift", catalog = "AdventureWorks2017", schema = "HumanResources", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"StartTime", "EndTime"}),
        @UniqueConstraint(columnNames = {"Name"})})
public class Shift implements Serializable, JsonSerializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShiftID", nullable = false)
    private Short shiftID;
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "StartTime", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "EndTime", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Column(name = "ModifiedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shift")
    private Collection<EmployeeDepartmentHistory> employeeDepartmentHistoryCollection;

}
