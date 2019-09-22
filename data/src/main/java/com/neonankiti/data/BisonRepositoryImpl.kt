package com.neonankiti.data

import com.neonankiti.domain.AnimalRepository
import com.neonankiti.domain.Move

class BisonRepositoryImpl : AnimalRepository {
    override fun getMovement() = Move("move to Yellow Stone National Park.")
}
