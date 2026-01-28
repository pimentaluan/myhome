package myhome.state;

import java.util.ArrayList;
import java.util.List;

public class StatusChangeDispatcher {
    private final List<StatusChangeListener> listeners = new ArrayList<>();

    public void registrar(StatusChangeListener listener) {
        listeners.add(listener);
    }

    public void disparar(StatusChangeEvent event) {
        for (var l : listeners) {
            l.onStatusChanged(event);
        }
    }
}