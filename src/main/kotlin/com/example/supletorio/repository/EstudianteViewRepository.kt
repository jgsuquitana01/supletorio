package com.example.supletorio.repository

import com.example.supletorio.model.Estudiante
import com.example.supletorio.model.EstudianteView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EstudianteViewRepository: JpaRepository <EstudianteView, Long> {
    fun findById(id: Long?): EstudianteView?
}