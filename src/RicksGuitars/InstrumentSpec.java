package RicksGuitars;

import Enums.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class InstrumentSpec {

    private Map<String, Object> properties = new HashMap<>();

    public InstrumentSpec() {

    }

    public InstrumentType getInstrumentType() {
        return (InstrumentType) get("InstrumentType");
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public InstrumentSpec setInstrumentType(InstrumentType instrumentType) {
        put(instrumentType);
        return this;
    }

    public Builder getBuilder() {
        return (Builder) get("Builder");
    }

    public InstrumentSpec setBuilder(Builder builder) {
        put(builder);
        return this;
    }

    public Model getModel() {
        return (Model) get("Model");
    }

    public InstrumentSpec setModel(Model model) {
        put(model);
        return this;
    }

    public InstrumentClass getInstrumentClass() {
        return (InstrumentClass) get("InstrumentClass");
    }

    public InstrumentSpec setClass(InstrumentClass instrumentClass) {
        put(instrumentClass);
        return this;
    }

    public int getNumStrings() {
        return (int) get("NumStrings");
    }

    public InstrumentSpec setNumStrings(int NumStrings) {
        properties.put("NumStrings", NumStrings);
        return this;
    }

    public Wood getTopWood() {
        return (Wood) get("TopWood");
    }

    public InstrumentSpec setTopWood(Wood TopWood) {
        properties.put("TopWood", TopWood);
        return this;
    }

    public Wood getBackWood() {
        return (Wood) get("BackWood");
    }

    public InstrumentSpec setBackWood(Wood BackWood) {
        properties.put("BackWood", BackWood);
        return this;
    }

    private String getNameOf(Object property) {
        return property.getClass().getSimpleName();
    }

    Object get(String key) {
        return properties.get(key);
    }

    private void put(Object value) {
        properties.put(getNameOf(value), value);
    }

    boolean matches(InstrumentSpec otherSpec) {
        return otherSpec.properties
                .keySet()
                .stream()
                .allMatch(valuesMatch(otherSpec));
    }

    private Predicate<String> valuesMatch(InstrumentSpec otherSpec) {
        return otherKey -> otherSpec.get(otherKey).equals(properties.get(otherKey));
    }
}
