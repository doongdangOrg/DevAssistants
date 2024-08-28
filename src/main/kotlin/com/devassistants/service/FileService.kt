package com.devassistants.service

import com.devassistants.port.`in`.SaveFileUseCase
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.IOException
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

@Service
class FileService: SaveFileUseCase {


    override fun saveFile(file: MultipartFile) {
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
    }
}