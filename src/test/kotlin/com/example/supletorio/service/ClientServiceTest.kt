package com.example.supletorio.service

import com.example.supletorio.repository.EstudianteRepository
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ClientServiceTest {
    @InjectMocks
    lateinit var clientService: EstudianteService

    @Mock
    lateinit var  clientRepository: EstudianteRepository


}