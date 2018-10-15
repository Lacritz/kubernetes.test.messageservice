package com.timogruen.kubernetes.example.messageservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.client.RestTemplate
import java.net.InetAddress


@SpringBootApplication
@RequestMapping(value = ["/api/v1"])
class TimeService {

    @RequestMapping(value = ["/message"], method = [RequestMethod.GET])
    fun getMessage(): ResponseEntity<String> {
        val template = RestTemplate()
        val time = template.getForEntity("http://timeservice:9000/api/v1/time", String::class.java)
        val ip = InetAddress.getByName("timeservice")
        return ResponseEntity.ok("[${ip.hostAddress}] - ${time.body}: Hello World!")
    }

    @RequestMapping(value = ["/shutdown"], method = [RequestMethod.POST])
    fun shutdown() = System.exit(0)
}

fun main(args: Array<String>) {
    SpringApplication.run(TimeService::class.java, *args)
}
