package predicate.validator;

import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;

public interface MessageBuilder<K> {

    List<String> getErrorMessages(K key);
}

