package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

/**
 * Товары
 */
@Entity
@Table(name = "GOODS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Goods extends BaseEntity{
    private static final long serialVersionUID = -935293741889753637L;

        /**
         * Наименование продукта
         */
        @Column(name = "Production_FK")
        private int productionName;

        /**
         * Наименование сорта
         */
        @Column(name = "Name_Variety")
        private String varietyName;

        /**
         * Годен до
         */
        @Column(name = "Shelf_Life")
        @Temporal(TemporalType.TIMESTAMP)
        private Date shelfLife;

        /**
         * Ед.изм
         */
        @Column(name = "Unit_FK")
        private int unitName;

        /**
         * Наименование производителя
         */
        @Column(name = "Name_Manufacture")
        private String manufactureName;

        /**
         * Страна происхождения
         */
        @Column(name = "Manufacture_Country")
        private String manufactureCountry;
}
