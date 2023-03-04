package com.example.supletorio.service

import com.example.supletorio.model.Curso
import com.example.supletorio.repository.CursoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CursoService {
    @Autowired
    lateinit var cursoRepository:CursoRepository

    fun list():List<Curso>{
        return cursoRepository.findAll()
    }
    //fun findCursoById(id: Long?):List<Curso>{
    //  returncursoRepository.findCurso(id)
    //}
    

    fun save(curso:Curso):Curso{
        try {
           curso.aula?.takeIf { it.trim().isNotEmpty() }
                ?:throw Exception("Fullname blanco")
            return cursoRepository.save(curso)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun update(curso:Curso):Curso{
        try {
           cursoRepository.findById(curso.id)
                ?:throw Exception("El id ${curso.id} encurso no existente")
            return cursoRepository.save(curso)
        }
        catch (ex:java.lang.Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(curso:Curso):Curso{
        try{
            val response =cursoRepository.findById(curso.id)
                ?:throw Exception("El ${curso.id} en cliente no existe")
            return cursoRepository.save(curso)
            response.apply{
                descripcion =curso.descripcion
            }
            return cursoRepository.save(response)
        }
        catch (ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)

        }
    }
}