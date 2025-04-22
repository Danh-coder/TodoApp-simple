package com.example.logbook_todoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> tasks;
    private OnEditClickListener onEditClickListener;
    private OnDeleteClickListener onDeleteClickListener;

    public TaskAdapter(List<Task> tasks, OnEditClickListener onEditClickListener, OnDeleteClickListener onDeleteClickListener) {
        this.tasks = tasks;
        this.onEditClickListener = onEditClickListener;
        this.onDeleteClickListener = onDeleteClickListener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task currentTask = tasks.get(position);
        holder.taskNameTextView.setText(currentTask.getName());

        holder.editButton.setOnClickListener(v -> onEditClickListener.onEditClick(currentTask));
        holder.deleteButton.setOnClickListener(v -> onDeleteClickListener.onDeleteClick(currentTask));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public TextView taskNameTextView;
        public Button editButton;
        public Button deleteButton;

        public TaskViewHolder(View itemView) {
            super(itemView);
            taskNameTextView = itemView.findViewById(R.id.taskNameTextView);
            editButton = itemView.findViewById(R.id.editTaskButton);
            deleteButton = itemView.findViewById(R.id.deleteTaskButton);
        }
    }

    public interface OnEditClickListener {
        void onEditClick(Task task);
    }

    public interface OnDeleteClickListener {
        void onDeleteClick(Task task);
    }
}