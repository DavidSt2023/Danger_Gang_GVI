package v2;

public interface Observer<T> {
    void update(Subject<T> subject, T data);
}