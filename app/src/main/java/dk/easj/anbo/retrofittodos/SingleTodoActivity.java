package dk.easj.anbo.retrofittodos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleTodoActivity extends AppCompatActivity {
    public static final String TODO = "todo";
    private static final String LOG_TAG = "MYTODOS";
    private Todo todo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_todo);

        Intent intent = getIntent();
        todo = (Todo) intent.getSerializableExtra(TODO);

        TextView idView = findViewById(R.id.singleTodoIdTextView);
        EditText userIdView = findViewById(R.id.singleTodoUserIdEditText);
        EditText titleView = findViewById(R.id.singleTodoTitleEditText);
        CheckBox completedView = findViewById(R.id.singleTodoCompletedCheckBox);

        idView.setText(todo.getId() + "");
        userIdView.setText(todo.getUserId() + "");
        titleView.setText(todo.getTitle());
        completedView.setChecked(todo.getCompleted());
    }

    public void backButtonClicked(View view) {
        finish();
    }

    public void deleteButtonClicked(View view) {
        // TODO DELETE

        TodoService todoService = ApiUtils.getTodoService();
        Call<Void> deleteCall = todoService.deleteTodo(todo.getId());
        deleteCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d(LOG_TAG, response.code() + " " + response.message());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d(LOG_TAG, t.getMessage());
            }
        });
    }
}
