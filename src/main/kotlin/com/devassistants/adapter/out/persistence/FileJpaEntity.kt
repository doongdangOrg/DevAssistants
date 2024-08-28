package com.devassistants.adapter.out.persistence

import jakarta.persistence.*

@Entity
@Table(name = "FILE")
class FileJpaEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id", nullable = false)
    val id: Long = 0,
    @Column(name = "stored_file_name", nullable = false)
    val storedFileName: String,
    @Column(name = "upload_file_name", nullable = false)
    val uploadFileName: String,
    @Column(name = "location",nullable = false)
    val location: String,
    @Column(name = "extension", nullable = false)
    val extension: String,
    @Column(name = "compressedFormat", nullable = false)
    val compressedFormat: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memo")
    val memo: MemoJpaEntity
) {



}