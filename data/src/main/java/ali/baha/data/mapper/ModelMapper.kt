package ali.baha.data.mapper

import ali.baha.data.model.OrigamiDataModel
import ali.baha.domain.model.OrigamiEntity
import javax.inject.Inject

class ModelMapper @Inject constructor() : ToEntityMapper {
    override fun mapFromEntity(model: OrigamiDataModel): OrigamiEntity {
        val origamiEntity = OrigamiEntity()
        origamiEntity.id = model.id
        origamiEntity.image = model.image
        origamiEntity.name = model.name
        origamiEntity.description = model.description
        return origamiEntity
    }

    fun mapFromEntities(entities: List<OrigamiDataModel>): List<OrigamiEntity> {
        return entities.map { mapFromEntity(it) }
    }
}