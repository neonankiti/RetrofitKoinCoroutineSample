package com.neonankiti.domain

// not create interface for Usecase this time.
class BisonUseCase(private val repo: AnimalRepository) {
    fun move() = repo.getMovement()
}
