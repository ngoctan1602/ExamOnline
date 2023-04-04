package app.ntnt.recycleviewfinalproject.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import app.ntnt.recycleviewfinalproject.model.Topic;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TestAPI {
    Gson gson = new GsonBuilder().setDateFormat("dd:MM:yyyy").create();
    TestAPI testApi = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(TestAPI.class);
    @GET("posts")
    Call<List<Topic>> getListTopic(@Query("userId") int id);
}
