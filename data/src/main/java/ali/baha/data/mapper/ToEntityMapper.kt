package ali.baha.data.mapper

import ali.baha.data.model.OrigamiDataModel
import ali.baha.domain.model.OrigamiEntity

interface ToEntityMapper {
    fun mapFromEntity(model: OrigamiDataModel): OrigamiEntity
}