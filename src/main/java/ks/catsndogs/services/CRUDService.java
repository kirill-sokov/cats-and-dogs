package ks.catsndogs.services;

import java.util.List;

public interface CRUDService<I, M, U> {

    M add(M model);

    void remove(I index);

    M update(I index, U updateModel);

    M get(I index);

    List<M> getAll();
}
