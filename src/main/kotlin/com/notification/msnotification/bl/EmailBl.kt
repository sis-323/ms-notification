package com.notification.msnotification.bl

import com.notification.msnotification.dao.PersonRepository
import jakarta.mail.Message
import jakarta.mail.internet.InternetAddress
import jakarta.mail.internet.MimeMessage
import jakarta.persistence.criteria.From
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender

import org.springframework.stereotype.Service

@Service
class EmailBl constructor(
    @Autowired private val mailSender: JavaMailSender,
        @Autowired private val personRepository: PersonRepository
){

    private final val FROM = "ucb_papus@sis.com"
    companion object{
        private val logger = org.slf4j.LoggerFactory.getLogger(EmailBl::class.java)
    }
//    fun sendEmail(to: String, subject: String, body: String){
//        val message = createMimeMessage(to, subject, body)
//        logger.info("Sending email to $to")
//        logger.info("Subject: $subject")
//        mailSender.send(message)
//    }
    fun sendEmail(type: String, userKcUUid: String){


        if(type == "proposal"){
            val professorEmail = personRepository.findByGroup("professors")?.email
            val message = createMimeMessage(professorEmail!!, "New proposal",
            "A new proposal has been submitted by $userKcUUid")
            logger.info("Sending email to $professorEmail")
            logger.info("Subject: New proposal")
            mailSender.send(message)
        }

    }

    private fun createMimeMessage(to: String, subject: String, body: String): MimeMessage {
        val message = mailSender.createMimeMessage()
        try {
            message.setFrom(InternetAddress(FROM))
            message.addRecipient(Message.RecipientType.TO, InternetAddress(to))
            message.subject = subject
            message.setText(body)
            return message
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}