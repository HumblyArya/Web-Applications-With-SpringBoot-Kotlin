package com.humblyarya.simpleweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@SpringBootApplication
class SimplewebApplication

fun main(args: Array<String>) {
	runApplication<SimplewebApplication>(*args)
	println ("Good Day!")
}

@Controller
class WebApp {

	@GetMapping ("/hello")
	@ResponseBody
	fun greeting () : String {
		return "Hello World"
	}

	//http://localhost:8080/greet/{Arya}  => Hello Arya
	@GetMapping ("/greet/{firstName}")
	@ResponseBody
	fun greetUser (@PathVariable ("firstName") firstName : String) : String {
		return "Hello $firstName"
	}

	//http://localhost:8080/add/{num1}/{num2}
	// http://localhost:8080/add/5/10
	@GetMapping ("/add/{num1}/{num2}")
	@ResponseBody
	fun sum (@PathVariable ("num1") num1: Int, @PathVariable ("num2") num2: Int) : Int {
		var sum : Int  = num1 + num2
		return sum
	}

}