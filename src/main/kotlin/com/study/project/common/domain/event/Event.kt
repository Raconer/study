package com.study.project.common.domain.event

import com.study.project.common.domain.BaseEntity
import com.study.project.common.domain.company.Company
import com.study.project.common.domain.participation.Participation
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

@Entity
@Table(name = "event", catalog = "study")
@DynamicInsert
@DynamicUpdate
data class Event(
    @ManyToOne
    @JoinColumn(name = "company_id")
    var company: Company,

    var name: String,
    var location: String,

    @OneToMany(mappedBy = "event")
    val participations: MutableList<Participation> = mutableListOf()
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
