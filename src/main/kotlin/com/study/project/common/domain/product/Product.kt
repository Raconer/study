package com.study.project.common.domain.product

import com.study.project.common.domain.BaseEntity
import com.study.project.common.domain.company.Company
import com.study.project.common.domain.order.Order
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.hibernate.annotations.Comment
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

@Entity
@Table(name = "product", catalog = "study")
@Comment("회사가 제공하는 상품 정보를 저장.")
@DynamicInsert
@DynamicUpdate
data class Product(

    @ManyToOne
    @JoinColumn(name = "company_id")
    @Comment("상품 소유 회사 ID")
    var company: Company,

    @Column(name = "name")
    @Comment("상품명")
    var name: String,

    @Column(name = "category")
    @Comment("상품 카테고리")
    var category: String,

    @Column(name = "price")
    @Comment("가격")
    var price: Double,
    ): BaseEntity(){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("상품 고유 ID")
    var id: Long? = null


    @OneToMany(mappedBy = "product")
    @Comment("상품 고유 ID")
    val orders: MutableList<Order> = mutableListOf()
}
