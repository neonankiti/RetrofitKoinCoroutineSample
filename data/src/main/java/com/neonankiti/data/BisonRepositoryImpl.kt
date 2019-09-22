package com.neonankiti.data

import com.neonankiti.domain.AnimalRepository

class BisonRepositoryImpl : AnimalRepository {
    override fun getMovement() = "move to Yellow Stone National Park."
}
