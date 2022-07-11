package com.serbond.smetacompose.domain.model

data class Windows(
    val id: Long ,
    val wallId: Long,
    val slabId: Long,
    var name: String = "",
    var type: String = "",
    var podokonnik: Boolean = false,
    var duplicate: Boolean = false,
    var duplicateId: Long = 0,
    var areaRemove: Boolean = true,
    var note: String = "",
    var arc: Boolean = false
)
