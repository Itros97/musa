package org.softwareanvil.project.db

import kotlin.Long
import kotlin.String

public data class CountByStatus(
  public val status: String,
  public val total: Long,
)
