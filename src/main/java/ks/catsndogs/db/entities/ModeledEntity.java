package ks.catsndogs.db.entities;

import java.io.Serializable;

public interface ModeledEntity<M> extends Serializable {
    M toModel();
}
