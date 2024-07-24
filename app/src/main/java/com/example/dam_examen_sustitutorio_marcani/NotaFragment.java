package com.example.dam_examen_sustitutorio_marcani;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NotaFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private NotasInteractionListener mListener;
    private List<Nota> notaList;
    private MyNotaRecyclerViewAdapter adapterNotas;



    public NotaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotaFragment newInstance(int columnCount) {
        NotaFragment fragment = new NotaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
                int numeroColumnas = (int) (dpWidth / 180);

                recyclerView.setLayoutManager(new StaggeredGridLayoutManager( numeroColumnas, StaggeredGridLayoutManager.VERTICAL));
            }
            notaList = new ArrayList<>();
            notaList.add(new Nota("La Fuerza Armada de Venezuela, ¿garante de la elección presidencial?","La Fuerza Armada de Venezuela ha sido pilar del chavismo desde que llegó al poder hace 25 años, pero la oposición aspira a que pueda ser garante de las elecciones del domingo, ¿será un actor determinante?", true, android.R.color.holo_blue_light));
            notaList.add(new Nota("Un avión con 19 ocupantes se estrelló en Nepal y el piloto es el único sobreviviente", "Dieciocho personas murieron el miércoles en Katmandú cuando el avión en el que viajaban se estrelló durante el despegue, un accidente en el que sólo sobrevivió el piloto, indicó la policía de la capital nepalí.",false, android.R.color.holo_green_light));
            notaList.add(new Nota("Globos norcoreanos con basura cayeron en el complejo presidencial surcoreano","Corea del Norte volvió a enviar globos cargados con basura al Sur, en respuesta a la propaganda emitida por Seúl contra el régimen de Kim Jong-un.", true, android.R.color.holo_orange_light));
            notaList.add(new Nota("Debut en Juegos Olímpicos: Argentina empató 2-2 a Marruecos en final con polémica","Conoce cómo seguir la transmisión del debut de Argentina Sub 23 vs Marruecos en vivo por el grupo B de los Juegos Olímpicos París 2024.", true, android.R.color.holo_orange_light));
            notaList.add(new Nota("Nacho se despide entre lágrimas de Real Madrid y provoca la emoción de Florentino Pérez [VIDEO]","\"Este club lo es todo para mí\", señaló Nacho que jugará en Al Qadsiah después de casi 24 años en Real Madrid.", true, android.R.color.holo_orange_light));
            notaList.add(new Nota("Fossati sobre Christian Cueva: Lejos de arrepentirnos de ayudarlo, estamos agradecidos de intentarlo","Nuestra parte está hecha, señaló Jorge Fossati respecto a Christian Cueva que jugó la Copa América a pesar de su falta de continuidad.", true, android.R.color.holo_orange_light));
            notaList.add(new Nota("¿Qué son las arritmias cardíacas y cómo reducir el riesgo de que aparezcan?","La arritmia es un trastorno del corazón que afecta el ritmo del mismo, que empieza a latir muy rápido o muy despacio, explica el doctor Elmer Huerta, consultor médico de RPP. Conoce más detalles en esta nota.", true, android.R.color.holo_orange_light));
            notaList.add(new Nota("Compromiso y respeto: conoce cómo cuidar la salud mental de los adultos mayores","¿Cómo garantizar el bienestar mental de los adultos mayores? Carla Marcos, psicóloga clínica y psicoterapeuta, ofrece valiosos consejos sobre el manejo de situaciones cruciales para su cuidado.", true, android.R.color.holo_orange_light));
            notaList.add(new Nota("¡Enfrenta el frío con calor! Estas son las 3 infusiones recomendadas para combatir el intenso frío","Jonathan Yupanqui, nutricionista de EsSalud, recomendó tres bebidas calientes ideales para aliviar síntomas inflamatorios, dolores de cabeza y posibles resfriados.", true, android.R.color.holo_orange_light));

            adapterNotas = new MyNotaRecyclerViewAdapter(notaList,mListener);
            recyclerView.setAdapter(adapterNotas);

        }
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof NotasInteractionListener){
            mListener = (NotasInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString()
                    + "Debe implementarse NotasInteractionListener");
        }
    }

}