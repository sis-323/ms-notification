package com.notification.msnotification.api

import com.notification.msnotification.bl.EmailBl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/email")
class EmailApi constructor(
        @Autowired private val emailBl: EmailBl
){

    @PostMapping("/")
    fun sendEmail(@RequestParam to: String,
                    @RequestParam subject: String,
                    @RequestParam body: String) : String{
            emailBl.sendEmail(to, subject, body)
            return "Email sent"
    }
}