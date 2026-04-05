package org.softwareanvil.project.db

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Double
import kotlin.Long
import kotlin.String

public class ComissionQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> selectAll(mapper: (
    id: Long,
    clientName: String,
    title: String,
    description: String?,
    status: String,
    priceGross: Double,
    paypalTax: Double,
    tip: Double?,
    netPrice: Double,
    createdAt: Long,
    deadline: Long?,
    completedAt: Long?,
    tags: String?,
    notes: String?,
  ) -> T): Query<T> = Query(-462_176_981, arrayOf("Commission"), driver, "comission.sq", "selectAll", "SELECT Commission.id, Commission.clientName, Commission.title, Commission.description, Commission.status, Commission.priceGross, Commission.paypalTax, Commission.tip, Commission.netPrice, Commission.createdAt, Commission.deadline, Commission.completedAt, Commission.tags, Commission.notes FROM Commission ORDER BY createdAt DESC") { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3),
      cursor.getString(4)!!,
      cursor.getDouble(5)!!,
      cursor.getDouble(6)!!,
      cursor.getDouble(7),
      cursor.getDouble(8)!!,
      cursor.getLong(9)!!,
      cursor.getLong(10),
      cursor.getLong(11),
      cursor.getString(12),
      cursor.getString(13)
    )
  }

  public fun selectAll(): Query<Commission> = selectAll(::Commission)

  public fun <T : Any> selectById(id: Long, mapper: (
    id: Long,
    clientName: String,
    title: String,
    description: String?,
    status: String,
    priceGross: Double,
    paypalTax: Double,
    tip: Double?,
    netPrice: Double,
    createdAt: Long,
    deadline: Long?,
    completedAt: Long?,
    tags: String?,
    notes: String?,
  ) -> T): Query<T> = SelectByIdQuery(id) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3),
      cursor.getString(4)!!,
      cursor.getDouble(5)!!,
      cursor.getDouble(6)!!,
      cursor.getDouble(7),
      cursor.getDouble(8)!!,
      cursor.getLong(9)!!,
      cursor.getLong(10),
      cursor.getLong(11),
      cursor.getString(12),
      cursor.getString(13)
    )
  }

  public fun selectById(id: Long): Query<Commission> = selectById(id, ::Commission)

  public fun <T : Any> selectByStatus(status: String, mapper: (
    id: Long,
    clientName: String,
    title: String,
    description: String?,
    status: String,
    priceGross: Double,
    paypalTax: Double,
    tip: Double?,
    netPrice: Double,
    createdAt: Long,
    deadline: Long?,
    completedAt: Long?,
    tags: String?,
    notes: String?,
  ) -> T): Query<T> = SelectByStatusQuery(status) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3),
      cursor.getString(4)!!,
      cursor.getDouble(5)!!,
      cursor.getDouble(6)!!,
      cursor.getDouble(7),
      cursor.getDouble(8)!!,
      cursor.getLong(9)!!,
      cursor.getLong(10),
      cursor.getLong(11),
      cursor.getString(12),
      cursor.getString(13)
    )
  }

  public fun selectByStatus(status: String): Query<Commission> = selectByStatus(status, ::Commission)

  public fun <T : Any> selectUpcomingDeadlines(mapper: (
    id: Long,
    clientName: String,
    title: String,
    description: String?,
    status: String,
    priceGross: Double,
    paypalTax: Double,
    tip: Double?,
    netPrice: Double,
    createdAt: Long,
    deadline: Long,
    completedAt: Long?,
    tags: String?,
    notes: String?,
  ) -> T): Query<T> = Query(1_644_220_777, arrayOf("Commission"), driver, "comission.sq", "selectUpcomingDeadlines", """
  |SELECT Commission.id, Commission.clientName, Commission.title, Commission.description, Commission.status, Commission.priceGross, Commission.paypalTax, Commission.tip, Commission.netPrice, Commission.createdAt, Commission.deadline, Commission.completedAt, Commission.tags, Commission.notes FROM Commission
  |WHERE status IN ('ACCEPTED', 'IN_PROGRESS', 'PAUSED', 'REVIEW')
  |AND deadline IS NOT NULL
  |ORDER BY deadline ASC
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3),
      cursor.getString(4)!!,
      cursor.getDouble(5)!!,
      cursor.getDouble(6)!!,
      cursor.getDouble(7),
      cursor.getDouble(8)!!,
      cursor.getLong(9)!!,
      cursor.getLong(10)!!,
      cursor.getLong(11),
      cursor.getString(12),
      cursor.getString(13)
    )
  }

  public fun selectUpcomingDeadlines(): Query<SelectUpcomingDeadlines> = selectUpcomingDeadlines(::SelectUpcomingDeadlines)

  public fun <T : Any> searchByText(
    `value`: String,
    value_: String,
    mapper: (
      id: Long,
      clientName: String,
      title: String,
      description: String?,
      status: String,
      priceGross: Double,
      paypalTax: Double,
      tip: Double?,
      netPrice: Double,
      createdAt: Long,
      deadline: Long?,
      completedAt: Long?,
      tags: String?,
      notes: String?,
    ) -> T,
  ): Query<T> = SearchByTextQuery(value, value_) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3),
      cursor.getString(4)!!,
      cursor.getDouble(5)!!,
      cursor.getDouble(6)!!,
      cursor.getDouble(7),
      cursor.getDouble(8)!!,
      cursor.getLong(9)!!,
      cursor.getLong(10),
      cursor.getLong(11),
      cursor.getString(12),
      cursor.getString(13)
    )
  }

  public fun searchByText(value_: String, value__: String): Query<Commission> = searchByText(value_, value__, ::Commission)

  public fun <T : Any> selectForDateRange(
    createdAt: Long,
    createdAt_: Long,
    mapper: (
      id: Long,
      clientName: String,
      title: String,
      description: String?,
      status: String,
      priceGross: Double,
      paypalTax: Double,
      tip: Double?,
      netPrice: Double,
      createdAt: Long,
      deadline: Long?,
      completedAt: Long?,
      tags: String?,
      notes: String?,
    ) -> T,
  ): Query<T> = SelectForDateRangeQuery(createdAt, createdAt_) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3),
      cursor.getString(4)!!,
      cursor.getDouble(5)!!,
      cursor.getDouble(6)!!,
      cursor.getDouble(7),
      cursor.getDouble(8)!!,
      cursor.getLong(9)!!,
      cursor.getLong(10),
      cursor.getLong(11),
      cursor.getString(12),
      cursor.getString(13)
    )
  }

  public fun selectForDateRange(createdAt: Long, createdAt_: Long): Query<Commission> = selectForDateRange(createdAt, createdAt_, ::Commission)

  public fun <T : Any> countByStatus(mapper: (status: String, total: Long) -> T): Query<T> = Query(183_337_086, arrayOf("Commission"), driver, "comission.sq", "countByStatus", "SELECT status, COUNT(*) AS total FROM Commission GROUP BY status") { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getLong(1)!!
    )
  }

  public fun countByStatus(): Query<CountByStatus> = countByStatus(::CountByStatus)

  public fun <T : Any> totalForDateRange(
    completedAt: Long?,
    completedAt_: Long?,
    mapper: (
      totalNet: Double,
      totalGross: Double,
      totalFees: Double,
    ) -> T,
  ): Query<T> = TotalForDateRangeQuery(completedAt, completedAt_) { cursor ->
    mapper(
      cursor.getDouble(0)!!,
      cursor.getDouble(1)!!,
      cursor.getDouble(2)!!
    )
  }

  public fun totalForDateRange(completedAt: Long?, completedAt_: Long?): Query<TotalForDateRange> = totalForDateRange(completedAt, completedAt_, ::TotalForDateRange)

  /**
   * @return The number of rows updated.
   */
  public fun insert(
    clientName: String,
    title: String,
    description: String?,
    status: String,
    priceGross: Double,
    paypalTax: Double,
    tip: Double?,
    `value`: Double,
    value_: Double?,
    value__: Double,
    createdAt: Long,
    deadline: Long?,
    completedAt: Long?,
    tags: String?,
    notes: String?,
  ): QueryResult<Long> {
    val result = driver.execute(548_307_539, """
        |INSERT INTO Commission (clientName, title, description, status, priceGross, paypalTax, tip, netPrice, createdAt, deadline, completedAt, tags, notes)
        |VALUES (?, ?, ?, ?, ?, ?, ?, (? + COALESCE(?, 0.0)) * (1.0 - ?), ?, ?, ?, ?, ?)
        """.trimMargin(), 15) {
          var parameterIndex = 0
          bindString(parameterIndex++, clientName)
          bindString(parameterIndex++, title)
          bindString(parameterIndex++, description)
          bindString(parameterIndex++, status)
          bindDouble(parameterIndex++, priceGross)
          bindDouble(parameterIndex++, paypalTax)
          bindDouble(parameterIndex++, tip)
          bindDouble(parameterIndex++, value)
          bindDouble(parameterIndex++, value_)
          bindDouble(parameterIndex++, value__)
          bindLong(parameterIndex++, createdAt)
          bindLong(parameterIndex++, deadline)
          bindLong(parameterIndex++, completedAt)
          bindString(parameterIndex++, tags)
          bindString(parameterIndex++, notes)
        }
    notifyQueries(548_307_539) { emit ->
      emit("Commission")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun update(
    clientName: String,
    title: String,
    description: String?,
    status: String,
    priceGross: Double,
    paypalTax: Double,
    tip: Double?,
    `value`: Double,
    value_: Double?,
    value__: Double,
    deadline: Long?,
    completedAt: Long?,
    tags: String?,
    notes: String?,
    id: Long,
  ): QueryResult<Long> {
    val result = driver.execute(893_253_731, """
        |UPDATE Commission
        |SET clientName = ?, title = ?, description = ?, status = ?, priceGross = ?, paypalTax = ?, tip = ?,
        |    netPrice = (? + COALESCE(?, 0.0)) * (1.0 - ?),
        |    deadline = ?, completedAt = ?, tags = ?, notes = ?
        |WHERE id = ?
        """.trimMargin(), 15) {
          var parameterIndex = 0
          bindString(parameterIndex++, clientName)
          bindString(parameterIndex++, title)
          bindString(parameterIndex++, description)
          bindString(parameterIndex++, status)
          bindDouble(parameterIndex++, priceGross)
          bindDouble(parameterIndex++, paypalTax)
          bindDouble(parameterIndex++, tip)
          bindDouble(parameterIndex++, value)
          bindDouble(parameterIndex++, value_)
          bindDouble(parameterIndex++, value__)
          bindLong(parameterIndex++, deadline)
          bindLong(parameterIndex++, completedAt)
          bindString(parameterIndex++, tags)
          bindString(parameterIndex++, notes)
          bindLong(parameterIndex++, id)
        }
    notifyQueries(893_253_731) { emit ->
      emit("Commission")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun updateStatus(status: String, id: Long): QueryResult<Long> {
    val result = driver.execute(-1_507_877_323, """UPDATE Commission SET status = ? WHERE id = ?""", 2) {
          var parameterIndex = 0
          bindString(parameterIndex++, status)
          bindLong(parameterIndex++, id)
        }
    notifyQueries(-1_507_877_323) { emit ->
      emit("Commission")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun markCompleted(completedAt: Long?, id: Long): QueryResult<Long> {
    val result = driver.execute(-326_580_956, """UPDATE Commission SET status = 'COMPLETED', completedAt = ? WHERE id = ?""", 2) {
          var parameterIndex = 0
          bindLong(parameterIndex++, completedAt)
          bindLong(parameterIndex++, id)
        }
    notifyQueries(-326_580_956) { emit ->
      emit("Commission")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun delete(id: Long): QueryResult<Long> {
    val result = driver.execute(396_641_605, """DELETE FROM Commission WHERE id = ?""", 1) {
          var parameterIndex = 0
          bindLong(parameterIndex++, id)
        }
    notifyQueries(396_641_605) { emit ->
      emit("Commission")
    }
    return result
  }

  /**
   * @return The number of rows updated.
   */
  public fun deleteAll(): QueryResult<Long> {
    val result = driver.execute(895_089_180, """DELETE FROM Commission""", 0)
    notifyQueries(895_089_180) { emit ->
      emit("Commission")
    }
    return result
  }

  private inner class SelectByIdQuery<out T : Any>(
    public val id: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("Commission", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("Commission", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_442_543_224, """SELECT Commission.id, Commission.clientName, Commission.title, Commission.description, Commission.status, Commission.priceGross, Commission.paypalTax, Commission.tip, Commission.netPrice, Commission.createdAt, Commission.deadline, Commission.completedAt, Commission.tags, Commission.notes FROM Commission WHERE id = ?""", mapper, 1) {
      var parameterIndex = 0
      bindLong(parameterIndex++, id)
    }

    override fun toString(): String = "comission.sq:selectById"
  }

  private inner class SelectByStatusQuery<out T : Any>(
    public val status: String,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("Commission", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("Commission", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_405_858_337, """SELECT Commission.id, Commission.clientName, Commission.title, Commission.description, Commission.status, Commission.priceGross, Commission.paypalTax, Commission.tip, Commission.netPrice, Commission.createdAt, Commission.deadline, Commission.completedAt, Commission.tags, Commission.notes FROM Commission WHERE status = ? ORDER BY createdAt DESC""", mapper, 1) {
      var parameterIndex = 0
      bindString(parameterIndex++, status)
    }

    override fun toString(): String = "comission.sq:selectByStatus"
  }

  private inner class SearchByTextQuery<out T : Any>(
    public val `value`: String,
    public val value_: String,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("Commission", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("Commission", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-929_801_722, """
    |SELECT Commission.id, Commission.clientName, Commission.title, Commission.description, Commission.status, Commission.priceGross, Commission.paypalTax, Commission.tip, Commission.netPrice, Commission.createdAt, Commission.deadline, Commission.completedAt, Commission.tags, Commission.notes FROM Commission
    |WHERE clientName LIKE '%' || ? || '%'
    |OR title LIKE '%' || ? || '%'
    |ORDER BY createdAt DESC
    """.trimMargin(), mapper, 2) {
      var parameterIndex = 0
      bindString(parameterIndex++, value)
      bindString(parameterIndex++, value_)
    }

    override fun toString(): String = "comission.sq:searchByText"
  }

  private inner class SelectForDateRangeQuery<out T : Any>(
    public val createdAt: Long,
    public val createdAt_: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("Commission", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("Commission", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-1_266_486_500, """
    |SELECT Commission.id, Commission.clientName, Commission.title, Commission.description, Commission.status, Commission.priceGross, Commission.paypalTax, Commission.tip, Commission.netPrice, Commission.createdAt, Commission.deadline, Commission.completedAt, Commission.tags, Commission.notes FROM Commission
    |WHERE createdAt >= ? AND createdAt <= ?
    |ORDER BY createdAt DESC
    """.trimMargin(), mapper, 2) {
      var parameterIndex = 0
      bindLong(parameterIndex++, createdAt)
      bindLong(parameterIndex++, createdAt_)
    }

    override fun toString(): String = "comission.sq:selectForDateRange"
  }

  private inner class TotalForDateRangeQuery<out T : Any>(
    public val completedAt: Long?,
    public val completedAt_: Long?,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("Commission", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("Commission", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> = driver.executeQuery(-316_366_608, """
    |SELECT COALESCE(SUM(netPrice), 0.0) AS totalNet,
    |       COALESCE(SUM(priceGross + COALESCE(tip, 0.0)), 0.0) AS totalGross,
    |       COALESCE(SUM((priceGross + COALESCE(tip, 0.0)) * paypalTax), 0.0) AS totalFees
    |FROM Commission
    |WHERE status = 'COMPLETED'
    |AND completedAt >= ? AND completedAt <= ?
    """.trimMargin(), mapper, 2) {
      var parameterIndex = 0
      bindLong(parameterIndex++, completedAt)
      bindLong(parameterIndex++, completedAt_)
    }

    override fun toString(): String = "comission.sq:totalForDateRange"
  }
}
