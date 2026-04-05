package org.softwareanvil.project.domain.model

enum class CommissionStatus {
    INQUIRY,
    ACCEPTED,
    IN_PROGRESS,
    PAUSED,
    REVIEW,
    COMPLETED,
    CANCELLED,
    REJECTED;

    fun allowedTransitions(): Set<CommissionStatus> = when (this) {
        INQUIRY -> setOf(ACCEPTED, REJECTED)
        ACCEPTED -> setOf(IN_PROGRESS, CANCELLED)
        IN_PROGRESS -> setOf(REVIEW, PAUSED, CANCELLED)
        PAUSED -> setOf(IN_PROGRESS, CANCELLED)
        REVIEW -> setOf(IN_PROGRESS, COMPLETED)
        COMPLETED -> emptySet()
        CANCELLED -> emptySet()
        REJECTED -> emptySet()
    }

    fun canTransitionTo(target: CommissionStatus): Boolean {
        return target in allowedTransitions()
    }

    fun isActive(): Boolean = this in setOf(ACCEPTED, IN_PROGRESS, PAUSED, REVIEW)

    fun isFinal(): Boolean = this in setOf(COMPLETED, CANCELLED, REJECTED)
}