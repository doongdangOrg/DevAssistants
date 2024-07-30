package com.devassistants.adapter.`in`.web

import com.devassistants.service.FileService
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


@RestController
@RequestMapping("/file")
class FileController(
    private val fileService: FileService
) {

    @PostMapping("/upload/v1", consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE])
    fun uploadFile(@RequestPart("file") file: MultipartFile): String {

        println(file.originalFilename)
        println(file.contentType)
        println(file.resource)
        println(file.name)
        println(file.size)

        val originalName = file.originalFilename
        val fileName = originalName!!.substring(originalName.lastIndexOf("\\") + 1)

        val uuid: String = UUID.randomUUID().toString()

        val saveFileName: String = ("D:/" + File.separator) + uuid + "_" + fileName

        val savePath: Path = Paths.get(saveFileName)

        try {
            file.transferTo(savePath)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return ""
    }
}