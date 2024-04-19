package com.notification.msnotification.api

import com.notification.msnotification.bl.EmailBl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/email")
class EmailApi(
        @Autowired private val emailBl: EmailBl
){
    companion object{
        private val logger = org.slf4j.LoggerFactory.getLogger(EmailApi::class.java)
    }

    @PostMapping("/")
    fun sendEmail(@RequestParam("userKc") userKcId: String,
                @RequestParam("type") type: String){
        logger.info("Sending email to $userKcId")
        emailBl.sendEmail(type, userKcId)
    }

}

