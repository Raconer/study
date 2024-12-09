package com.study.project.common.domain.order

import com.study.project.common.domain.BaseEntity
import com.study.project.common.domain.product.Product
import com.study.project.common.domain.user.User
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.Comment
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import java.time.LocalDateTime

@Entity
@Table(name = "order", catalog = "study")
@Comment("사용자가 상품을 구매한 정보를 저장.")
@DynamicInsert
@DynamicUpdate
data class Order(
    @ManyToOne
    @JoinColumn(name = "product_id")
    var product: Product,

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User,

    var quantity: Int,
    var totalPrice: Double,
    var orderDate: LocalDateTime,


    ): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
