package com.study.project.common.domain.surveyResponse

import com.study.project.common.domain.BaseEntity
import com.study.project.common.domain.user.User
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

@Entity
@Table(name = "survey_response", catalog = "study")
@DynamicInsert
@DynamicUpdate
data class SurveyResponse(
    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User,

    var question: String,
    var answer: String
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
