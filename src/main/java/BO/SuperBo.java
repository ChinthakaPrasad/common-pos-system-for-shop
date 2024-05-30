package BO;

import java.util.List;

public interface SuperBo<T> {
    boolean save(T dto);
    boolean update(T dto);
    boolean delete(T dto);
    List<T> all();
}
