package mustafaozhan.github.com.mycurrencies.settings

import mustafaozhan.github.com.mycurrencies.base.BaseViewModel
import mustafaozhan.github.com.mycurrencies.extensions.insertInitialCurrencies
import mustafaozhan.github.com.mycurrencies.model.MainData
import mustafaozhan.github.com.mycurrencies.room.dao.CurrencyDao
import mustafaozhan.github.com.mycurrencies.room.model.Currency
import mustafaozhan.github.com.mycurrencies.tools.Currencies
import javax.inject.Inject

/**
 * Created by Mustafa Ozhan on 2018-07-12.
 */
class SettingsFragmentViewModel : BaseViewModel() {

    override fun inject() {
        viewModelComponent.inject(this)
    }

    @Inject
    lateinit var currencyDao: CurrencyDao

    val currencyList: MutableList<Currency> = mutableListOf()
    lateinit var mainData: MainData

    fun initData() {
        loadPreferences()
        currencyList.clear()
        if (mainData.firstRun) {
            currencyDao.insertInitialCurrencies()
            mainData.firstRun = false
        }
        currencyDao.getAllCurrencies().let { list ->
            currencyList.addAll(list)
        }
    }

    fun setCurrentBase(newBase: String?) {
        mainData.currentBase = Currencies.valueOf(newBase ?: "NULL")
        dataManager.persistMainData(mainData)
    }

    fun updateCurrencyStateByName(name: String, i: Int) = currencyDao.updateCurrencyStateByName(name, i)

    fun updateAllCurrencyState(value: Int) {
        currencyList.forEach { it.isActive = value }
        currencyDao.updateAllCurrencyState(value)
    }

    private fun loadPreferences() {
        mainData = dataManager.loadMainData()
    }

    fun savePreferences() = dataManager.persistMainData(mainData)
}