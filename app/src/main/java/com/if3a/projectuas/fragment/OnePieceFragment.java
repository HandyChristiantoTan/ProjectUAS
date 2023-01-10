package com.if3a.projectuas.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.if3a.projectuas.R;
import com.if3a.projectuas.adapter.AdapterOnePiece;
import com.if3a.projectuas.api.APIRequestData;
import com.if3a.projectuas.api.RetroServer;
import com.if3a.projectuas.model.RootOnePiece;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OnePieceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OnePieceFragment extends Fragment {
    private RecyclerView rvOnePiece;
    private ProgressBar pbOnePiece;
    private List<RootOnePiece> listOnePiece = new ArrayList<>();
    private AdapterOnePiece adapterOnePiece;
    private LinearLayoutManager linearLayoutManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OnePieceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OnePieceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OnePieceFragment newInstance(String param1, String param2) {
        OnePieceFragment fragment = new OnePieceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one_piece, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable
            Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvOnePiece = view.findViewById(R.id.rv_onepiece);
        pbOnePiece = view.findViewById(R.id.pb_onepiece);


        linearLayoutManager = new LinearLayoutManager(getView().getContext(), LinearLayoutManager.VERTICAL, false);
        rvOnePiece.setLayoutManager(linearLayoutManager);
        getActivity().setTitle("One Piece Quotes");
    }
    public void retrieveOnePiece() {
        pbOnePiece.setVisibility(View.VISIBLE);

        APIRequestData API = RetroServer.getRetrofit().create(APIRequestData.class);
        Call<List<RootOnePiece>> retrieveProcess = API.getOnePiece();

        retrieveProcess.enqueue(new Callback<List<RootOnePiece>>() {
            @Override
            public void onResponse(Call<List<RootOnePiece>> call, Response<List<RootOnePiece>> response) {
                listOnePiece = response.body();
                adapterOnePiece = new AdapterOnePiece(listOnePiece);
                rvOnePiece.setAdapter(adapterOnePiece);

                pbOnePiece.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<RootOnePiece>> call, Throwable t) {
                Toast.makeText(getView().getContext(), "Gagal Menghubungi Server : " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
                pbOnePiece.setVisibility(View.INVISIBLE);
            }
        });

    }
    @Override
    public void onResume() {
        super.onResume();
        retrieveOnePiece();
    }

}