package com.devassistants.adapter.`in`.web

import com.devassistants.port.`in`.SaveFileUseCase
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.IOException
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*


// FIXME: 로그인한 회원만이 파일을 올릴 수 있음. -> 로그인 여부 확인 로직 필요
@RestController
@RequestMapping("/file")
class FileController(
    private val saveFileUseCase: SaveFileUseCase
) {

    @PostMapping("/upload/v1", consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE])
    fun uploadFile(@RequestPart("file") file: MultipartFile): String {

        saveFileUseCase.saveFile(file)


        return "saved"
    }
}