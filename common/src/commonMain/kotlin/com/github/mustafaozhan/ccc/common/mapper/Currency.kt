/*
 * Copyright (c) 2021 Mustafa Ozhan. All rights reserved.
 */

package com.github.mustafaozhan.ccc.common.mapper

import com.github.mustafaozhan.ccc.common.model.Currency
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.github.mustafaozhan.ccc.common.db.sql.Currency as CurrencyEntity

internal fun CurrencyEntity.toModel() = Currency(
    name = name,
    longName = longName,
    symbol = symbol,
    rate = rate,
    isActive = isActive == 1.toLong()
)

internal fun List<CurrencyEntity>.toModelList(): List<Currency> {
    val temp = mutableListOf<Currency>()
    forEach {
        temp.add(
            Currency(
                name = it.name,
                longName = it.longName,
                symbol = it.symbol,
                rate = it.rate,
                isActive = it.isActive == 1.toLong()
            )
        )
    }
    return temp.toList()
}

internal fun Flow<List<CurrencyEntity>>.mapToModel(): Flow<List<Currency>> {
    return this.map {
        mutableListOf<Currency>().apply {
            it.forEach {
                add(
                    Currency(
                        name = it.name,
                        longName = it.longName,
                        symbol = it.symbol,
                        rate = it.rate,
                        isActive = it.isActive == 1.toLong()
                    )
                )
            }
        }.toList()
    }
}
