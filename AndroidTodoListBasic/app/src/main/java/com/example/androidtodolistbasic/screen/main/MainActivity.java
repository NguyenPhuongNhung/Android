package com.example.androidtodolistbasic.screen.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidtodolistbasic.R;
import com.example.androidtodolistbasic.database.AppDatabase;
import com.example.androidtodolistbasic.model.Todo;
import com.example.androidtodolistbasic.screen.add.AddTodoActivity;
import com.example.androidtodolistbasic.screen.update.UpdateActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    AppDatabase db;
    Button btnAdd;
    RecyclerView rvTodo;
    TodoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        btnAdd = findViewById(R.id.button_add);
        rvTodo = findViewById(R.id.recycler_todo);
        rvTodo.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvTodo.setLayoutManager(new LinearLayoutManager(this));

        adapter = new TodoAdapter();
        adapter.listener = new TodoAdapter.OnItemClickListener(){

            @Override
            public void onUpdateClick(int position) {
                openUpdateTodoScreen(adapter.todos.get(position));
            }

            @Override
            public void onDeleteClick(int position) {

            }
        };
        rvTodo.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddTodoScreen();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getTodoFromDatabase();
    }

    @SuppressLint("StaticFieldLeak")
    private void getTodoFromDatabase(){
        new AsyncTask<Void, Void, List<Todo>>(){

            @Override
            protected List<Todo> doInBackground(Void... voids) {
                return db.todoDao().getAll();
            }

            @Override
            protected void onPostExecute(List<Todo> todos) {
                super.onPostExecute(todos);
                adapter.todos = todos;
                adapter.notifyDataSetChanged();
            }
        }.execute();
    }

    private void openAddTodoScreen() {
        startActivity(new Intent(MainActivity.this, AddTodoActivity.class));
    }

    private void openUpdateTodoScreen(Todo todo){
        Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
        intent.putExtra("id", todo.getId());
        intent.putExtra("title", todo.getTitle());
        intent.putExtra("date", todo.getDate());
        startActivity(intent);
    }
}
