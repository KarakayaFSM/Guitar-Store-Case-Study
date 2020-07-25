package RicksGuitars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {

    private static List<Instrument> inventory;

    public Inventory() {
        inventory = new ArrayList<>();
    }

    public void addInstrument(String serialNumber, double price,
                              InstrumentSpec spec) {
        Instrument instrument = new Instrument(serialNumber, price, spec);
        inventory.add(instrument);
    }

    public Instrument getBySerialNumber(String serialNumber) {
        for (Instrument instrument : inventory) {
            if (instrument.getSerialNumber().equals(serialNumber)) {
                return instrument;
            }
        }
        return null;
    }

    private static List<Instrument> search(InstrumentSpec searchSpec) {
        return inventory.stream()
                .filter(instrument -> instrument.getSpec().matches(searchSpec))
                .collect(Collectors.toList());
    }

    public static void searchFor(InstrumentSpec inputSpec) {

        List<Instrument> matchingInstruments = search(inputSpec);

        if (matchingInstruments.isEmpty()) {
            System.out.println("Sorry, Bryan, we have nothing for you.");
            return;
        }

        System.out.println("Bryan, you might like these instruments:");
        matchingInstruments.forEach(Instrument::printIntro);
    }

}
