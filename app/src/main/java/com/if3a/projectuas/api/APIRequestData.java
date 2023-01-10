package com.if3a.projectuas.api;

import com.if3a.projectuas.model.RootNaruto;
import com.if3a.projectuas.model.RootOnePiece;
import com.if3a.projectuas.model.RootSAO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequestData {
    @GET("anime?title=naruto")
    Call<List<RootNaruto>> getNaruto();

    @GET ("anime?title=one.piece")
    Call<List<RootOnePiece>> getOnePiece();

    @GET ("anime?title=sword.art.online")
    Call<List<RootSAO>> getSwordArtOnline();
}
