package mustafaozhan.github.com.mycurrencies.main.fragment.settings

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakewharton.rxbinding2.widget.textChanges
import io.reactivex.rxkotlin.addTo
import mustafaozhan.github.com.mycurrencies.R
import mustafaozhan.github.com.mycurrencies.base.fragment.BaseViewBindingFragment
import mustafaozhan.github.com.mycurrencies.databinding.FragmentSettingsBinding
import mustafaozhan.github.com.mycurrencies.extensions.checkAd
import mustafaozhan.github.com.mycurrencies.model.Currency

/**
 * Created by Mustafa Ozhan on 2018-07-12.
 */
class SettingsFragment : BaseViewBindingFragment<SettingsFragmentViewModel, FragmentSettingsBinding>() {
    override fun bind() {
        binding = FragmentSettingsBinding.inflate(layoutInflater)
    }

    companion object {
        fun newInstance(): SettingsFragment = SettingsFragment()
    }

    override fun getLayoutResId(): Int = R.layout.fragment_settings

    private val settingsAdapter: SettingsAdapter by lazy { SettingsAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initViews()
        initRx()
        setListeners()
    }

    private fun initToolbar() {
        getBaseActivity()?.setSupportActionBar(binding.appBarLayout.toolbarFragmentSettings)
    }

    private fun initRx() {
        binding.editTextSearch
            .textChanges()
            .subscribe { txt ->
                viewModel.currencyList.filter { currency ->
                    currency.name.contains(txt.toString(), true) ||
                        currency.longName.contains(txt.toString(), true) ||
                        currency.symbol.contains(txt.toString(), true)
                }.toMutableList()
                    .let { settingsAdapter.refreshList(it) }
            }.addTo(compositeDisposable)
    }

    private fun initViews() {
        context?.let { ctx ->
            binding.recyclerViewSettings.apply {
                layoutManager = LinearLayoutManager(ctx)
                setHasFixedSize(true)
                adapter = settingsAdapter
            }
        }
    }

    private fun setListeners() {
        binding.appBarLayout.btnSelectAll.setOnClickListener {
            viewModel.updateCurrencyState(1)
            binding.editTextSearch?.setText("")
        }
        binding.appBarLayout.btnDeSelectAll.setOnClickListener {
            viewModel.updateCurrencyState(0)
            binding.editTextSearch?.setText("")
            viewModel.setCurrentBase(null)
        }

        settingsAdapter.onItemClickListener = { currency: Currency, itemView, _ ->
            when (currency.isActive) {
                0 -> {
                    currency.isActive = 1
                    viewModel.updateCurrencyState(1, currency.name)
                    settingsAdapter.notifyDataSetChanged()
                }
                1 -> {
                    currency.isActive = 0
                    viewModel.updateCurrencyState(0, currency.name)
                    settingsAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onPause() {
        viewModel.savePreferences()
        super.onPause()
    }

    override fun onResume() {
        viewModel.refreshData()
        binding.editTextSearch?.setText("")
        binding.adView.checkAd(R.string.banner_ad_unit_id_settings, viewModel.isRewardExpired())
        super.onResume()
    }
}
