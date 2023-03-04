package com.example.supletorio.controller

import com.example.supletorio.model.Curso
import com.example.supletorio.service.CursoService
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
@RequestMapping("/curso")
class CursoController {

    @Autowired
    lateinit var cursoService: CursoService

    @GetMapping
    fun list():List<Curso>{
        return cursoService.list()
    }
    @PostMapping
    fun save (@RequestBody @Valid curso:Curso):ResponseEntity<Curso>{
        return ResponseEntity(cursoService.save(curso), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody curso:Curso):ResponseEntity<Curso>{
        return  ResponseEntity(cursoService.update(curso), HttpStatus.OK)

    }

}
