package com.dong.covid19app.home

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.dong.covid19app.R
import com.dong.covid19app.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.dong.covid19app.config.BaseFragment
import com.dong.covid19app.databinding.FragmentHomeBinding
import com.dong.covid19app.home.models.HomeResponse
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import java.time.LocalDate
import java.time.LocalDateTime



class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::bind,
    R.layout.fragment_home
), HomeFragmentView {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoadingDialog(this.context!!)
        HomeService(this).tryGetCovid(X_ACCESS_TOKEN)
        val onlyData: LocalDate = LocalDate.now()
        binding.homeDate.text = onlyData.toString() + " 00시 기준"
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
        for (c in ColorTemplate.VORDIPLOM_COLORS) colorItems.add(c)
        for (c in ColorTemplate.JOYFUL_COLORS) colorItems.add(c)
        for (c in ColorTemplate.LIBERTY_COLORS) colorItems.add(c)
        for (c in ColorTemplate.PASTEL_COLORS) colorItems.add(c)
        colorItems.add(ColorTemplate.getHoloBlue())

        val pieDataSet = PieDataSet(entries, "")
        pieDataSet.apply {
            colors = colorItems
            // 서클 안 색
            valueTextColor = Color.BLACK
            valueTextSize = 15f
            sliceSpace = 3f
            selectionShift = 5f
        }

        val pieData = PieData(pieDataSet)
        binding.homePiechart.apply {
            data = pieData
            description.isEnabled = false
            isRotationEnabled = false
            setEntryLabelColor(Color.BLACK)
//            val des = Description()
//            des.text = "도시별 확진자 상위 5곳"
//            description = des
//            des.textSize = 13F
            //원의 라벨 크기를 변경한다.
            setEntryLabelTextSize(13F)
            animateY(1400, Easing.EaseInOutQuad)
            animate()
        }

//        데이터 값 저장
//        binding.homeDate.text = response.updateTime
        binding.recoveredPercentage.text = response.recoveredPercentage.toString()
        binding.deathPercentage.text = response.deathPercentage.toString()
        binding.checkingCounter.text = response.checkingCounter
        binding.caseCount.text = response.caseCount
        binding.notcaseCount.text = response.notcaseCount
        binding.todayRecovered.text = response.TodayRecovered
        binding.todayDeath.text = response.TodayDeath
        binding.totalCaseBefore.text = response.TotalCaseBefore

    }

    override fun onGetCoivdFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast(message)
    }
}