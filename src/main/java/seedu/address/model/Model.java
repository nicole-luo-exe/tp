package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.person.Elderly;
import seedu.address.model.task.Task;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} for elderly lists that always evaluate to true */
    Predicate<Elderly> PREDICATE_SHOW_ALL_ELDERLIES = unused -> true;

    /** {@code Predicate} for task lists that always evaluate to true */
    Predicate<Task> PREDICATE_SHOW_ALL_TASKS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code versionedNurseyBook}.
     */
    void setVersionedNurseyBook(ReadOnlyAddressBook versionedNurseyBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getVersionedNurseyBook();

    /**
     * Returns true if a elderly with the same identity as {@code elderly} exists in the address book.
     */
    boolean hasElderly(Elderly elderly);

    /**
     * Returns true if a task {@code task} exists in the address book.
     */
    boolean hasTask(Task t);

    /**
     * Mark the given task {@code target} as done.
     * {@code target} must exist in the address book.
     */
    void markTaskAsDone(Task target);

    /**
     * Deletes the given elderly.
     * The elderly must exist in the address book.
     */
    void deleteElderly(Elderly target);

    /**
     * Adds the given elderly.
     * {@code elderly} must not already exist in the address book.
     */
    void addElderly(Elderly elderly);

    /**
     * Adds the given task.
     */
    void addTask(Task task);

    /**
     * Replaces the given elderly {@code target} with {@code editedElderly}.
     * {@code target} must exist in the address book.
     * The elderly identity of {@code editedElderly} must not be the same as another existing elderly
     * in the address book.
     */
    void setElderly(Elderly target, Elderly editedElderly);

    /** Returns an unmodifiable view of the filtered elderly list */
    ObservableList<Elderly> getFilteredElderlyList();

    /** Returns an unmodifiable view of the filtered task list */
    ObservableList<Task> getFilteredTaskList();

    /**
     * Updates the filter of the filtered elderly list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredElderlyList(Predicate<Elderly> predicate);

    /**
     * Updates the filter of the filtered task list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredTaskList(Predicate<Task> predicate);

    /**
     * Deletes the given task.
     * The task must exist in the address book.
     */
    void deleteTask(Task taskToDelete);

    /**
     * Saves the change in data of NurseyBook.
     */
    void commitNurseyBook(CommandResult commandResult);

    /**
     * Undoes the previous command and returns the {@code CommandResult} of the command being undone.
     */
    CommandResult undoNurseyBook();

    /**
     * Returns true if there are changes to the NurseyBook that can be undone.
     */
    boolean canUndoNurseyBook();

    /**
     * Undoes the previous command and returns the {@code CommandResult} of the command being undone.
     */
    CommandResult redoNurseyBook();

    /**
     * Returns true if there are changes to the NurseyBook that can be redone.
     */
    boolean canRedoNurseyBook();

}
