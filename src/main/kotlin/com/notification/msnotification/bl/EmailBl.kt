package com.notification.msnotification.bl

import jakarta.mail.Message
import jakarta.mail.internet.InternetAddress
import jakarta.mail.internet.MimeMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper

import org.springframework.stereotype.Service

@Service
class EmailBl constructor(
    @Autowired private val mailSender: JavaMailSender
){

    companion object{
        private val logger = org.slf4j.LoggerFactory.getLogger(EmailBl::class.java)
    }
    fun sendEmail(to: String, subject: String, body: String){
        val message = createMimeMessage(to, subject, body)
        logger.info("Sending email to $to")
        logger.info("Subject: $subject")
        mailSender.send(message)
    }

    private fun createMimeMessage(to: String, subject: String, body: String): MimeMessage {
        val message = mailSender.createMimeMessage()
        try {
            message.setFrom(InternetAddress("noreply@example.com"))
            message.addRecipient(Message.RecipientType.TO, InternetAddress(to))
            message.subject = subject
            message.setText(body)
            return message
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}