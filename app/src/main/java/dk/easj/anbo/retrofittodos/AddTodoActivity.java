package dk.easj.anbo.retrofittodos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTodoActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MYTODOS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);
    }

    public void addTodoButtonClicked(View view) {
        Log.d(LOG_TAG, "addTodoButtonClicked started");
        EditText userIdField = findViewById(R.id.addTodoUserIdEditText);
        EditText titleField = findViewById(R.id.addTodoTitleEditText);
        CheckBox checkBoxField = findViewById(R.id.addTodoCompletedCheckBox);
        String userIdString = userIdField.getText().toString().trim();
        String title = titleField.getText().toString().trim();
        boolean completed = checkBoxField.isChecked();
        int userId = Integer.parseInt(userIdString); // TODO handle exception

        Todo todo = new Todo();
        todo.setUserId(userId);
        todo.setTitle(title);
        todo.setCompleted(completed);

        Log.d(LOG_TAG, userId + " " + title + " " + completed);

        TodoService todoService = ApiUtils.getTodoService();

        Call<TodoId> addTodoCall = todoService.addTodo(todo);

        addTodoCall.enqueue(new Callback<TodoId>() {
            @Override
            public void onResponse(Call<TodoId> call, Response<TodoId> response) {
                if (response.isSuccessful()) {
                    Log.d(LOG_TAG, "Works: " + response.code() + " " + response.message() + " " + response.body().getId());
                } else {
                    Log.d(LOG_TAG, response.code() + " " + response.message());
                }
            }

            @Override
            public void onFailure(Call<TodoId> call, Throwable t) {
                Log.e(LOG_TAG, t.getMessage());
            }
        });

    }
}
