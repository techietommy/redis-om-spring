package com.redis.om.spring.search.stream.actions;

import java.lang.reflect.Field;
import java.util.function.ToLongFunction;

import com.redislabs.modules.rejson.Path;

public class ArrayLengthAction<E> extends BaseAbstractAction implements ToLongFunction<E> {

  public ArrayLengthAction(Field field) {
    super(field);
  }

  @Override
  public long applyAsLong(E value) {
    return json.arrLen(getKey(value), Path.of("." + field.getName()));
  }

}
