package com.notification.msnotification.dao

import com.notification.msnotification.entity.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Long> {

    fun findByIdKc(idKc: String): Person?
    fun findByGroup(group: String): Person?
}