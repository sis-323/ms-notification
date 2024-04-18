package com.notification.msnotification.entity

import jakarta.persistence.*

import java.util.*

@Entity
@Table(name = "inscripcion")
class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    var enrollmentId: Long? = null

    @ManyToOne
    @JoinColumn(name = "id_persona")
    var studentId: Person?

    @ManyToOne
    @JoinColumn(name = "id_propuesta")
    var proposalId: Proposal?

    @Column(name = "estado")
    var status: Boolean = true

    @Column(name = "fecha_propuesta")
    var enrollmentDate: Date = Date()

    @Column(name = "semestre")
    var semester: String = ""


    constructor(
            studentId: Person,
            proposalId: Proposal,
            enrollmentDate: Date,
            semester: String
    ) {
        this.studentId = studentId
        this.proposalId = proposalId
        this.enrollmentDate = enrollmentDate
        this.semester = semester
    }

}