package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldFindSimpleTaskByTitle() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");

        Assertions.assertTrue(task.matches("родителям"));
    }

    @Test
    public void shouldNotFindSimpleTaskByTitle() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");

        Assertions.assertFalse(task.matches("магазин"));
    }

    @Test
    public void shouldFindEpicBySubtask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);

        Assertions.assertTrue(epic.matches("Яйца"));
    }

    @Test
    public void shouldNotFindEpicBySubtask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);

        Assertions.assertFalse(epic.matches("Сыр"));
    }

    @Test
    public void shouldFindMeetingByTopic() {
        Meeting meeting = new Meeting(
                3,
                "Выкатка приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Assertions.assertTrue(meeting.matches("Выкатка"));
    }

    @Test
    public void shouldFindMeetingByProject() {
        Meeting meeting = new Meeting(
                3,
                "Выкатка приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Assertions.assertTrue(meeting.matches("НетоБанк"));
    }

    @Test
    public void shouldNotFindMeeting() {
        Meeting meeting = new Meeting(
                3,
                "Выкатка приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Assertions.assertFalse(meeting.matches("магазин"));
    }
}
