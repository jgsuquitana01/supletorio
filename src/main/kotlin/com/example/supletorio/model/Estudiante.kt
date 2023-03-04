package com.example.supletorio.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name="estudiante")
class Estudiante {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank(message = "Campo obligatorio")
    var cedula: String?= null
    @NotBlank(message = "Campo Obligatorio")
    var fullname: String? = null
    @Column(name="curso_id")
    var cursoId: Long? = null
}