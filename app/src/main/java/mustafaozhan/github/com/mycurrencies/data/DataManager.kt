package mustafaozhan.github.com.mycurrencies.data

import io.reactivex.Observable
import mustafaozhan.github.com.mycurrencies.data.api.ApiHelper
import mustafaozhan.github.com.mycurrencies.data.preferences.GeneralSharedPreferences
import mustafaozhan.github.com.mycurrencies.model.Currencies
import mustafaozhan.github.com.mycurrencies.model.CurrencyResponse
import mustafaozhan.github.com.mycurrencies.model.MainData
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Mustafa Ozhan on 7/10/18 at 9:50 PM on Arch Linux wit Love <3.
 */
@Singleton
class DataManager @Inject
constructor(private val generalSharedPreferences: GeneralSharedPreferences) {

    @Inject
    lateinit var apiHelper: ApiHelper

    fun backendGetAllOnBase(base: Currencies): Observable<CurrencyResponse> =
        apiHelper.apiService.getAllOnBase(base)

    fun loadMainData() = generalSharedPreferences.loadMainData()

    fun persistMainData(mainData: MainData) =
        generalSharedPreferences.persistMainData(mainData)

    fun loadResetData() = generalSharedPreferences.loadResetData()

    fun persistResetData(resetData: Boolean) = generalSharedPreferences.persistResetData(resetData)
}