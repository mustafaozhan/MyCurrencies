package mustafaozhan.github.com.mycurrencies.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_settings.*
import mustafaozhan.github.com.mycurrencies.R
import mustafaozhan.github.com.mycurrencies.model.data.Setting
import mustafaozhan.github.com.mycurrencies.ui.adapters.SettingsAdapter
import ninja.sakib.pultusorm.core.*
import org.jetbrains.anko.doAsync
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import mustafaozhan.github.com.mycurrencies.utils.putString
import mustafaozhan.github.com.mycurrencies.utils.setBackgroundByName

class SettingsActivity : AppCompatActivity(), SettingsAdapter.AdapterCallback {

    private val settingsList = ArrayList<Setting>()
    private val spinnerList = ArrayList<String>()
    private val mAdapter = SettingsAdapter(settingsList, this)
    private var myDatabase: PultusORM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        myDatabase = PultusORM("myDatabase.db", applicationContext.filesDir.absolutePath)
        setListeners()
    }

    override fun onResume() {
        getSpinnerList()
        getSettingList()
        super.onResume()
    }

    private fun getSpinnerList() {
        val base = mustafaozhan.github.com.mycurrencies.utils.getString(applicationContext, "base_currency", "EUR")
        spinnerList.clear()
        myDatabase!!.find(Setting())
                .map { it -> it as Setting }
                .filter { it.isActive == "true" }
                .mapTo(spinnerList) { it.name.toString() }
        if (spinnerList.contains(base)) {
            spinnerList.remove(base)
            spinnerList.add(0, base)
        }
        if (!spinnerList.isEmpty()) {
            mSpinnerSettings.setItems(spinnerList.toList())
            imgBaseSettings.setBackgroundByName(mSpinnerSettings.text.toString())
        }
    }

    private fun setListeners() {
        mSpinnerSettings.setOnItemSelectedListener { _, _, _, _ ->
            putString(applicationContext, "base_currency", mSpinnerSettings.text.toString())
            imgBaseSettings.setBackgroundByName(mSpinnerSettings.text.toString())

        }
        mConstraintLayoutSettings.setOnClickListener {
            if (mSpinnerSettings.isActivated)
                mSpinnerSettings.collapse()
            else
                mSpinnerSettings.expand()
        }
        selectAll.setOnClickListener {
            doAsync {
                val updater: PultusORMUpdater = PultusORMUpdater.Builder()
                        .set("isActive", "true")
                        .build()
                myDatabase!!.update(Setting(), updater)
                runOnUiThread {
                    getSettingList()
                    getSpinnerList()
                }
            }
        }
        deSelectAll.setOnClickListener {
            doAsync {
                val updater: PultusORMUpdater = PultusORMUpdater.Builder()
                        .set("isActive", "false")
                        .build()
                myDatabase?.update(Setting(), updater)
                runOnUiThread {
                    spinnerList.clear()
                    mSpinnerSettings.setItems("")
                    imgBaseSettings.setBackgroundByName("transparent")
                    getSettingList()
                    getSpinnerList()
                }
            }
        }
    }


    private fun getSettingList() {
        settingsList.clear()
        val items = myDatabase!!.find(Setting())
        items.mapTo(settingsList) { it -> it as Setting }
        val mLayoutManager = LinearLayoutManager(applicationContext)
        mRecViewSettings.layoutManager = mLayoutManager
        mRecViewSettings.itemAnimator = DefaultItemAnimator()
        mRecViewSettings.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }

    private fun loadAd() {
        val interstitial = InterstitialAd(applicationContext)
        interstitial.adUnitId = resources.getString(R.string.interstitial)
        interstitial.loadAd(AdRequest.Builder().build())
        interstitial.adListener = object : AdListener() {
            override fun onAdLoaded() {
                if (interstitial.isLoaded)
                    interstitial.show()
            }
        }
    }

    override fun onBackPressed() {
        loadAd()
        finish()
    }

    override fun onMethodCallback() {
        if (spinnerList.size == 1) {
            mSpinnerSettings.setItems("")
            imgBaseSettings.setBackgroundByName("transparent")
        }
        getSpinnerList()
    }
}
