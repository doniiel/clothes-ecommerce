package com.e_commerce.clothes.web.mappers;

import java.util.List;

public interface Mappable<E, D> {
    E toEntity(D d);
    D toDto(E e);
    List<D> toDto (List<E> e);
}
