package com.example.myapplication

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.text.FieldPosition

class AdaptadorPersona(
        private val listaPersonas: List<Persona>,
        private val contexto: ReciclerViewActivity,
        private val recyclerView: RecyclerView
) :
        RecyclerView.Adapter<AdaptadorPersona.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nombreTextView: TextView
        var cedulaTextView: TextView
        var accionButton: Button

        init {
            nombreTextView = view.findViewById(R.id.txt_nombre) as TextView
            cedulaTextView = view.findViewById(R.id.txt_cedula) as TextView
            accionButton = view.findViewById(R.id.btn_accion) as Button

            val layout = view.findViewById(R.id.linear_layout) as LinearLayout
            layout.setOnClickListener {

                Log.i("recycler-view", "Layout presionado")

            }
            accionButton.setOnClickListener {
             nombreTextView.text  = "Me cambiarooon !!"
             contexto.cambiarNombreTextView("Wow!")

                val nuevasPersonas = arrayListOf<Persona>()
                nuevasPersonas.add(Persona("Juan", "1748979900"))
                nuevasPersonas.add(Persona("Karla", "0168754901"))
                nuevasPersonas.add(Persona("Carolina", "1748979902"))
                nuevasPersonas.add(Persona("Fernanda", "0548979903"))

                contexto.iniciarRecylerView(nuevasPersonas, contexto, recyclerView)
            }
        }

    }

    //Devuelve el numero de items de la lista
    override fun getItemCount(): Int {
        return listaPersonas.size

    }

    override fun onBindViewHolder(myViewHolder: AdaptadorPersona.MyViewHolder, position: Int) {
        val persona = listaPersonas[position]
        myViewHolder.nombreTextView.text = persona.nombre
        myViewHolder.cedulaTextView.text = persona.cedula
    }


    //Esta función define el template que vamos a usar.
    //El template está en la carpeta recursos de res/layout

    override fun onCreateViewHolder(
            p0: ViewGroup,
            p1: Int):
            AdaptadorPersona.MyViewHolder {
        val itemView = LayoutInflater
                .from(p0.context)
                .inflate(
                        R.layout.layout,
                        p0,
                        false
                )

        return MyViewHolder(itemView)
    }


}