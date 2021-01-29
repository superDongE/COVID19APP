package com.example.covid19app.home

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.example.covid19app.R
import com.example.covid19app.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.covid19app.config.BaseFragment
import com.example.covid19app.databinding.FragmentHomeBinding
import com.example.covid19app.home.models.HomeResponse
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate


class HomeFragment: BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::bind,
    R.layout.fragment_home
), HomeFragmentView{
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoadingDialog(this.context!!)
        HomeService(this).tryGetCovid(X_ACCESS_TOKEN)

    }

    override fun onResume() {
        super.onResume()

    }

    override fun onGetCovidSuccess(response: HomeResponse) {
        dismissLoadingDialog()
        //성공시
        // 파이 이미지를 그린다
        binding.homePiechart.setUsePercentValues(true)
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(response.city1p.toFloat(), response.city1n))
        entries.add(PieEntry(response.city2p.toFloat(), response.city2n))
        entries.add(PieEntry(response.city3p.toFloat(), response.city3n))
        entries.add(PieEntry(response.city4p.toFloat(), response.city4n))
        entries.add(PieEntry(response.city5p.toFloat(), response.city5n))


        val colorItems = ArrayList<Int>()
        for(c in ColorTemplate.VORDIPLOM_COLORS) colorItems.add(c)
        for(c in ColorTemplate.JOYFUL_COLORS) colorItems.add(c)
        for(c in ColorTemplate.LIBERTY_COLORS) colorItems.add(c)
        for(c in ColorTemplate.PASTEL_COLORS) colorItems.add(c)
        colorItems.add(ColorTemplate.getHoloBlue())

        val pieDataSet = PieDataSet(entries, "")
        pieDataSet.apply {
            colors = colorItems
            valueTextColor = Color.BLACK
            valueTextSize = 16f
            sliceSpace = 3f
            selectionShift = 5f
        }

        val pieData = PieData(pieDataSet)
        binding.homePiechart.apply {
            data = pieData
            description.isEnabled = false
            isRotationEnabled = false
            centerText = "테스트입니다."
            setEntryLabelColor(Color.BLACK)
            animateY(1400, Easing.EaseInOutQuad)
            animate()
        }

    }

    override fun onGetCoivdFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast(message)
    }
}