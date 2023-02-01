package de.springbootarchetype

import de.springbootarchetype.util.SpringContextHolder.Companion.applicationContext
import de.springbootarchetype.util.StaticUtils
import de.springbootarchetype.util.StaticUtils.Companion.determineHost
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@ComponentScan(basePackages = ["de.springbootarchetype"])
@EnableScheduling
open class Application : SpringBootServletInitializer() {

    companion object {
        val logger: Log = LogFactory.getLog(this.javaClass)
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)

    val environment = applicationContext!!.environment
    val profile = StaticUtils.determineProfile(environment)
    val host = determineHost(environment)
    val port = environment.getProperty("local.server.port")

    Application.logger.info("Active profile: $profile")
    Application.logger.info("Spring Boot Archetype Backend application is running on http://$host:$port")
}

