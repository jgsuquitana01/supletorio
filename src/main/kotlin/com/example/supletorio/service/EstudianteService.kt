package com.example.supletorio.service

import com.example.supletorio.model.Estudiante
import com.example.supletorio.model.EstudianteView
import com.example.supletorio.repository.EstudianteRepository
import com.example.supletorio.repository.EstudianteViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class EstudianteService {

    @Autowired
    lateinit var estudianteRepository: EstudianteRepository
    @Autowired
    lateinit var estudianteViewRepository: EstudianteViewRepository

    fun list():List<Estudiante>{
        return estudianteRepository.findAll()
    }

    fun listWithEstudiante(): List<*> {
        return estudianteViewRepository.findAll()
    }

    fun save(estudiante:Estudiante):Estudiante {
        try {
            estudiante.fullname?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("fullname no debe ser vacio")
            return estudianteRepository.save(estudiante)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun update(estudiante:Estudiante):Estudiante {
        try {
            estudianteRepository.findById(estudiante.id)
                ?: throw Exception("Id no existe")

            return estudianteRepository.save(estudiante)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(estudiante:Estudiante): Estudiante {
        try{
            val response = estudianteRepository.findById(estudiante.id)
                ?: throw Exception("ID no existe")
            response.apply {
                fullname=estudiante.fullname
            }
            return estudianteRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}
