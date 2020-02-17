package dk.easj.anbo.retrofittodos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TodoService {

    @GET("todos")
    Call<List<Todo>> getAllTodos();

    @DELETE("todos/{id}")
    Call<Void> deleteTodo(@Path("id") int id);

    @POST("/todos")
    // @FormUrlEncoded
    Call<TodoId> addTodo(@Body Todo todo);
}
