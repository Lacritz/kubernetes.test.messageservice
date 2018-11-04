package com.timogruen.kubernetes.example.messageservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.client.RestTemplate
import java.security.Security


@SpringBootApplication
@RequestMapping(value = ["/api/v1"])
class MessageService {

    @RequestMapping(value = ["/message/{text}"], method = [RequestMethod.GET])
    fun getMessage(@PathVariable("text") text: String): ResponseEntity<String> {
        val template = RestTemplate()
        val time = template.getForEntity("http://timeservice:9000/api/v1/time", String::class.java)
        val ip = template.getForEntity("http://timeservice:9000/api/v1/host", String::class.java)

        return ResponseEntity.ok("[${ip.body}] - ${time.body}: Hello $text! \n")
    }

    @RequestMapping(value = ["/shutdown"], method = [RequestMethod.POST])
    fun shutdown() = System.exit(0)
}

fun main(args: Array<String>) {
    SpringApplication.run(MessageService::class.java, *args)
}
