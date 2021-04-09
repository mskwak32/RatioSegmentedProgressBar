package com.mskwak.ratiosegmentedprogressbar

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.mskwak.ratiosegmentedprogressbar.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var progressJob: Job


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        initProgressBar()
    }

    override fun onPause() {
        super.onPause()
        progressJob.cancel()
    }

    private fun initProgressBar() {
        val valueList = listOf(10L, 20L, 50L, 90L, 30L)
        val maxValue = valueList.sum()
        binding.progressBar.progressDrawable = RatioSegmentedProgressBarDrawable(Color.BLUE, Color.GRAY, valueList, 20f)
        binding.progressBar.max = maxValue.toInt()
        progressJob = CoroutineScope(Dispatchers.Main).launch {
            var progress = 0
            while (progressJob.isActive) {
                delay(200)
                progress += 1
                if (progress > maxValue) progress = 0
                binding.progressBar.progress = progress
                binding.progressText.text = progress.toString()
            }
        }
    }
}