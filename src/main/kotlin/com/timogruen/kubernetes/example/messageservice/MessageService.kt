package com.timogruen.kubernetes.example.messageservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@RequestMapping(value = ["/api/v1"])
class TimeService {
    @RequestMapping(value = ["/message/{string}"], method = [RequestMethod.GET])
    fun getMessage(string: String): ResponseEntity<String> {
        val template = RestTemplate()
        val time = template.getForEntity(
                "http://timeservice/api/v1/time",
                String::class.java)
        return ResponseEntity.ok("$time: $string ")
    }

    @RequestMapping(value = ["/shutdown"], method = [RequestMethod.POST])
    fun shutdown() = System.exit(0)
}

fun main(args: Array<String>) {
    SpringApplication.run(TimeService::class.java, *args)
}
