package com.mylearning.devplacement.retrofit

import com.mylearning.devplacement.model.User
import com.mylearning.devplacement.utils.EntityMapper
import javax.inject.Inject

/**
 * This class is responsible for mapping the network object to the domain object
 */

class NetworkMapper @Inject constructor() : EntityMapper<UserNetworkEntity, User> {

    override fun mapFromEntity(entity: UserNetworkEntity): User {
        return User(
            id = entity.id,
            name = entity.name,
            image = entity.image,
            gender = entity.gender,
            colors = entity.colors,
            countries = entity.countries,
            date = entity.date

        )
    }

    override fun mapToEntity(domainModel: User): UserNetworkEntity {

        return UserNetworkEntity(
            id = domainModel.id,
            name = domainModel.name,
            image = domainModel.image,
            gender = domainModel.gender,
            countries = domainModel.countries,
            colors = domainModel.colors,
            date = domainModel.date
        )

    }

    // function responsible for converting list of entities object to User object
    fun mapFromEntityList (entities : List<UserNetworkEntity>) : List<User> {
        return entities.map { mapFromEntity(it) }
    }

}