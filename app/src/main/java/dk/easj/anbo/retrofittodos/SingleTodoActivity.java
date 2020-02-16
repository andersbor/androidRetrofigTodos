package dk.easj.anbo.retrofittodos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class SingleTodoActivity extends AppCompatActivity {
    public static final String TODO = "todo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_todo);

        Intent intent = getIntent();
        Todo todo = (Todo) intent.getSerializableExtra(TODO);

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
}
