package icu.samnyan.aqua.sega.diva.model.gamedata;

import icu.samnyan.aqua.sega.diva.model.Internalizable;
import icu.samnyan.aqua.sega.diva.util.DivaDateTimeUtil;
import icu.samnyan.aqua.sega.util.URIEncoder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Entity(name = "DivaModule")
@Table(name = "diva_module")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DivaModule implements Serializable, Internalizable {

    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    private String name;

    private int price;

    private LocalDateTime releaseDate;

    private LocalDateTime endDate;

    private int sortOrder;

    @Override
    public String toInternal() {
        return id + ",0," +
                URIEncoder.encode(name) + "," +
                price + "," +
                DivaDateTimeUtil.format(releaseDate) + "," +
                DivaDateTimeUtil.format(endDate) + "," +
                sortOrder;
    }
}
