package com.serbond.smetacompose.domain.usecase.objusecase

import com.serbond.smetacompose.domain.repository.ObjRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AreaFloorObj(private val repository: ObjRepository) {
     operator fun invoke(id: Long): Flow<Double> {
        val area = repository.loadObj(id).map {
            1.0+1.0
        }
        return area
    }
}