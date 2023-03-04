package com.example.supletorio.controller

import com.example.supletorio.model.Estudiante
import com.example.supletorio.service.EstudianteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/estudiante")
class EstudianteController {

    @Autowired
    lateinit var estudianteService: EstudianteService

    @GetMapping
    fun list():List<Estudiante>{
        return estudianteService.list()
    }


    @GetMapping("/with")
    fun listWithClient (): ResponseEntity<List<*>> {
        return ResponseEntity(estudianteService.listWithEstudiante(), HttpStatus.OK)
    }
    
    @PostMapping
    fun save (@RequestBody @Valid estudiante:Estudiante):ResponseEntity<Estudiante>{
        return ResponseEntity(estudianteService.save(estudiante), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody estudiante:Estudiante):ResponseEntity<Estudiante>{
        return ResponseEntity(estudianteService.update(estudiante), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody estudiante:Estudiante):ResponseEntity<Estudiante>{
        return ResponseEntity(estudianteService.updateName(estudiante), HttpStatus.OK)
    }


}