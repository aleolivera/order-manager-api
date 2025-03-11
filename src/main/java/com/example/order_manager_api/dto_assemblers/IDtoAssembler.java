package com.example.order_manager_api.dto_assemblers;

import java.util.Collection;

public interface IDtoAssembler<T,DTO>{
    DTO toDto(T entity);
    Collection<DTO>toCollection(Collection<T> collection);
}
