package com.devassistants.port.`in`

import org.springframework.web.multipart.MultipartFile

interface SaveFileUseCase {
    fun saveFile(file: MultipartFile)
}