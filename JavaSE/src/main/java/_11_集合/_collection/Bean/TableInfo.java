package _11_集合._collection.Bean;

import java.util.Objects;

public class TableInfo {
    private String name;
    private String Type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableInfo tableInfo = (TableInfo) o;
        return name.equals(tableInfo.name) && Type.equals(tableInfo.Type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Type);
    }
}
