package icu.samnyan.aqua.sega.ongeki.model.common;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
public enum ItemType {
    None,
    Card,
    NamePlate,
    Trophy,
    LimitBreakItem,
    AlmightyJewel,
    Money,
    Music,
    ProfileVoice,
    Present,
    ChapterJewel,
    GachaTicket,
    Max;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
