package org.softwareanvil.project.db

import kotlin.Double
import kotlin.Long
import kotlin.String

public data class Commission(
  public val id: Long,
  public val clientName: String,
  public val title: String,
  public val description: String?,
  public val status: String,
  public val priceGross: Double,
  public val paypalTax: Double,
  public val tip: Double?,
  public val netPrice: Double,
  public val createdAt: Long,
  public val deadline: Long?,
  public val completedAt: Long?,
  public val tags: String?,
  public val notes: String?,
)
