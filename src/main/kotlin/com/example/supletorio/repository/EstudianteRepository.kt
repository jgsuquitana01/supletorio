package com.example.supletorio.repository

import com.example.supletorio.model.Estudiante
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EstudianteRepository: JpaRepository <Estudiante, Long> {
    fun findById(id: Long?): Estudiante?
}