package com.serbond.smetacompose.domain.usecase.objusecase

import com.serbond.smetacompose.domain.model.ObjData
import com.serbond.smetacompose.domain.model.ObjWithLevel
import com.serbond.smetacompose.domain.repository.ObjRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class GetObjActive(private val repository: ObjRepository) {
       operator fun invoke(): Flow<List<ObjData>> = flow {
           val list = mutableListOf<ObjData>()
           repository.getObjAll().map {
               it.forEach {
                   list.add(ObjData(it.obj.name,10.0,5.0 , 11))
               }
           }
           emit(list)
       }

}