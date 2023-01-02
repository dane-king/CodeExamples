package predicate.validator;

import java.util.List;

public interface MessageBuilder<K> {

    List<String> getErrorMessages(K key);
}

