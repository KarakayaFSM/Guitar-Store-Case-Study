package RicksGuitars;

import Enums.*;

public class FindInstrumentTester {

    public static void main(String[] args) {
        // Set up Rick's inventory
        initializeInventory();

        InstrumentSpec whatBryanLikes = new InstrumentSpec()
                .setModel(Model.Stratocastor);
//                .setClass(InstrumentClass.ACOUSTIC)
//                .setBuilder(Builder.FENDER)
//                .setBackWood(Wood.SITKA);

        Inventory.searchFor(whatBryanLikes);

    }

    private static Inventory initializeInventory() {
        Inventory inventory = new Inventory();

        InstrumentSpec aGuitar = getSampleGuitar();
        inventory.addInstrument("11277", 3999.95, aGuitar);

        InstrumentSpec anInstrument = getSampleInstrument();
        inventory.addInstrument("122784", 5495.95, anInstrument);

        InstrumentSpec anotherInstrument = getAnotherInstrument();
        inventory.addInstrument("V95693", 1499.95, anotherInstrument);

        InstrumentSpec instrument = getAnotherInstrument(Model.RB_3_Wreath);
        inventory.addInstrument("V9512", 1549.95, instrument);

        InstrumentSpec instrument1 = getAnotherInstrument(Builder.GIBSON);
        inventory.addInstrument("70108276", 2295.95, instrument1);

        return inventory;
    }

    private static InstrumentSpec getAnotherInstrument() {
        return new InstrumentSpec()
                .setBuilder(Builder.FENDER)
                .setModel(Model.Stratocastor)
                .setTopWood(Wood.ALDER)
                .setBackWood(Wood.ALDER);
    }

    private static InstrumentSpec getAnotherInstrument(Builder builder) {
        return new InstrumentSpec()
                .setBuilder(builder)
                .setModel(Model.Stratocastor)
                .setTopWood(Wood.ALDER)
                .setBackWood(Wood.ALDER);
    }

    private static InstrumentSpec getAnotherInstrument(Model model) {
        return new InstrumentSpec()
                .setBuilder(Builder.FENDER)
                .setModel(model)
                .setTopWood(Wood.ALDER)
                .setBackWood(Wood.ALDER);
    }

    private static InstrumentSpec getSampleInstrument() {
        return new InstrumentSpec()
                .setBuilder(Builder.MARTIN)
                .setModel(Model.D_18)
                .setTopWood(Wood.MAHOGANY)
                .setBackWood(Wood.ADIRONDACK);
    }

    private static InstrumentSpec getSampleGuitar() {
        return new InstrumentSpec()
                .setInstrumentType(InstrumentType.GUITAR)
                .setBuilder(Builder.GIBSON)
                .setModel(Model.CJ)
                .setClass(InstrumentClass.ACOUSTIC)
                .setNumStrings(6)
                .setTopWood(Wood.INDIAN_ROSEWOOD)
                .setBackWood(Wood.MAPLE);
    }


}
