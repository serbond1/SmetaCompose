package com.serbond.smetacompose.domain.repository

import com.serbond.smetacompose.domain.model.Obj
import com.serbond.smetacompose.domain.model.ObjWithLevel
import kotlinx.coroutines.flow.Flow

interface ObjRepository {
    fun getObjAll(): Flow<List<ObjWithLevel>>
    suspend fun insert(obj: Obj)
    suspend fun delete(obj: Obj)
    suspend fun update(obj: Obj)
    fun loadObj(id: Long): Flow<ObjWithLevel>

}