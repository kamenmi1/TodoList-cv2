package cz.uhk.fim.todolist.gui;

import cz.uhk.fim.todolist.Model.TodoItem;
import cz.uhk.fim.todolist.Model.TodoList;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

public class TodoTableModel extends AbstractTableModel {

    private TodoList todoList;

    public void setList(TodoList todoList) {
        this.todoList = todoList;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return todoList.getItemCount();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TodoItem item = todoList.getItemByIndex(rowIndex);
        switch (columnIndex) {
            case 0:
                return item.getTitle();
            case 1:
                return item.isComplete();
            case 2:
                return item.getDateTime();
            default:
                return "?";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        TodoItem item = todoList.getItemByIndex(rowIndex);
        switch (columnIndex){
            case 0:
                item.setTitle((String) aValue);
                break;
            case 1:
                item.setComplete((Boolean) aValue);
                break;
            default:
                break;
        }
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "Název";
            case 1:
                return "Dokončeno";
            case 2:
                return "Datum a čas dokončeno";
            default:
                return "?";
        }
    }
}
