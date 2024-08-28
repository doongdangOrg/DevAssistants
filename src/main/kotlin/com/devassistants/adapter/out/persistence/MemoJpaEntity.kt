package com.devassistants.adapter.out.persistence

import jakarta.persistence.*


@Entity
@Table(name = "memo")
class MemoJpaEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memo_id", nullable = false)
    val id: Long = 0,
) {

}
