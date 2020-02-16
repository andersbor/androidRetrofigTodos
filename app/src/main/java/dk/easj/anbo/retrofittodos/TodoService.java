package dk.easj.anbo.retrofittodos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TodoService {

    @GET("todos")
    Call<List<Todo>> getAllTodos();

    @DELETE("todos/{id}")
    Call<Void> deleteTodo(@Path("id") int id);
}
