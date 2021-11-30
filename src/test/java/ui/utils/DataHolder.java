package ui.utils;

import ui.entity.User;

import java.util.*;

public final class DataHolder {
    private final Map<String, Object> tempData = new HashMap<>();
    private User currentUser;

    public Object getTempData(final String key) {
        return tempData.get(key);
    }

    public void setTempData(final String key, Object value) {
        this.tempData.put(key, value);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}