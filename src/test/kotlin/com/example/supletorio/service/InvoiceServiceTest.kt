package com.example.supletorio.service

import com.example.supletorio.repository.CursoRepository
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class InvoiceServiceTest {
    @InjectMocks
    lateinit var invoiceService: CursoService
    @Mock
    lateinit var invoiceRepository: CursoRepository
}