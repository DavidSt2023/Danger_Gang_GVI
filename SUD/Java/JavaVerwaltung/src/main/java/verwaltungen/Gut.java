package verwaltungen;

import lombok.Getter;
import utils.ToStringUtil;

import java.util.Objects;

@Getter
public class Gut {
    private final String name;
    private final int id;
    private final int menge;
    private final String mengeType;

    public Gut(String name, int id, int menge,String mengeType) {
        this.name = name;
        this.id = id;
        this.menge = menge;
        this.mengeType = mengeType;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}