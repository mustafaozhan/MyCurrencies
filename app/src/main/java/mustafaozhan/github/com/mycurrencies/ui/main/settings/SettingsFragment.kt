package mustafaozhan.github.com.mycurrencies.ui.main.settings

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mustafaozhan.basemob.extension.reObserve
import com.github.mustafaozhan.basemob.fragment.BaseDBFragment
import mustafaozhan.github.com.mycurrencies.R
import mustafaozhan.github.com.mycurrencies.databinding.FragmentSettingsBinding
import mustafaozhan.github.com.mycurrencies.ui.main.settings.model.FewCurrencyEvent
import mustafaozhan.github.com.mycurrencies.util.Toasty.showToasty
import javax.inject.Inject

/**
 * Created by Mustafa Ozhan on 2018-07-12.
 */
class SettingsFragment : BaseDBFragment<FragmentSettingsBinding>() {

    @Inject
    lateinit var settingsViewModel: SettingsViewModel

    private lateinit var settingsAdapter: SettingsAdapter

    override fun bind(container: ViewGroup?): FragmentSettingsBinding =
        FragmentSettingsBinding.inflate(layoutInflater, container, false)

    override fun onBinding(dataBinding: FragmentSettingsBinding) {
        binding.vm = settingsViewModel
        settingsViewModel.action.let {
            binding.action = it
            settingsAdapter = SettingsAdapter(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getBaseActivity()?.setSupportActionBar(binding.toolbarFragmentSettings)
        initView()
        initEvent()
    }

    private fun initView() {
        binding.recyclerViewSettings.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = settingsAdapter
        }

        settingsViewModel.state.currencyList.apply {
            reObserve(viewLifecycleOwner, Observer {
                settingsAdapter.submitList(it)
            })
        }
    }

    private fun initEvent() = settingsViewModel.event
        .reObserve(viewLifecycleOwner, Observer { viewEvent ->
            when (viewEvent) {
                FewCurrencyEvent -> showToasty(requireContext(), R.string.choose_at_least_two_currency)
            }
        })
}
