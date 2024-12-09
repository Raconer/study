package com.study.project.common.domain.company

import com.study.project.common.domain.BaseEntity
import com.study.project.common.domain.event.Event
import com.study.project.common.domain.product.Product
import com.study.project.common.domain.user.User
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

@Entity
@Table(name = "company", catalog = "study")
@Comment("회사 정보를 저장하는 테이블")
@DynamicInsert
@DynamicUpdate
data class Company(
    @Column(name = "name", nullable = false)
    @Comment("회사명")
    var name:String? = null,
    @Column(name = "address", nullable = false)
    @Comment("회사 주소")
    var address:String? = null,
    @Column(name = "industry", nullable = false)
    @Comment("업종")
    var industry:String? = null,
): BaseEntity(){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("회사 고유 ID")
    var id:Long? = null

    @OneToMany(mappedBy = "company")
    val users:MutableList<User> = mutableListOf()

    @OneToMany(mappedBy = "company")
    val products: MutableList<Product> = mutableListOf()

    @OneToMany(mappedBy = "company")
    val events: MutableList<Event> = mutableListOf()
}
