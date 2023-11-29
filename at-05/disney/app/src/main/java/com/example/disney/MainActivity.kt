package com.example.disney

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var characterList: MutableList<CharacterResponse.Character>
    private lateinit var characterAdapter: DisneyCharacterAdapter
    private var currentPage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        characterList = mutableListOf()
        characterAdapter = DisneyCharacterAdapter(characterList)
        recyclerView.adapter = characterAdapter

        // Adiciona um listener de scroll para detectar quando alcançar o fim da lista
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                // Verifica se o usuário alcançou o fim da lista
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItem = layoutManager.findFirstVisibleItemPosition()

                if ((visibleItemCount + firstVisibleItem) >= totalItemCount) {
                    // Se alcançou o fim da lista, carrega mais dados (próxima página)
                    fetchCharacters()
                }
            }
        })

        fetchCharacters()
    }

    private fun fetchCharacters() {
        progressBar.visibility = View.VISIBLE
        RetrofitClient.getRetrofitClient().getCharacters(10, currentPage)
            .enqueue(object : Callback<CharacterResponse> {
                override fun onResponse(
                    call: Call<CharacterResponse>,
                    response: Response<CharacterResponse>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        characterList.addAll(response.body()!!.data)
                        characterAdapter.notifyDataSetChanged()
                        progressBar.visibility = View.GONE
                        currentPage++
                    }
                }

                override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                    progressBar.visibility = View.GONE
                    Toast.makeText(
                        this@MainActivity,
                        "Error: ${t.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }
}