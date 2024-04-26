package patterns.behavioral.adapter;

import java.util.function.Function;

/**
 * converts to and from a DTO
 * @param <D> is the DTO class
 * @param <E> is the Entity or Domain class
 */
public class GenericMapper<D, E> {
    private final Function<E, D> toDto;
    private final Function<D, E> toEntity;

    public GenericMapper(Function<E, D> toDto, Function<D, E> toEntity) {
        this.toDto = toDto;
        this.toEntity = toEntity;
    }

    public D toDto(E entity) {
        return toDto.apply(entity);
    }

    public E toEntity(D target) {
        return toEntity.apply(target);
    }
}