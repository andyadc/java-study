package com.andyadc.study.mapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;

/**
 * @author andaicheng
 * @version 2016/11/14
 */
public class OrikaBeanMapper {

    private static MapperFacade facade = null;

    static {
        MapperFactory factory = new DefaultMapperFactory.Builder().build();
        facade = factory.getMapperFacade();
    }

    public static <S, D> D mapper(S source, Class<D> destinationClass) {
        return facade.map(source, destinationClass);
    }

    public static <S, D> List<D> mapList(Iterable<S> sourceList, Class<D> destinationClass) {
        return facade.mapAsList(sourceList, destinationClass);
    }
}
