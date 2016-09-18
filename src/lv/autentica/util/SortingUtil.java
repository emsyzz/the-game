package lv.autentica.util;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingUtil
{

    public static Map<String, Integer> sortHashMap(Map<String, Integer> map)
    {
        Comparator<Map.Entry<String, Integer>> valueComparator = (e1, e2) -> e2.getValue().compareTo(e1.getValue());
        return map.entrySet().stream().sorted(valueComparator)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }
}
