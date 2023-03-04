package com.example.supletorio.repository

import com.example.supletorio.model.Curso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CursoRepository: JpaRepository <Curso, Long>{
    fun findById(id: Long?):Curso?
}