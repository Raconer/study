package com.study.project.common.domain.user

import com.study.project.common.domain.BaseEntity
import com.study.project.common.domain.activityLog.ActivityLog
import com.study.project.common.domain.company.Company
import com.study.project.common.domain.feedback.Feedback
import com.study.project.common.domain.order.Order
import com.study.project.common.domain.participation.Participation
import com.study.project.common.domain.surveyResponse.SurveyResponse
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

@Entity
@Table(name = "user", catalog = "study")
@Comment("사용자 정보를 저장하며, 회사와 관계를 맺습니다.")
@DynamicInsert
@DynamicUpdate
data class User(
    @Column(name = "name",nullable = false)
    @Comment("사용자 이름")
    var name:String? = null,

    @Column(name = "email", nullable = false, unique = true)
    @Comment("사용자 이메일")
    var email:String? = null,

    @Column(name = "role", nullable = false, unique = true)
    @Comment(" 역할 (예: Admin, Employee 등)")
    var role: String,

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @Comment("소속 회사 ID")
    val company: Company
): BaseEntity(){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("사용자 고유 ID")
    var id:Long? = null


    @OneToMany(mappedBy = "user")
    val orders: MutableList<Order> = mutableListOf()

    @OneToMany(mappedBy = "user")
    val activityLogs: MutableList<ActivityLog> = mutableListOf()

    @OneToMany(mappedBy = "user")
    val feedbacks: MutableList<Feedback> = mutableListOf()

    @OneToMany(mappedBy = "user")
    val participations: MutableList<Participation> = mutableListOf()

    @OneToMany(mappedBy = "user")
    val surveyResponses: MutableList<SurveyResponse> = mutableListOf()


}