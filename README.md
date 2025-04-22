# Simple Android To-Do App

📝 A basic Android application for managing your daily tasks with add, edit, and delete functionality.

This project demonstrates fundamental Android UI components, RecyclerView implementation, and dialog management for creating a simple task management application.

## Features

*   **Add New Tasks:** Easily create new tasks via a simple dialog.
*   **Edit Existing Tasks:** Modify task names using the same intuitive dialog interface.
*   **Delete Tasks:** Remove completed or unwanted tasks with a confirmation step.
*   **Task List Display:** View all your tasks in a vertically scrolling list using `RecyclerView`.
*   **Floating Action Button (FAB):** Quick access to the 'Add New Task' function, following Material Design patterns.
*   **Basic Input Validation:** Prevents saving tasks with empty names.
*   **Confirmation Dialog:** Prompts users before deleting a task to prevent accidental removal.
*   **Real-time Updates:** List updates automatically after adding, editing, or deleting tasks.

## Design

The application interface is designed for simplicity and ease of use:

*   **Main Screen:** Utilizes a `ConstraintLayout` to hold a full-height `RecyclerView` for displaying tasks and a `FloatingActionButton` anchored to the bottom-right corner.
*   **Task Item Layout:** Each task in the list is represented by a horizontal `LinearLayout` containing a `TextView` for the task name and two `Button`s for 'Edit' and 'Delete'. The task name `TextView` expands to fill available space using `layout_weight`.
*   **Add/Edit Dialog:** A simple dialog pops up with a vertical `LinearLayout` containing an `EditText` for the task name and a horizontal `LinearLayout` below it for 'Cancel' and 'Save' buttons.
*   **Material Design:** Incorporates a Material Design FAB for a modern look and feel.
*   **Feedback:** Provides visual feedback through dialogs (add/edit, delete confirmation) and toast messages (empty input).

## Installation and Setup

To build and run this project, you will need Android Studio.

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/Danh-coder/TodoApp-simple.git
    ```

2.  **Open in Android Studio:**
    *   Launch Android Studio.
    *   Select "Open an Existing Android Studio Project".
    *   Navigate to the cloned directory and select it.

3.  **Build and Run:**
    *   Android Studio will sync the project dependencies.
    *   Connect an Android device or start an AVD (Android Virtual Device) emulator.
    *   Click the "Run" button (green play icon) in the toolbar.
    *   Choose your connected device or emulator to deploy the app.

## Code Overview

The project is structured into several key files:

*   **`layout/activity_main.xml`**:
    *   Defines the layout for the main screen.
    *   Uses `ConstraintLayout` to position the `RecyclerView` and the `FloatingActionButton`.
    *   The `RecyclerView` (`@+id/tasksRecyclerView`) displays the list of tasks.
    *   The `FloatingActionButton` (`@+id/addTaskFab`) triggers the add task dialog.

*   **`layout/task_item.xml`**:
    *   Defines the layout for a single row in the `RecyclerView`.
    *   Uses a `LinearLayout` (horizontal orientation).
    *   Contains a `TextView` (`@+id/taskNameTextView`) for the task title.
    *   Includes two `Button`s (`@+id/editTaskButton`, `@+id/deleteTaskButton`) for actions.

*   **`layout/dialog_add_edit_task.xml`**:
    *   Defines the layout used within the add/edit task dialog.
    *   Uses a `LinearLayout` (vertical orientation).
    *   Contains an `EditText` (`@+id/taskNameEditText`) for entering the task name.
    *   Includes a nested `LinearLayout` (horizontal orientation) for the 'Cancel' (`@+id/cancelButton`) and 'Save' (`@+id/saveButton`) buttons.

*   **`MainActivity.java`**:
    *   The main activity and central controller of the application.
    *   Initializes the `RecyclerView`, `TaskAdapter`, and `FloatingActionButton`.
    *   Manages the list of tasks (`List<Task>`).
    *   Implements methods to show the add/edit dialog (`showAddTaskDialog`, `editTask`) and the delete confirmation dialog (`deleteTask`).
    *   Handles button clicks from the FAB and task item buttons (via callbacks to `editTask` and `deleteTask`).
    *   Adds (`addTask`), edits (`editTask`), and removes (`deleteTask`) tasks from the list and notifies the adapter of changes.
    *   Uses `AlertDialog.Builder` and `LayoutInflater` to create and display custom dialogs.

*   **`Task.java`**:
    *   A simple Plain Old Java Object (POJO) representing a single task.
    *   Contains a `private String name` property.
    *   Provides a constructor and getter/setter methods (`getName()`, `setName()`) for the task name.

*   **`TaskAdapter.java`**:
    *   The adapter responsible for binding `Task` objects to the `task_item.xml` layout for display in the `RecyclerView`.
    *   Extends `RecyclerView.Adapter`.
    *   Uses the ViewHolder pattern (`TaskViewHolder`) for efficient view recycling.
    *   Implements `onCreateViewHolder`, `onBindViewHolder`, and `getItemCount`.
    *   Sets click listeners on the 'Edit' and 'Delete' buttons within each list item and calls interface callbacks (`OnEditClickListener`, `OnDeleteClickListener`) which are implemented in `MainActivity`.

## Future Improvements

Based on the current implementation and report suggestions, potential enhancements include:

*   **Empty State Feedback:** Display a "No tasks yet" or similar message when the task list is empty to improve user experience.
*   **Button Styling:** Improve the visual distinction between the "Cancel" and "Save" buttons in the dialog (e.g., use an outlined style for "Cancel").
*   **Data Persistence:** Implement data storage (e.g., SQLite database, SharedPreferences, Room Persistence Library) so tasks persist even after the app is closed. Currently, the list is stored only in memory.
*   **MVVM Architecture:** Refactor the code to use a ViewModel to move business logic out of `MainActivity`, improving maintainability, testability, and scalability.
*   **More Task Details:** Add fields for task description, due date, priority, completion status, etc.
*   **Sorting/Filtering:** Allow users to sort or filter tasks.

## Technologies Used

*   Java
*   Android SDK
*   XML
*   Material Design Components

## Contributing

Contributions are welcome! If you find a bug or have a suggestion, please open an issue or submit a pull request.

## Author

*   Danh Phan
