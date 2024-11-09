package com.rida.labo4recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rida.labo4recyclerview.adapter.ItemAdapter
import com.rida.labo4recyclerview.databinding.ActivityMainBinding
import com.rida.labo4recyclerview.data.DataSource

class MainActivity : AppCompatActivity() {
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val myDataset = DataSource().loadAffirmations()
        val recyclerView = findViewById<RecyclerView>(R.id.rvAffirmations)
        recyclerView.adapter = ItemAdapter(this, myDataset)



        setSupportActionBar(binding.toolbar)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.linearItem -> {
                layoutManager = LinearLayoutManager(this@MainActivity)
                binding.rvAffirmations.layoutManager = layoutManager
                true
            }
            R.id.gridItem -> {
                layoutManager = GridLayoutManager(this@MainActivity, 2)
                binding.rvAffirmations.layoutManager = layoutManager
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}