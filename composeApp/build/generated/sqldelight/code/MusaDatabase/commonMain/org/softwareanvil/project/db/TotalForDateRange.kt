package org.softwareanvil.project.db

import kotlin.Double

public data class TotalForDateRange(
  public val totalNet: Double,
  public val totalGross: Double,
  public val totalFees: Double,
)
