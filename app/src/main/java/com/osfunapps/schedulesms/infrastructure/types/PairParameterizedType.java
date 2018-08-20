package com.osfunapps.schedulesms.infrastructure.types;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import kotlin.Pair;

public class PairParameterizedType implements ParameterizedType {

    public Type typeA;
    public Type typeB;

    public PairParameterizedType(Type typeA, Type typeB) {
        this.typeA = typeA;
        this.typeB = typeB;
    }


    @Override
    public Type[] getActualTypeArguments() {
        return new Type[] {typeA, typeB};
    }

    @Override
    public Type getRawType() {
        return Pair.class;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }

    public Type getType() {
        return typeA;
    }


}