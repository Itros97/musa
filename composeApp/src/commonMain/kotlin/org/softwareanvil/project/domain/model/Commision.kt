package org.softwareanvil.project.domain.model

data class Commission(
    val id: Long = 0,
    val clientName: String,
    val title: String,
    val description: String? = null,
    val status: CommissionStatus = CommissionStatus.INQUIRY,
    val priceGross: Double,
    val paypalTax: Double = 0.0,
    val tip: Double? = null,
    val netPrice: Double = 0.0,
    val createdAt: Long,
    val deadline: Long? = null,
    val completedAt: Long? = null,
    val tags: List<String> = emptyList(),
    val notes: String? = null
)