document.addEventListener('DOMContentLoaded', () => {
    const taskInput = document.getElementById('taskInput');
    const addTaskBtn = document.getElementById('addTaskBtn');
    const taskList = document.getElementById('taskList');
    const taskCount = document.getElementById('taskCount');
    const clearAllBtn = document.getElementById('clearAllBtn');

    let tasks = JSON.parse(localStorage.getItem('tasks')) || [];

    const updateUI = () => {
        taskList.innerHTML = '';
        tasks.forEach((task, index) => {
            const li = document.createElement('li');
            li.className = task.completed ? 'completed' : '';
            li.innerHTML = `
                <span class="task-text" onclick="toggleTask(${index})">${task.text}</span>
                <button class="delete-btn" onclick="deleteTask(${index})">
                    <svg width="20" height="20" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16"></path>
                    </svg>
                </button>
            `;
            taskList.appendChild(li);
        });
        
        const remaining = tasks.filter(t => !t.completed).length;
        taskCount.textContent = `${remaining} task${remaining !== 1 ? 's' : ''} remaining`;
        localStorage.setItem('tasks', JSON.stringify(tasks));
    };

    window.addTask = () => {
        const text = taskInput.value.trim();
        if (text) {
            tasks.push({ text, completed: false });
            taskInput.value = '';
            updateUI();
        }
    };

    window.deleteTask = (index) => {
        tasks.splice(index, 1);
        updateUI();
    };

    window.toggleTask = (index) => {
        tasks[index].completed = !tasks[index].completed;
        updateUI();
    };

    window.clearAll = () => {
        if (confirm('Are you sure you want to clear all tasks?')) {
            tasks = [];
            updateUI();
        }
    };

    addTaskBtn.addEventListener('click', addTask);
    taskInput.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') addTask();
    });
    clearAllBtn.addEventListener('click', clearAll);

    updateUI();
});
