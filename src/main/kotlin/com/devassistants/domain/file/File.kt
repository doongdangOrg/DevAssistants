package com.devassistants.domain.file


class File(
    val memoId: Long? = null,

    // TODO: random uuid및 특수 값 지정
    val storedFileName: String = "random_uuid",

    val uploadedFileName: String,

    val location: String,

    val extension: String,

    val compressedFormat: String,

    val id: Long? = null,
) {
}